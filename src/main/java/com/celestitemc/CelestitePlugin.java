package com.celestitemc;

import com.celestitemc.messages.Messenger;
import com.celestitemc.persistence.mongodb.MongoDBConnection;
import com.celestitemc.persistence.mysql.MySQLDBConnection;

public abstract class CelestitePlugin {

    private Celestite celestite;

    private Messenger messenger;

    protected void setCelestite(final Celestite celestite) {
        this.celestite = celestite;
    }

    protected void setMessenger(final Messenger messenger) {
        this.messenger = messenger;
    }

    protected MongoDBConnection getMongoDBC() {
        return this.celestite.getMongoDBC();
    }

    protected MySQLDBConnection getMySQLDBC() {
        return this.celestite.getMySQLDBC();
    }

    public Celestite getCelestite() { return celestite; }

    public Messenger getMessenger() { return messenger; }

}
