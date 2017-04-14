package com.celestitemc.utils.exceptions;

/**
 * Created by Dutchy on 23-3-2017.
 * This file is part of the Karbonite Engine
 */
public class DatabaseException extends Exception {

    public DatabaseException () {

    }

    public DatabaseException (String message) {
        super (message);
    }

    public DatabaseException (Throwable cause) {
        super (cause);
    }

    public DatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
