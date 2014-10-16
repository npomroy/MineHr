package com.kraz.minehr.reference;

import net.minecraft.util.ResourceLocation;

public class Reference {
    public static final String MOD_ID = "MineHr";
    public static final String MOD_NAME = "Mine Hr";
    public static final String FINGERPRINT = "@FINGERPRINT@";
    public static final String VERSION = "1.7.10-0.1";
    public static final String SERVER_PROXY_CLASS = "com.kraz.minehr.proxy.ServerProxy";
    public static final String CLIENT_PROXY_CLASS = "com.kraz.minehr.proxy.ClientProxy";
    public static final String GUI_FACTORY_CLASS = "com.kraz.minehr.client.gui.GuiFactory";
    public static final int guiIDWorksurface = 1;
    public static final int guiIDStoreBlock = 2;
    public static final int guiIDOilLamp = 3;

    public static final String guiStoreLocation = new String("textures/gui/GuiStore.png");
    public static final String guiWorkbenchLocation = new String("textures/gui/GuiWorkbench.png");
    public static final String guiOilLampLocation = new String("textures/gui/GuiOilLamp.png");

    public static final int lobsterTrapCatchChance = 40;
    public static final int lobsterTrapMinDepth = 5;
    public static final int lobsterTrapBonusDepth = 12;
    public static final int lobsterTrapBonusFactor = 2;

    public static final int jigCatchChance = 30;
    public static final int jigMinDepth = 8;
    public static final int jigBonusDepth = 20;
    public static final int jigBonusCatchChance = 70;

    public static final int oilLampMaxFuel = 1000;
    public static final int oilLampFuelValue = 400;
}
