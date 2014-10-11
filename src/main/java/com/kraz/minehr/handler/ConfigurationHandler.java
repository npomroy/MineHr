package com.kraz.minehr.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

    public static void init(File configFile) {

        Configuration configuration = new Configuration(configFile);

        try{
            //Load the configuration file
            configuration.load();

            //Read in properties from configuration file
            boolean configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config value").getBoolean(true);
        }
        catch (Exception e) {
            //Log the exception
        }
        finally {
            //Save the configuration file
            configuration.save();
        }

    }

}
