package com.kraz.minehr.handler;

import java.io.File;

import com.kraz.minehr.reference.Reference;
import com.kraz.minehr.util.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean configValue;
    public static boolean vRecipeBoat;
    public static boolean vRecipeStoneTools;
    public static boolean vRecipeFishingRod;

    public static void init(File configFile) {

        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent (ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            //Resync Configs
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
        configValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example configuration value");
        vRecipeBoat = configuration.getBoolean("vRecipeBoat", Configuration.CATEGORY_GENERAL, false, "Vanilla boat crafting enabled");
        vRecipeStoneTools = configuration.getBoolean("vRecipeStoneTools", Configuration.CATEGORY_GENERAL, false, "Vanilla stone tool crafting enabled");
        vRecipeFishingRod = configuration.getBoolean("vRecipeFishingRod", Configuration.CATEGORY_GENERAL, false, "Vanilla fishing rod crafting enabled");

        if(configuration.hasChanged()) {
            configuration.save();
        }
    }

}
