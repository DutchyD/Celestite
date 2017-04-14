package com.celestitemc.messages;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * Created by Dutchy on 31-3-2017.
 * This file is part of the Karbonite Engine
 */
public enum Levels implements Level {
    PLUS(Text.builder().append(Text.of("[")).append(Text.of("+")).color(TextColors.GREEN).append(Text.of("]")).build()),
    MINUS(Text.builder().append(Text.of("[")).append(Text.of("-")).color(TextColors.RED).append(Text.of("]")).build()),
    SUCCESS(Text.builder().append(Text.of("[")).append(Text.of("SUCCESS")).color(TextColors.GREEN).append(Text.of("]")).build()),
    FAILURE(Text.builder().append(Text.of("[")).append(Text.of("FAILURE")).color(TextColors.RED).append(Text.of("]")).build())


    ;

    private Text text;

    Levels(Text text) {
        this.text = text;
    }

    @Override
    public Text getText() {
        return text;
    }
}
