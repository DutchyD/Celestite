package com.celestitemc.commands.impl;

import com.celestitemc.CelestitePlugin;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * Created by Dutchy on 8-12-2016.
 * This file is part of the Karbonyte Engine
 * The Karbonyte Engine uses LibGDX & Artemis-ODB
 */
public abstract class PlayerCommand implements CommandExecutor {

    protected CelestitePlugin plugin;

    public PlayerCommand(CelestitePlugin plugin) {
        this.plugin = plugin;
    }

    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

        if (!(src instanceof Player)) {
            src.sendMessage(Text.of(new Object[] { TextColors.RED, "This is a player only command" }));
            return CommandResult.success();
        }

        Player player = (Player)src;

        this.execute(player, args);

        return CommandResult.success();
    }

    public abstract void execute(Player player, CommandContext commandContext) throws CommandException;

}