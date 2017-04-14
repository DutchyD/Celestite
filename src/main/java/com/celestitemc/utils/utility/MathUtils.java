package com.celestitemc.utils.utility;

import javax.annotation.Nonnull;

/**
 * Created by Dutchy on 8-12-2016.
 * This file is part of the Karbonyte Engine
 * The Karbonyte Engine uses LibGDX & Artemis-ODB
 */
public class MathUtils {

    public static Integer getLastDigit(@Nonnull Integer number) { return number % 10; }

    public static Double getLastDigit(@Nonnull Double number) { return number % 10; }
}
