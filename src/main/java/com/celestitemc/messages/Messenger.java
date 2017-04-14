package com.celestitemc.messages;

import com.celestitemc.Celestite;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dutchy on 26-3-2017.
 * This file is part of the Karbonite Engine
 */
public class Messenger {

    private Celestite plugin;
    private Map<Class<?>, RecipientHandler> recipientHandlers = new HashMap<>();

    public Messenger(Celestite plugin) {
        this.plugin = plugin;

        registerRecipient(Player.class, new RecipientHandler() {
            @Override
            public void sendMessage(Object recipient, Text message) {
                ((Player) recipient).sendMessage(message);
            }
        });
        registerRecipient(Server.class, new RecipientHandler() {
            @Override
            public void sendMessage(Object recipient, Text message) {
                ((Server) recipient).getConsole().sendMessage(message);
            }
        });
    }

    @SuppressWarnings("rawtypes")
    public Messenger registerRecipient(Class recipientClass, RecipientHandler recipientHandler) {
        recipientHandlers.put(recipientClass, recipientHandler);
        return this;
    }

    public void sendMessage(Object recipient, Level prefix, Message message, Object... replace) {
        for (String string : (replace == null ? message.toString() : String.format(message.toString(), (Object[]) replace)).split("\\\\n")) {

            Text text = Text.builder().append(prefix.getText()).append(Text.of(TextColors.AQUA, " " + string)).build();

            sendTextMessage(recipient, text);
        }
    }

    public void sendTextMessage(Object recipient, Text message) {
        if (recipient != null && message != null) {
            for (Class<?> recipientClass : recipientHandlers.keySet()) {
                if (recipientClass.isAssignableFrom(recipient.getClass())) {
                    recipientHandlers.get(recipientClass).sendMessage(recipient, message);
                    break;
                }
            }
        }
    }

    public abstract class RecipientHandler {

        public abstract void sendMessage(Object recipient, Text message);

    }
}