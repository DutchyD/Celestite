package com.celestitemc.commands;

import com.celestitemc.CelestitePlugin;
import com.celestitemc.commands.impl.PlayerCommand;
import com.celestitemc.messages.CelestiteMessages;
import com.celestitemc.messages.Levels;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.weather.Weathers;

/**
 * Created by Dutchy on 31-3-2017.
 * This file is part of the Karbonite Engine
 */
public class SunCommand extends PlayerCommand {


    public SunCommand(CelestitePlugin plugin) {
        super(plugin);
    }

    @Override
    public void execute(Player player, CommandContext commandContext) throws CommandException {
        player.getWorld().setWeather(Weathers.CLEAR);
        plugin.getMessenger().sendMessage(player, Levels.SUCCESS, CelestiteMessages.WEATHER_CHANGED, "Sunny");
    }
}
