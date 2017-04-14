package com.celestitemc.utils.utility;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

public class ReflectionUtils {

    /**
     * Retrieves methods from the class that contain the String value and invokes them with null
     *
     * @param clazz The class
     * @param value The String value
     */
    public static void invokeMethodsThatContain(Class clazz, String value) {
        Stream.of(clazz.getDeclaredMethods()).filter(s -> s.getName().contains(value)).forEach(s -> {
            try {
                s.invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Retrieves methods from the class that contain the String value and invokes them with null
     *
     * @param clazz The class
     * @param value The String value
     */
    public static void invokeMethodsThatStartWith(Class clazz, String value) {
        Stream.of(clazz.getDeclaredMethods()).filter(s -> s.getName().startsWith(value)).forEach(s -> {
            try {
                s.invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Retrieves methods from the class that contain the String value and invokes them with the arguments.
     *
     * @param clazz The class
     * @param value The String value
     * @param arguments The arguments
     */
    public static void invokeMethodsThatContain(Class clazz, String value, Object... arguments) {
        Stream.of(clazz.getDeclaredMethods()).filter(s -> s.getName().contains(value)).forEach(s -> {
            try {
                s.invoke(null, arguments);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Retrieves methods from the class that contain the String value and invokes them with the arguments.
     *
     * @param clazz The class
     * @param value The String value
     * @param arguments The arguments
     */
    public static void invokeMethodsThatStartWith(Class clazz, String value, Object... arguments) {
        Stream.of(clazz.getDeclaredMethods()).filter(s -> s.getName().startsWith(value)).forEach(s -> {
            try {
                s.invoke(null, arguments);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
