package com.celestitemc.persistence.mongodb;

import com.celestitemc.persistence.Database;
import com.celestitemc.utils.exceptions.DatabaseException;
import com.mongodb.MongoClient;

import javax.annotation.Nonnull;

public class MongoDBConnection implements Database {

    private MongoClient mongo;
    private String connection;
    private int port;


    /**
     *
     * Creates a new MongoDBConnection, allowing multiple Mongo databases to be used
     *
     * @param connection
     * @param port
     */
    public MongoDBConnection(@Nonnull String connection, @Nonnull Integer port) {

        /* Update variables with parameters */
        this.connection = connection;
        this.port = port;
    }

    public boolean open() throws DatabaseException {

        /* If the Mongo database connection is closed */
        if (this.mongo == null) {

            /* Open new Mongo database connection */
            this.mongo = new MongoClient(this.connection, this.port); /* TODO: Make Json File system to read Database Connections */

            /* return that the connection was successfully opened */
            return true;

        /* If the Mongo database connection is open */
        } else {

            /* throw a new DatabaseException to alert the operator */
            throw new DatabaseException("Tried to open an already opened MongoClient, you have to close it first.");
        }
    }

    public boolean close() throws DatabaseException {

        /* If the Mongo database connection is open */
        if (this.mongo != null) {

            /* Close the database connection and set to null */
            this.mongo.close();
            this.mongo = null;

            /* Return that the connection was successfully closed */
            return true;

        /* If the Mongo database connection is closed */
        } else {

            /* Alert the operator via console */
            throw new DatabaseException("Tried to close an already closed MongoClient. Please open it first.");
        }
    }
}
