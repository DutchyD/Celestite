package com.celestitemc.commands;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

/**
 * Created by Dutchy on 8-12-2016.
 * This file is part of the Karbonyte Engine
 * The Karbonyte Engine uses LibGDX & Artemis-ODB
 */
public class DMCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

        String message = args.<String>getOne("message").get();

        for (Player player : Sponge.getServer().getOnlinePlayers()) {

            if (player.hasPermission("Celestite.dm"))
                player.sendMessage(Text.of("[✿] " + src.getName() + ": " + message));

        }

        return CommandResult.success();
    }
}
