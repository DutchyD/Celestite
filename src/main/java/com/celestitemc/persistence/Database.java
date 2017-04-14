package com.celestitemc.persistence;

import com.celestitemc.utils.exceptions.DatabaseException;

/**
 * Created by Dutchy on 23-3-2017.
 * This file is part of the Karbonite Engine
 */
public interface Database {

    public boolean open() throws DatabaseException;

    public boolean close() throws DatabaseException;
}
