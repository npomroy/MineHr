package com.kraz.minehr.client.gui;

import com.kraz.minehr.handler.ConfigurationHandler;
import com.kraz.minehr.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Nick on 10/11/2014.
 */
public class MineHrGuiConfig extends GuiConfig {

    public MineHrGuiConfig(GuiScreen guiScreen) {
        //world restart?, minecraft restart?
        super(guiScreen, new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
