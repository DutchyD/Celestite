package com.celestitemc;

import com.celestitemc.commands.DMCommand;
import com.celestitemc.commands.RainCommand;
import com.celestitemc.commands.StormCommand;
import com.celestitemc.commands.SunCommand;
import com.celestitemc.messages.Messenger;
import com.celestitemc.persistence.mongodb.MongoDBConnection;
import com.celestitemc.persistence.mysql.MySQLDBConnection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

@Plugin(id = "celestite", name = "Celestite Plugin", version = "1.0", description = "The main plugin for the Celestite Framework")
public class Celestite extends CelestitePlugin {

    private MongoDBConnection mongoDBC;
    private MySQLDBConnection mysqlDBC;

    @Listener
    public void onServerStart(GameStartingServerEvent e) {

        /* Register events */
        this.registerEvents();

        this.setMessenger(new Messenger(this));

        CommandSpec dmCommand = CommandSpec.builder()
                .description(Text.of("Super Secret Chat"))
                .permission("Celestite.dm")
                .executor(new DMCommand())
                .arguments(GenericArguments.remainingJoinedStrings(Text.of("message")))
                .build();

        CommandSpec sunCommand = CommandSpec.builder()
                .description(Text.of("Changes the weather to Sunny"))
                .permission("Celestite.sun")
                .executor(new SunCommand(this))
                .build();

        CommandSpec rainCommand = CommandSpec.builder()
                .description(Text.of("Changes the weather to Rainy"))
                .permission("Celestite.rain")
                .executor(new RainCommand(this))
                .build();

        CommandSpec stormCommand = CommandSpec.builder()
                .description(Text.of("Changes the weather to Stormy"))
                .permission("Celestite.storm")
                .executor(new StormCommand(this))
                .build();

        Sponge.getCommandManager().register(this, dmCommand, "dm");
        Sponge.getCommandManager().register(this, sunCommand, "sun");
        Sponge.getCommandManager().register(this, rainCommand, "rain");
        Sponge.getCommandManager().register(this, stormCommand, "storm");

        /* Keep at the end */
        this.setCelestite(this);

    }

    @Listener
    public void onServerStopping(GameStoppingServerEvent e) {

        /* Unregister events */
        this.unregisterEvents();
    }

    public MongoDBConnection getMongoDBC() {
        return this.mongoDBC;
    }

    public MySQLDBConnection getMySQLDBC() {
        return this.mysqlDBC;
    }

    private void setupDatabases() {
        try {
            this.mongoDBC = new MongoDBConnection("dev", 27017);

            final MysqlDataSource dataSource = new MysqlDataSource();

            dataSource.setUser("Dutchy");
            dataSource.setPassword("zrbhjkl16678!");
            dataSource.setPort(3306);
            dataSource.setServerName("80.100.143.174");
            dataSource.setDatabaseName("dev");

            this.mysqlDBC = new MySQLDBConnection(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeDatabases() {
        try {
            this.mongoDBC.close();
            this.mysqlDBC.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.mongoDBC = null;
        this.mysqlDBC = null;
    }

    private void registerEvents() {
    }

    private void unregisterEvents() {
        Sponge.getEventManager().unregisterListeners(new PlayerListener(this));
    }
}
