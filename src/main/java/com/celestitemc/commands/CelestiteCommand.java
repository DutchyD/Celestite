package com.celestitemc.commands;

import com.celestitemc.CelestitePlugin;
import com.celestitemc.commands.impl.PlayerCommand;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Created by Dutchy on 8-12-2016.
 * This file is part of the Karbonyte Engine
 * The Karbonyte Engine uses LibGDX & Artemis-ODB
 */
public class CelestiteCommand extends PlayerCommand {

    public CelestiteCommand(CelestitePlugin plugin) {
        super(plugin);
    }

    @Override
    public void execute(Player player, CommandContext commandContext) throws CommandException {

    }
}
