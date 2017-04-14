package com.celestitemc.messages;

/**
 * Created by Dutchy on 26-3-2017.
 * This file is part of the Karbonite Engine
 */
public enum CelestiteMessages implements Message {
    WELCOME_MESSAGE("lol"),
    QUIT_MESSAGE(""),
    WEATHER_CHANGED("You have changed the weather to %s"),
    WEATHERTYPE_NOT_FOUND("Weather type '%s' was not found")

    ;

    private String string;

    CelestiteMessages(String string) {
        this.string = string;
    }

    public String toString() {
        return this.string;
    }
}
