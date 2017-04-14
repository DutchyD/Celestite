package com.celestitemc.persistence.mysql;

import com.celestitemc.persistence.Database;
import com.celestitemc.utils.exceptions.DatabaseException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.annotation.Nonnull;
import java.sql.Connection;
import java.sql.SQLException;

public class MySQLDBConnection implements Database {

    private MysqlDataSource dataSource;
    private Connection connection;

    /**
     *
     * Creates a new MySQLDBConnection, allowing multiple MySQL databases to be used
     *
     * @param dataSource
     */
    public MySQLDBConnection(@Nonnull final MysqlDataSource dataSource) {

        /* Update existing MySQLDataSource */
        this.dataSource = dataSource;
    }

    /**
     *
     * Opens the connection to the MySQL database
     *
     * @throws DatabaseException
     */
    public boolean open() throws DatabaseException {

        /* If the connection is closed */
        if (this.connection == null) {

            /* Try to connect to MySQL database */
            try {
                this.connection = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;

        /* If the connection is open */
        } else {

            /* Connection shouldn't be open, throw error */
            throw new DatabaseException("Tried to open an already opened MongoClient. Please close it first.");

        }
    }

    /**
     *
     * Closes the connection to the MySQL database
     *
     * @throws DatabaseException
     */
    public boolean close() throws DatabaseException {

        try {

            /* If the connection isn't closed */
            if (!this.connection.isClosed()) {

                /* Close connection and set to null */
                this.connection.close();
                this.connection = null;

                return true;

            /* If the connection is closed */
            } else {

                /* Connection shouldn't be closed, throw error */
                throw new DatabaseException("Tried to close an already closed MongoClient. Please open it first.");

            }

        /* If anything fails */
        } catch (SQLException e) {

            /* Alert the operator via console */
            e.printStackTrace();

            /* Return false, due to failure */
            return false;
        }
    }

    public void update(String statement) {

    }

    public void insert(String statement) {

    }
}
