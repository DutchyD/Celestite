package com.celestitemc.configuration;

import com.google.inject.Inject;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.config.ConfigDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Created by Dutchy on 28-3-2017.
 * This file is part of the Karbonite Engine
 */
public class FileManager {

    @Inject
    @ConfigDir(sharedRoot = false)
    private Path configDir;

    private Path configFile = Paths.get(configDir + "/config.conf");

    private HashMap<String, CommentedConfigurationNode> configNodes;
    private HashMap<String, ConfigurationLoader<CommentedConfigurationNode>> configLoaders;

    /* Singleton instance */
    private static FileManager instance;

    /* Singleton constructor */
    private FileManager() {
    }

    /* Singleton call */
    public static FileManager getInstance() {

        if (instance == null)
            instance = new FileManager();

        return instance;
    }

    public boolean createMainDirectory(boolean override) {
        if (!Files.exists(configDir) || override) {
            try {
                Files.createDirectories(configDir);

                return true;
            } catch (Exception e) {
                e.printStackTrace();

                return false;
            }
        }

        return true;
    }

    public boolean createDirectory(String path, boolean override) {
        if (!Files.exists(configDir) || override) {
            try {
                Path directoryPath =
                Files.createDirectories(configDir);

                return true;
            } catch (Exception e) {
                e.printStackTrace();

                return false;
            }
        }

        return true;
    }

    public boolean createConfigFile(String fileName, boolean override) {

        Path path = Paths.get(configDir + "/" + fileName + ".conf");

        if(!Files.exists(path) || override) {
            try{
                Files.createFile(path);

                return true;

            }catch(IOException e){
                e.printStackTrace();

                return false;
            }
        }

        return false;
    }

    public boolean loadConfigFile(String fileName) {
        Path path = Paths.get(configDir + "/" + fileName + ".conf");

        ConfigurationLoader<CommentedConfigurationNode> loader = HoconConfigurationLoader.builder().setPath(path).build();

        configLoaders.put(fileName, loader);

        try {

            CommentedConfigurationNode node = loader.load();

            configNodes.put(fileName, node);

            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }
    }

    public boolean saveConfigFile(String fileName) {

        ConfigurationLoader<CommentedConfigurationNode> loader = configLoaders.get(fileName);

        ConfigurationNode node = configNodes.get(fileName);

        try {
            loader.save(node);

            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }
    }
}
