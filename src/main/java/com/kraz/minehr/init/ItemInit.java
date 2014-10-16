package com.kraz.minehr.init;

import com.kraz.minehr.items.MHItems;
import com.kraz.minehr.items.ReadyLobsterTrap;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Nick on 10/14/2014.
 */
public class ItemInit {


    //TODO Remove
    public static final MHItems itemCopperIngot = new MHItems("CopperIngot");
    public static final MHItems itemTinIngot = new MHItems("TinIngot");
    public static final MHItems itemBronzeIngot = new MHItems("BronzeIngot");
    public static final MHItems itemBrassIngot = new MHItems("BrassIngot");
    public static final MHItems itemNickelIngot = new MHItems("NickelIngot");
    public static final MHItems itemLeadIngot = new MHItems("LeadIngot");
    public static final MHItems itemChromiumIngot = new MHItems("ChromiumIngot");
    public static final MHItems itemAluminumIngot = new MHItems("AluminumIngot");
    public static final MHItems itemMagnesiumIngot = new MHItems("MagnesiumIngot");
    public static final MHItems itemTitaniumIngot = new MHItems("TitaniumIngot");
    public static final MHItems itemZincIngot = new MHItems("ZincIngot");


    public static final MHItems itemKraziteDust = new MHItems("KraziteDust");
    public static final MHItems itemKraziteCrystal = new MHItems("KraziteCrystal");
    public static final MHItems itemZarkiteDust = new MHItems("ZarkiteDust");
    public static final MHItems itemZarkiteCrystal = new MHItems("ZarkiteCrystal");
    public static final MHItems itemHorizonCrystal = new MHItems("HorizonCrystal");
    public static final MHItems itemRawResin = new MHItems("RawResin");
    public static final MHItems itemNaturalRubber = new MHItems("NaturalRubber");

    public static final MHItems itemFishFillet = new MHItems("FishFillet");
    public static final MHItems itemRawCod = new MHItems("RawCod");
    public static final MHItems itemRawCrab = new MHItems("RawCrab");
    public static final MHItems itemRawLobster = new MHItems("RawLobster");
    public static final MHItems itemCodTongue = new MHItems("CodTongue");
    public static final MHItems itemCrabLegs = new MHItems("CrabLegs");
    public static final MHItems itemLobsterClaws = new MHItems("LobsterClaws");
    public static final MHItems itemLobsterTail = new MHItems("LobsterTail");
    public static final MHItems itemKelp = new MHItems("Kelp");
    public static final MHItems itemSodaAsh = new MHItems("SodaAsh");
    public static final MHItems itemFishGuts = new MHItems("FishGuts");
    public static final MHItems itemGlassMix = new MHItems("GlassMix");
    public static final MHItems itemIronPlate = new MHItems("IronPlate");
    public static final MHItems itemIronWire = new MHItems("IronWire");
    public static final MHItems itemIronHook = new MHItems("IronHook");
    public static final MHItems itemBoneHook = new MHItems("BoneHook");
    public static final MHItems itemTwine = new MHItems("Twine");
    public static final MHItems itemRope = new MHItems("Rope");
    public static final MHItems itemLeadedRope = new MHItems("LeadedRope");
    public static final MHItems itemNetting = new MHItems("Netting");
    public static final ReadyLobsterTrap itemReadyLobsterTrap = new ReadyLobsterTrap();



    public static void init() {
        GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
        GameRegistry.registerItem(itemTinIngot, "TinIngot");
        GameRegistry.registerItem(itemBronzeIngot,"BronzeIngot");
        GameRegistry.registerItem(itemBrassIngot, "BrassIngot");
        GameRegistry.registerItem(itemNickelIngot, "NickelIngot");
        GameRegistry.registerItem(itemLeadIngot, "LeadIngot");
        GameRegistry.registerItem(itemChromiumIngot, "ChromiumIngot");
        GameRegistry.registerItem(itemAluminumIngot, "AluminumIngot");
        GameRegistry.registerItem(itemMagnesiumIngot, "MagnesiumIngot");
        GameRegistry.registerItem(itemTitaniumIngot, "TitaniumIngot");
        GameRegistry.registerItem(itemZincIngot, "ZincIngot");

        GameRegistry.registerItem(itemKraziteDust, "KraziteDust");
        GameRegistry.registerItem(itemKraziteCrystal, "KraziteCrystal");
        GameRegistry.registerItem(itemZarkiteDust, "ZarkiteDust");
        GameRegistry.registerItem(itemZarkiteCrystal, "ZarkiteCrystal");
        GameRegistry.registerItem(itemHorizonCrystal, "HorizonCrystal");
        GameRegistry.registerItem(itemRawResin, "RawResin");
        GameRegistry.registerItem(itemNaturalRubber, "NaturalRubber");

        GameRegistry.registerItem(itemFishFillet, "FishFillet");
        GameRegistry.registerItem(itemRawCod, "RawCod");
        GameRegistry.registerItem(itemRawCrab, "RawCrab");
        GameRegistry.registerItem(itemRawLobster, "RawLobster");
        GameRegistry.registerItem(itemCodTongue, "CodTongue");
        GameRegistry.registerItem(itemCrabLegs, "CrabLegs");
        GameRegistry.registerItem(itemLobsterClaws, "LobsterClaws");
        GameRegistry.registerItem(itemLobsterTail, "LobsterTail");
        GameRegistry.registerItem(itemKelp, "Kelp");
        GameRegistry.registerItem(itemSodaAsh, "SodaAsh");
        GameRegistry.registerItem(itemFishGuts, "FishGuts");
        GameRegistry.registerItem(itemGlassMix, "GlassMix");
        GameRegistry.registerItem(itemIronPlate, "IronPlate");
        GameRegistry.registerItem(itemIronWire, "IronWire");
        GameRegistry.registerItem(itemIronHook, "IronHook");
        GameRegistry.registerItem(itemBoneHook, "BoneHook");
        GameRegistry.registerItem(itemTwine, "Twine");
        GameRegistry.registerItem(itemRope, "Rope");
        GameRegistry.registerItem(itemLeadedRope, "LeadedRope");
        GameRegistry.registerItem(itemNetting, "Netting");
        GameRegistry.registerItem(itemReadyLobsterTrap, "ReadyLobsterTrap");
    }
}
