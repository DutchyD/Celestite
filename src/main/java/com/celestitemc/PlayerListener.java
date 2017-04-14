package com.celestitemc;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.text.Text;

public class PlayerListener {

    private Celestite celestite;

    public PlayerListener(Celestite celestite) {
        this.celestite = celestite;
    }

    @Listener
    public void onJoin(ClientConnectionEvent.Join event) {

        event.setMessageCancelled(true);

        Text messageToPlayer = Text.of("Welcome to the server, fams.");

        event.getTargetEntity().sendMessage(messageToPlayer);

        Player connectedPlayer = event.getTargetEntity();

        String connectedPlayerName = connectedPlayer.getName();

        Text messageToAllPlayers = Text.of(connectedPlayerName + " has come online, fams.");

        for (Player player : Sponge.getServer().getOnlinePlayers()) {

            if (player != connectedPlayer)
                player.sendMessage(messageToAllPlayers);

        }
    }

    @Listener
    public void onLeave(ClientConnectionEvent.Disconnect event) {

        event.setMessageCancelled(true);

        Player disconnectedPlayer = event.getTargetEntity();

        String disconnectedPlayerName = disconnectedPlayer.getName();

        Text message = Text.of(disconnectedPlayerName + " has gone offline, fams.");

        for (Player player : Sponge.getServer().getOnlinePlayers()) {

            player.sendMessage(message);

        }

    }
}
