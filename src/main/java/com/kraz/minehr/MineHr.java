package com.kraz.minehr;

import com.kraz.minehr.armor.HorizonArmor;
import com.kraz.minehr.armor.RubberArmor;
import com.kraz.minehr.biome.features.MHLeaves;
import com.kraz.minehr.biome.features.MHLog;
import com.kraz.minehr.biome.features.MHSapling;
import com.kraz.minehr.blocks.MetalBlock;
import com.kraz.minehr.blocks.OreBlock;
import com.kraz.minehr.blocks.BlockMHDrying;
import com.kraz.minehr.blocks.KelpPile;
import com.kraz.minehr.blocks.KelpStone;
import com.kraz.minehr.blocks.LobsterTrap;
import com.kraz.minehr.blocks.MHCrop;
import com.kraz.minehr.blocks.OilLamp;
import com.kraz.minehr.blocks.PurifiedKraziteOre;
import com.kraz.minehr.blocks.PurifiedZarkiteOre;
import com.kraz.minehr.blocks.Stage;
import com.kraz.minehr.blocks.TrapBuoy;
import com.kraz.minehr.blocks.Workbench;
import com.kraz.minehr.crafting.RecipeRemover;
import com.kraz.minehr.entity.EntityCrab;
import com.kraz.minehr.handler.ConfigurationHandler;
import com.kraz.minehr.handler.CraftingHandler;
import com.kraz.minehr.handler.EntityHandler;
import com.kraz.minehr.handler.FuelHandler;
import com.kraz.minehr.handler.GuiHandler;
import com.kraz.minehr.items.CodTongue;
import com.kraz.minehr.items.FilletKnife;
import com.kraz.minehr.items.HempSpice;
import com.kraz.minehr.items.HorizonAxe;
import com.kraz.minehr.items.HorizonHoe;
import com.kraz.minehr.items.HorizonPickaxe;
import com.kraz.minehr.items.HorizonShovel;
import com.kraz.minehr.items.HorizonSword;
import com.kraz.minehr.items.IronRod;
import com.kraz.minehr.items.ItemLeafBlocks;
import com.kraz.minehr.items.ItemLogBlocks;
import com.kraz.minehr.items.ItemSaplingBlocks;
import com.kraz.minehr.items.MHDryingSeed;
import com.kraz.minehr.items.MHItems;
import com.kraz.minehr.items.Mallet;
import com.kraz.minehr.items.Pliers;
import com.kraz.minehr.items.Salt;
import com.kraz.minehr.proxy.CommonProxy;
import com.kraz.minehr.worldgen.MineHrWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid="MineHr", name="Mine Hr", version="1.7.10-0.1")
public class MineHr {

    public static final String modid = "MineHr";
    public static final String version = "Alpha v0.1";

    MineHrWorldGen eventWorldGen = new MineHrWorldGen();

    public static CreativeTabs mineHrTab;

    /*
     * WOOD(0, 59, 2.0F, 0.0F, 15),
        STONE(1, 131, 4.0F, 1.0F, 5),
        IRON(2, 250, 6.0F, 2.0F, 14),
        EMERALD(3, 1561, 8.0F, 3.0F, 10),
        GOLD(0, 32, 12.0F, 0.0F, 22);
     */
    //harvestLevel, maxuses, effeciencyonProperMat, damagevsent, enchant
    public static ToolMaterial KnifeMaterial = EnumHelper.addToolMaterial("KnifeMaterial", 2, 64, 1.0F, 0.0F, 10);
    public static ToolMaterial HorizonToolMaterial = EnumHelper.addToolMaterial("HorizonToolMaterial", 3, 4200, 12.0F, 5.0F, 16);
    //TODO fix rubber material
    public static ArmorMaterial RubberArmorMaterial = EnumHelper.addArmorMaterial("RubberArmor", 10, new int[]{1, 4, 3, 1}, 10);
    public static ArmorMaterial HorizonArmorMaterial = EnumHelper.addArmorMaterial("HorizonArmor", 30, new int[]{6, 8, 7, 5}, 30);

    //armor
    public static int armorRubberHatID;
    public static int armorRubberChestID;
    public static int armorRubberLegsID;
    public static int armorRubberBootsID;

    public static Item armorRubberBoots;
    public static Item armorRubberLegs;
    public static Item armorRubberChest;
    public static Item armorRubberHat;

    public static Item armorHorizonBoots;
    public static Item armorHorizonLegs;
    public static Item armorHorizonChest;
    public static Item armorHorizonHat;

    public static Item toolHorizonSword;
    public static Item toolHorizonPickaxe;
    public static Item toolHorizonAxe;
    public static Item toolHorizonShovel;
    public static Item toolHorizonHoe;

    //TODO Remove
    public static Item itemCopperIngot;
    public static Item itemTinIngot;
    public static Item itemBronzeIngot;
    public static Item itemBrassIngot;
    public static Item itemNickelIngot;
    public static Item itemLeadIngot;
    public static Item itemAluminumIngot;
    public static Item itemChromiumIngot;
    public static Item itemMagnesiumIngot;
    public static Item itemTitaniumIngot;
    public static Item itemZincIngot;

    public static Item itemKraziteDust;
    public static Item itemZarkiteDust;
    public static Item itemKraziteCrystal;
    public static Item itemZarkiteCrystal;
    public static Item itemHorizonCrystal;
    public static Item itemRawResin;
    public static Item itemNaturalRubber;
    public static Item itemSalt;

    public static Item itemHerbGrinder;
    public static Item itemJigger;
    public static Item itemMallet;
    public static Item itemPliers;
    public static Item itemFilletKnife;
    public static Item itemIronRod;
    public static Item itemKelp;
    public static Item itemRawCod;
    public static Item itemRawCrab;
    public static Item itemRawLobster;
    public static Item foodCookedLobster;
    public static Item itemFishFillet;
    public static Item foodCookedFishFillet;
    public static Item itemCodFillet;
    public static Item foodCookedCodFillet;
    public static Item itemCodTongue;
    public static Item foodCookedCodTongue;
    public static Item itemCrabLegs;
    public static Item foodCookedCrabLegs;
    public static Item itemLobsterClaws;
    public static Item foodCookedLobsterClaws;
    public static Item itemLobsterTail;
    public static Item foodCookedLobsterTail;
    public static Item foodLobsterMeal;
    public static Item itemSodaAsh;
    public static Item itemFishGuts;
    public static Item itemGlassMix;
    public static Item itemIronPlate;
    public static Item itemIronWire;
    public static Item itemIronHook;
    public static Item itemBoneHook;
    public static Item itemTwine;
    public static Item itemRope;
    public static Item itemLeadedRope;
    public static Item itemNetting;
    public static Item itemReadyLobsterTrap;
    public static Item itemHempSpice;

    //crops
    public static Item cropHempSeeds;
    public static Item cropHemp;
    public static Block cropHempPlant;
    public static Block cropDryingCod;

    //Trees
    public static Block blockLog;
    public static Block blockLeaf;
    public static Block blockSapling;


    //TODO Remove
    public static Block oreCopperOre;
    public static Block oreTinOre;
    public static Block oreNickelOre;
    public static Block oreLeadOre;
    public static Block oreChromiteOre;
    public static Block oreAluminumOre;
    public static Block oreMagnesiumOre;
    public static Block oreTitaniumOre;
    public static Block oreZincOre;
    public static Block blockCopperBlock;
    public static Block blockTinBlock;
    public static Block blockBronzeBlock;
    public static Block blockBrassBlock;
    public static Block blockNickelBlock;
    public static Block blockLeadBlock;
    public static Block blockChromiumBlock;
    public static Block blockAluminumBlock;
    public static Block blockMagnesiumBlock;
    public static Block blockTitaniumBlock;
    public static Block blockZincBlock;

    public static Block oreKraziteOre;
    public static Block oreZarkiteOre;
    public static Block blockPurifiedKraziteOre;
    public static Block blockPurifiedZarkiteOre;
    public static Block oreKelpStone;
    public static Block blockKelpPile;
    public static Block blockLobsterTrap;
    public static Block blockTrapBuoy;
    public static Block blockOilLampOn;
    public static Block blockOilLampOff;
    public static Block blockStage;

    public static Block blockWorkbench;
    public static final int guiIDWorksurface = 1;

    @SidedProxy(clientSide = "com.kraz.minehr.proxy.ClientProxy", serverSide = "new.minehr.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Instance(modid)
    public static com.kraz.minehr.MineHr instance;

    @EventHandler
    public void PreInit(FMLPreInitializationEvent preEvent){

        ConfigurationHandler.init(preEvent.getSuggestedConfigurationFile());

        mineHrTab = new CreativeTabs("MineHr") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return MineHr.foodCookedLobster;
            }
        };

        //Crops
        cropHempPlant = new MHCrop().setBlockName("HempPlant");
        GameRegistry.registerBlock(cropHempPlant, "HempPlant");
        cropHempSeeds = new ItemSeeds(cropHempPlant, Blocks.farmland).setUnlocalizedName("HempSeeds").setTextureName(modid + ":HempSeeds").setCreativeTab(mineHrTab);
        GameRegistry.registerItem(cropHempSeeds, "HempSeeds");
        cropHemp = new MHItems().setUnlocalizedName("Hemp");
        GameRegistry.registerItem(cropHemp, "Hemp");
        cropDryingCod = new BlockMHDrying(itemCodFillet).setBlockName("DryingCod");
        GameRegistry.registerBlock(cropDryingCod, "DryingCod");

        //TODO Remove
        itemCopperIngot = new MHItems().setUnlocalizedName("CopperIngot");
        GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
        itemTinIngot = new MHItems().setUnlocalizedName("TinIngot");
        GameRegistry.registerItem(itemTinIngot, "TinIngot");
        itemBronzeIngot = new MHItems().setUnlocalizedName("BronzeIngot");
        GameRegistry.registerItem(itemBronzeIngot,"BronzeIngot");
        itemBrassIngot = new MHItems().setUnlocalizedName("BrassIngot");
        GameRegistry.registerItem(itemBrassIngot, "BrassIngot");
        itemNickelIngot = new MHItems().setUnlocalizedName("NickelIngot");
        GameRegistry.registerItem(itemNickelIngot, "NickelIngot");
        itemLeadIngot = new MHItems().setUnlocalizedName("LeadIngot");
        GameRegistry.registerItem(itemLeadIngot, "LeadIngot");
        itemChromiumIngot = new MHItems().setUnlocalizedName("ChromiumIngot");
        GameRegistry.registerItem(itemChromiumIngot, "ChromiumIngot");
        itemAluminumIngot = new MHItems().setUnlocalizedName("AluminumIngot");
        GameRegistry.registerItem(itemAluminumIngot, "AluminumIngot");
        itemMagnesiumIngot = new MHItems().setUnlocalizedName("MagnesiumIngot");
        GameRegistry.registerItem(itemMagnesiumIngot, "MagnesiumIngot");
        itemTitaniumIngot = new MHItems().setUnlocalizedName("TitaniumIngot");
        GameRegistry.registerItem(itemTitaniumIngot, "TitaniumIngot");
        itemZincIngot = new MHItems().setUnlocalizedName("ZincIngot");
        GameRegistry.registerItem(itemZincIngot, "ZincIngot");

        itemKraziteDust = new MHItems().setUnlocalizedName("KraziteDust");
        GameRegistry.registerItem(itemKraziteDust, "KraziteDust");
        itemKraziteCrystal = new MHItems().setUnlocalizedName("KraziteCrystal");
        GameRegistry.registerItem(itemKraziteCrystal, "KraziteCrystal");
        itemZarkiteDust = new MHItems().setUnlocalizedName("ZarkiteDust");
        GameRegistry.registerItem(itemZarkiteDust, "ZarkiteDust");
        itemZarkiteCrystal = new MHItems().setUnlocalizedName("ZarkiteCrystal");
        GameRegistry.registerItem(itemZarkiteCrystal, "ZarkiteCrystal");
        itemHorizonCrystal = new MHItems().setUnlocalizedName("HorizonCrystal");
        GameRegistry.registerItem(itemHorizonCrystal, "HorizonCrystal");
        itemRawResin = new MHItems().setUnlocalizedName("RawResin");
        GameRegistry.registerItem(itemRawResin, "RawResin");
        itemNaturalRubber = new MHItems().setUnlocalizedName("NaturalRubber");
        GameRegistry.registerItem(itemNaturalRubber, "NaturalRubber");
        itemSalt = new Salt().setUnlocalizedName("Salt");
        GameRegistry.registerItem(itemSalt, "Salt");
        itemHempSpice = new HempSpice(0, 0.0F, false).setUnlocalizedName("HempSpice");
        GameRegistry.registerItem(itemHempSpice, "HempSpice");

        armorRubberHat = new RubberArmor(RubberArmorMaterial, armorRubberHatID, 0).setUnlocalizedName("RubberHat");
        GameRegistry.registerItem(armorRubberHat, "RubberHat");
        armorRubberChest = new RubberArmor(RubberArmorMaterial, armorRubberChestID, 1).setUnlocalizedName("RubberChest");
        GameRegistry.registerItem(armorRubberChest, "RubberChest");
        armorRubberLegs = new RubberArmor(RubberArmorMaterial, armorRubberLegsID, 2).setUnlocalizedName("RubberLegs");
        GameRegistry.registerItem(armorRubberLegs, "RubberLegs");
        armorRubberBoots = new RubberArmor(RubberArmorMaterial, armorRubberBootsID, 3).setUnlocalizedName("RubberBoots");
        GameRegistry.registerItem(armorRubberBoots, "RubberBoots");

        armorHorizonHat = new HorizonArmor(HorizonArmorMaterial, armorRubberHatID, 0).setUnlocalizedName("HorizonHat");
        GameRegistry.registerItem(armorHorizonHat, "HorizonHat");
        armorHorizonChest = new HorizonArmor(HorizonArmorMaterial, armorRubberChestID, 1).setUnlocalizedName("HorizonChest");
        GameRegistry.registerItem(armorHorizonChest, "HorizonChest");
        armorHorizonLegs = new HorizonArmor(HorizonArmorMaterial, armorRubberLegsID, 2).setUnlocalizedName("HorizonLegs");
        GameRegistry.registerItem(armorHorizonLegs, "HorizonLegs");
        armorHorizonBoots = new HorizonArmor(HorizonArmorMaterial, armorRubberBootsID, 3).setUnlocalizedName("HorizonBoots");
        GameRegistry.registerItem(armorHorizonBoots, "HorizonBoots");

        toolHorizonSword = new HorizonSword().setCreativeTab(mineHrTab).setUnlocalizedName("HorizonSword");
        GameRegistry.registerItem(toolHorizonSword, "HorizonSword");
        toolHorizonPickaxe = new HorizonPickaxe().setCreativeTab(mineHrTab).setUnlocalizedName("HorizonPickaxe");
        GameRegistry.registerItem(toolHorizonPickaxe, "HorizonPickaxe");
        toolHorizonShovel = new HorizonShovel().setCreativeTab(mineHrTab).setUnlocalizedName("HorizonShovel");
        GameRegistry.registerItem(toolHorizonShovel, "HorizonShovel");
        toolHorizonAxe = new HorizonAxe().setCreativeTab(mineHrTab).setUnlocalizedName("HorizonAxe");
        GameRegistry.registerItem(toolHorizonAxe, "HorizonAxe");
        toolHorizonHoe = new HorizonHoe().setCreativeTab(mineHrTab).setUnlocalizedName("HorizonHoe");
        GameRegistry.registerItem(toolHorizonHoe, "HorizonHoe");

        itemHerbGrinder = new MHItems().setUnlocalizedName("HerbGrinder");
        GameRegistry.registerItem(itemHerbGrinder, "HerbGrinder");
        itemJigger = new MHItems().setUnlocalizedName("Jigger");
        GameRegistry.registerItem(itemJigger, "Jigger");
        itemMallet = new Mallet().setUnlocalizedName("Mallet");
        GameRegistry.registerItem(itemMallet, "Mallet");
        itemPliers = new Pliers().setUnlocalizedName("Pliers");
        GameRegistry.registerItem(itemPliers, "Pliers");
        itemFilletKnife = new FilletKnife(KnifeMaterial).setUnlocalizedName("FilletKnife");
        GameRegistry.registerItem(itemFilletKnife, "FilletKnife");
        itemIronRod = new IronRod().setUnlocalizedName("IronRod");
        GameRegistry.registerItem(itemIronRod, "IronRod");
        itemFishFillet = new MHItems().setUnlocalizedName("FishFillet");
        GameRegistry.registerItem(itemFishFillet, "FishFillet");
        itemRawCod = new MHItems().setUnlocalizedName("RawCod");
        GameRegistry.registerItem(itemRawCod, "RawCod");
        itemRawCrab = new MHItems().setUnlocalizedName("RawCrab");
        GameRegistry.registerItem(itemRawCrab, "RawCrab");
        itemRawLobster = new MHItems().setUnlocalizedName("RawLobster");
        GameRegistry.registerItem(itemRawLobster, "RawLobster");

        itemCodTongue = new MHItems().setUnlocalizedName("CodTongue");
        GameRegistry.registerItem(itemCodTongue, "CodTongue");

        itemCrabLegs = new MHItems().setUnlocalizedName("CrabLegs");
        GameRegistry.registerItem(itemCrabLegs, "CrabLegs");
        itemLobsterClaws = new MHItems().setUnlocalizedName("LobsterClaws");
        GameRegistry.registerItem(itemLobsterClaws, "LobsterClaws");
        itemLobsterTail = new MHItems().setUnlocalizedName("LobsterTail");
        GameRegistry.registerItem(itemLobsterTail, "LobsterTail");
        itemKelp = new MHItems().setUnlocalizedName("Kelp");
        GameRegistry.registerItem(itemKelp, "Kelp");
        itemSodaAsh = new MHItems().setUnlocalizedName("SodaAsh");
        GameRegistry.registerItem(itemSodaAsh, "SodaAsh");
        itemFishGuts = new MHItems().setUnlocalizedName("FishGuts");
        GameRegistry.registerItem(itemFishGuts, "FishGuts");
        itemGlassMix = new MHItems().setUnlocalizedName("GlassMix");
        GameRegistry.registerItem(itemGlassMix, "GlassMix");
        itemIronPlate = new MHItems().setUnlocalizedName("IronPlate");
        GameRegistry.registerItem(itemIronPlate, "IronPlate");
        itemIronWire = new MHItems().setUnlocalizedName("IronWire");
        GameRegistry.registerItem(itemIronWire, "IronWire");
        itemIronHook = new MHItems().setUnlocalizedName("IronHook");
        GameRegistry.registerItem(itemIronHook, "IronHook");
        itemBoneHook = new MHItems().setUnlocalizedName("BoneHook");
        GameRegistry.registerItem(itemBoneHook, "BoneHook");
        itemTwine = new MHItems().setUnlocalizedName("Twine");
        GameRegistry.registerItem(itemTwine, "Twine");
        itemRope = new MHItems().setUnlocalizedName("Rope");
        GameRegistry.registerItem(itemRope, "Rope");
        itemLeadedRope = new MHItems().setUnlocalizedName("LeadedRope");
        GameRegistry.registerItem(itemLeadedRope, "LeadedRope");
        itemNetting = new MHItems().setUnlocalizedName("Netting");
        GameRegistry.registerItem(itemNetting, "Netting");
        itemReadyLobsterTrap = new MHItems().setUnlocalizedName("ReadyLobsterTrap");
        GameRegistry.registerItem(itemReadyLobsterTrap, "ReadyLobsterTrap");

        //Food
        //Heal amount - Saturation - isWolfMeat
        foodCookedLobster = new ItemFood(6, 0.3F, false).setUnlocalizedName("CookedLobster").setCreativeTab(mineHrTab).setTextureName(MineHr.modid + ":CookedLobster");
        GameRegistry.registerItem(foodCookedLobster, "CookedLobster");
        foodCookedFishFillet = new ItemFood(4, 0.4F, true).setUnlocalizedName("CookedFishFillet").setCreativeTab(mineHrTab).setTextureName(MineHr.modid + ":CookedFishFillet");
        GameRegistry.registerItem(foodCookedFishFillet, "CookedFishFillet");
        foodCookedCodFillet = new ItemFood(4, 0.4F, true).setUnlocalizedName("CookedCodFillet").setCreativeTab(mineHrTab).setTextureName(MineHr.modid + ":CookedCodFillet");
        GameRegistry.registerItem(foodCookedCodFillet, "CookedCodFillet");
        foodCookedCodTongue = new CodTongue(2, 0.3F, false).setUnlocalizedName("CookedCodTongue").setCreativeTab(mineHrTab).setTextureName(MineHr.modid + ":CookedCodTongue");
        GameRegistry.registerItem(foodCookedCodTongue, "CookedCodTongue");
        foodCookedCrabLegs = new ItemFood(4, 0.7F, false).setUnlocalizedName("CookedCrabLegs").setCreativeTab(mineHrTab).setTextureName(MineHr.modid + ":CookedCrabLegs");
        GameRegistry.registerItem(foodCookedCrabLegs, "CookedCrabLegs");
        foodCookedLobsterClaws = new ItemFood(3, 0.5F, false).setUnlocalizedName("CookedLobsterClaws").setCreativeTab(mineHrTab).setTextureName(MineHr.modid + ":CookedLobsterClaws");
        GameRegistry.registerItem(foodCookedLobsterClaws, "CookedLobsterClaws");
        foodCookedLobsterTail = new ItemFood(4, 0.6F, false).setUnlocalizedName("CookedLobsterTail").setCreativeTab(mineHrTab).setTextureName(MineHr.modid + ":CookedLobsterTail");
        GameRegistry.registerItem(foodCookedLobsterTail, "CookedLobsterTail");
        foodLobsterMeal = new ItemFood(10, 0.9F, true).setUnlocalizedName("LobsterMeal").setCreativeTab(mineHrTab).setTextureName(MineHr.modid + ":LobsterMeal");
        GameRegistry.registerItem(foodLobsterMeal, "LobsterMeal");




        //TODORemove
        oreCopperOre = new OreBlock(Material.rock).setBlockName("CopperOre");
        GameRegistry.registerBlock(oreCopperOre, "CopperOre");
        oreTinOre = new OreBlock(Material.rock).setBlockName("TinOre");
        GameRegistry.registerBlock(oreTinOre, "TinOre");
        oreNickelOre = new OreBlock(Material.rock).setBlockName("NickelOre");
        GameRegistry.registerBlock(oreNickelOre, "NickelOre");
        oreLeadOre = new OreBlock(Material.rock).setBlockName("LeadOre");
        GameRegistry.registerBlock(oreLeadOre, "LeadOre");
        oreAluminumOre = new OreBlock(Material.rock).setBlockName("AluminumOre");
        GameRegistry.registerBlock(oreAluminumOre, "AluminumOre");
        oreChromiteOre = new OreBlock(Material.rock).setBlockName("ChromiteOre");
        GameRegistry.registerBlock(oreChromiteOre, "ChromiteOre");
        oreMagnesiumOre = new OreBlock(Material.rock).setBlockName("MagnesiumOre");
        GameRegistry.registerBlock(oreMagnesiumOre, "MAgnesiumOre");
        oreTitaniumOre = new OreBlock(Material.rock).setBlockName("TitaniumOre");
        GameRegistry.registerBlock(oreTitaniumOre, "TitaniumOre");
        oreZincOre = new OreBlock(Material.rock).setBlockName("ZincOre");
        GameRegistry.registerBlock(oreZincOre, "ZincOre");
        blockCopperBlock = new MetalBlock(Material.iron).setBlockName("CopperBlock");
        GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");
        blockTinBlock = new MetalBlock(Material.iron).setBlockName("TinBlock");
        GameRegistry.registerBlock(blockTinBlock, "TinBlock");
        blockBronzeBlock = new MetalBlock(Material.iron).setBlockName("BronzeBlock");
        GameRegistry.registerBlock(blockBronzeBlock, "BronzeBlock");
        blockBrassBlock = new MetalBlock(Material.iron).setBlockName("BrassBlock");
        GameRegistry.registerBlock(blockBrassBlock, "BrassBlock");
        blockNickelBlock = new MetalBlock(Material.iron).setBlockName("NickelBlock");
        GameRegistry.registerBlock(blockNickelBlock, "NickelBlock");
        blockLeadBlock = new MetalBlock(Material.iron).setBlockName("LeadBlock");
        GameRegistry.registerBlock(blockLeadBlock, "LeadBlock");
        blockAluminumBlock = new MetalBlock(Material.iron).setBlockName("AluminumBlock");
        GameRegistry.registerBlock(blockAluminumBlock, "AluminumBlock");
        blockChromiumBlock = new MetalBlock(Material.iron).setBlockName("ChromiumBlock");
        GameRegistry.registerBlock(blockChromiumBlock, "ChromiumBlock");
        blockMagnesiumBlock = new MetalBlock(Material.iron).setBlockName("MagnesiumBlock");
        GameRegistry.registerBlock(blockMagnesiumBlock, "MagnesiumBlock");
        blockTitaniumBlock = new MetalBlock(Material.iron).setBlockName("TitaniumBlock");
        GameRegistry.registerBlock(blockTitaniumBlock, "TitaniumBlock");
        blockZincBlock = new MetalBlock(Material.iron).setBlockName("ZincBlock");
        GameRegistry.registerBlock(blockZincBlock, "ZincBlock");

        oreKraziteOre = new OreBlock(Material.sand).setBlockName("KraziteOre");
        GameRegistry.registerBlock(oreKraziteOre, "KraziteOre");
        oreZarkiteOre = new OreBlock(Material.sand).setBlockName("ZarkiteOre");
        GameRegistry.registerBlock(oreZarkiteOre, "ZarkiteOre");
        blockPurifiedKraziteOre = new PurifiedKraziteOre(Material.sand).setBlockName("PurifiedKraziteOre");
        GameRegistry.registerBlock(blockPurifiedKraziteOre, "PurifiedKraziteOre");
        blockPurifiedZarkiteOre = new PurifiedZarkiteOre(Material.sand).setBlockName("PurifiedZarkiteOre");
        GameRegistry.registerBlock(blockPurifiedZarkiteOre, "PurifiedZarkiteOre");

        //Trees
        blockLog = new MHLog().setBlockName("Log").setCreativeTab(MineHr.mineHrTab);
        GameRegistry.registerBlock(blockLog, ItemLogBlocks.class, blockLog.getUnlocalizedName().substring(5));
        blockLeaf = new MHLeaves().setBlockName("Leaf").setCreativeTab(mineHrTab);
        GameRegistry.registerBlock(blockLeaf, ItemLeafBlocks.class, blockLeaf.getUnlocalizedName().substring(5));
        blockSapling = new MHSapling().setBlockName("Sapling").setCreativeTab(mineHrTab);
        GameRegistry.registerBlock(blockSapling, ItemSaplingBlocks.class, blockSapling.getUnlocalizedName().substring(5));


        oreKelpStone = new KelpStone(Material.rock).setBlockName("KelpStone");
        GameRegistry.registerBlock(oreKelpStone, "KelpStone");
        blockKelpPile = new KelpPile(Material.water).setBlockName("KelpPile");
        GameRegistry.registerBlock(blockKelpPile, "KelpPile");
        blockLobsterTrap = new LobsterTrap(Material.wood).setBlockName("LobsterTrap");
        GameRegistry.registerBlock(blockLobsterTrap, "LobsterTrap");
        blockWorkbench = new Workbench().setBlockName("Workbench");
        GameRegistry.registerBlock(blockWorkbench, "Workbench");
        blockTrapBuoy = new TrapBuoy(Material.gourd).setBlockName("TrapBuoy");
        GameRegistry.registerBlock(blockTrapBuoy, "TrapBuoy");
        blockOilLampOn = new OilLamp(true).setBlockName("OilLampOn");
        GameRegistry.registerBlock(blockOilLampOn, "OilLampOn");
        blockOilLampOff = new OilLamp(false).setBlockName("OilLampOff").setCreativeTab(mineHrTab);
        GameRegistry.registerBlock(blockOilLampOff, "OilLampOff");
        blockStage = new Stage().setBlockName("Stage");
        GameRegistry.registerBlock(blockStage, "Stage");

        itemCodFillet = new MHDryingSeed(cropDryingCod, MineHr.blockStage).setUnlocalizedName("CodFillet").setTextureName(MineHr.modid + ":CodFillet");
        GameRegistry.registerItem(itemCodFillet, "CodFillet");

        //rarity 1 - 10
        MinecraftForge.addGrassSeed(new ItemStack(cropHempSeeds), 4);

        //Spawn
        GameRegistry.registerWorldGenerator(eventWorldGen, 0);

        //Renderers
        proxy.registerRenderThings();

    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {

        FMLCommonHandler.instance().bus().register(new CraftingHandler());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        //recipes
        //TODO
        RecipeRemover.removeRecipe(Items.boat);
        RecipeRemover.removeRecipe(Items.fishing_rod);
        RecipeRemover.removeRecipe(Items.stone_axe);
        RecipeRemover.removeRecipe(Items.stone_pickaxe);
        RecipeRemover.removeRecipe(Items.stone_hoe);
        RecipeRemover.removeRecipe(Items.stone_shovel);
        RecipeRemover.removeRecipe(Items.stone_sword);

        //Recipes - Metal Blocks
        GameRegistry.addRecipe(new ItemStack(blockCopperBlock), new Object[]{"CCC","CCC","CCC",'C', itemCopperIngot});
        GameRegistry.addRecipe(new ItemStack(blockTinBlock), new Object[]{"CCC","CCC","CCC",'C', itemTinIngot});
        GameRegistry.addRecipe(new ItemStack(blockBronzeBlock), new Object[]{"CCC","CCC","CCC",'C', itemBronzeIngot});
        GameRegistry.addRecipe(new ItemStack(blockBrassBlock), new Object[]{"CCC","CCC","CCC",'C', itemBrassIngot});
        GameRegistry.addRecipe(new ItemStack(blockNickelBlock), new Object[]{"CCC","CCC","CCC",'C', itemNickelIngot});
        GameRegistry.addRecipe(new ItemStack(blockLeadBlock), new Object[]{"CCC","CCC","CCC",'C', itemLeadIngot});
        GameRegistry.addRecipe(new ItemStack(blockAluminumBlock), new Object[]{"CCC","CCC","CCC",'C', itemAluminumIngot});
        GameRegistry.addRecipe(new ItemStack(blockChromiumBlock), new Object[]{"CCC","CCC","CCC",'C', itemChromiumIngot});
        GameRegistry.addRecipe(new ItemStack(blockMagnesiumBlock), new Object[]{"CCC","CCC","CCC",'C', itemMagnesiumIngot});
        GameRegistry.addRecipe(new ItemStack(blockTitaniumBlock), new Object[]{"CCC","CCC","CCC",'C', itemTitaniumIngot});
        GameRegistry.addRecipe(new ItemStack(blockZincBlock), new Object[]{"CCC","CCC","CCC",'C', itemZincIngot});
        GameRegistry.addRecipe(new ItemStack(blockPurifiedKraziteOre), new Object[]{"CC","CC",'C', itemKraziteDust});
        GameRegistry.addRecipe(new ItemStack(blockPurifiedZarkiteOre), new Object[]{"CC","CC",'C', itemZarkiteDust});

        //Recipes - Stone Tools
        GameRegistry.addRecipe(new ItemStack(Items.stone_axe), new Object[]{" CC","EDC"," D ",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});
        GameRegistry.addRecipe(new ItemStack(Items.stone_pickaxe), new Object[]{"CCC","EDE"," D ",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});
        GameRegistry.addRecipe(new ItemStack(Items.stone_shovel), new Object[]{" C ","EDE"," D ",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});
        GameRegistry.addRecipe(new ItemStack(Items.stone_hoe), new Object[]{"CC ","ED "," D ",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});
        GameRegistry.addRecipe(new ItemStack(Items.stone_sword), new Object[]{" C "," C ","EDE",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});

        //Recipes - Horizon Tools and Armor
        GameRegistry.addRecipe(new ItemStack(toolHorizonAxe), new Object[]{" CC","EDC"," D ",'C', itemHorizonCrystal, 'D', Items.stick, 'E', itemRawResin});
        GameRegistry.addRecipe(new ItemStack(toolHorizonPickaxe), new Object[]{"CCC","EDE"," D ",'C', itemHorizonCrystal, 'D', Items.stick, 'E', itemRawResin});
        GameRegistry.addRecipe(new ItemStack(toolHorizonShovel), new Object[]{" C ","EDE"," D ",'C', itemHorizonCrystal, 'D', Items.stick, 'E', itemRawResin});
        GameRegistry.addRecipe(new ItemStack(toolHorizonHoe), new Object[]{"CC ","ED "," D ",'C', itemHorizonCrystal, 'D', Items.stick, 'E', itemRawResin});
        GameRegistry.addRecipe(new ItemStack(toolHorizonSword), new Object[]{" C "," C ","EDE",'C', itemHorizonCrystal, 'D', Items.stick, 'E', itemRawResin});
        //TODO enchanted crating
        GameRegistry.addRecipe(new ItemStack(toolHorizonSword), new Object[]{" C "," CF","EDE",'C', itemHorizonCrystal, 'D', Items.stick, 'E', itemRawResin, 'F', Items.diamond});

        //Recipes - Alloys
        GameRegistry.addRecipe(new ItemStack(itemBronzeIngot, 2), new Object[]{"CC", "CD", 'C', itemCopperIngot, 'D', itemTinIngot});
        GameRegistry.addRecipe(new ItemStack(itemBrassIngot, 2), new Object[]{"CC", "CD", 'C', itemCopperIngot, 'D', itemZincIngot});

        //Recipes - Mod Blocks
        GameRegistry.addRecipe(new ItemStack(blockKelpPile), new Object[]{"CCC","CCC","CCC",'C', itemKelp});
        GameRegistry.addRecipe(new ItemStack(blockWorkbench), new Object[]{"CCC", "DED", "DFD", 'C', Blocks.planks, 'D', Items.stick, 'E', new ItemStack(itemPliers, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(itemMallet, 1, OreDictionary.WILDCARD_VALUE)});

        //Recipes - Food
        GameRegistry.addRecipe(new ItemStack(itemFishFillet), new Object[]{"   "," C "," D ",'C', new ItemStack(itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', Items.fish});
        GameRegistry.addRecipe(new ItemStack(itemCodFillet), new Object[]{"   "," C "," D ",'C', new ItemStack(itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', itemRawCod});
        GameRegistry.addRecipe(new ItemStack(itemCodTongue), new Object[]{"   ","CD ","   ",'C', new ItemStack(itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', itemRawCod});
        GameRegistry.addRecipe(new ItemStack(itemCrabLegs), new Object[]{"C","D",'C', new ItemStack(itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', itemRawCrab});
        GameRegistry.addRecipe(new ItemStack(itemLobsterClaws), new Object[]{"C  "," D ",'C', new ItemStack(itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', itemRawLobster});
        GameRegistry.addRecipe(new ItemStack(foodCookedLobsterClaws), new Object[]{"C  "," D ",'C', new ItemStack(itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', foodCookedLobster});
        GameRegistry.addRecipe(new ItemStack(itemLobsterTail), new Object[]{"C","D",'C', new ItemStack(itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', itemRawLobster});
        GameRegistry.addRecipe(new ItemStack(foodCookedLobsterTail), new Object[]{"C","D",'C', new ItemStack(itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', foodCookedLobster});
        GameRegistry.addShapelessRecipe(new ItemStack(foodLobsterMeal), new Object[]{foodCookedLobsterClaws, foodCookedLobsterTail, Items.carrot, Items.potato});

        //Recipes - Components
        GameRegistry.addRecipe(new ItemStack(itemIronPlate, 2), new Object[]{"C","D",'C', new ItemStack(itemMallet, 1, OreDictionary.WILDCARD_VALUE), 'D', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(itemIronWire, 3), new Object[]{"D","C",'C', new ItemStack(itemPliers, 1, OreDictionary.WILDCARD_VALUE), 'D', itemIronPlate});
        GameRegistry.addRecipe(new ItemStack(itemIronHook), new Object[]{"CD",'C', new ItemStack(itemPliers, 1, OreDictionary.WILDCARD_VALUE), 'D', itemIronWire});
        GameRegistry.addRecipe(new ItemStack(itemBoneHook), new Object[]{"CD",'C', new ItemStack(itemPliers, 1, OreDictionary.WILDCARD_VALUE), 'D', Items.bone});
        GameRegistry.addRecipe(new ItemStack(itemRope), new Object[]{"CCC",'C', Items.string});
        GameRegistry.addShapelessRecipe(new ItemStack(itemTwine, 2), new Object[]{Items.string});
        GameRegistry.addRecipe(new ItemStack(itemNetting), new Object[]{"CDC", "DDD", "CDC", 'C', itemRope, 'D', itemTwine});

        //Recipes - Tools
        GameRegistry.addRecipe(new ItemStack(itemFilletKnife), new Object[]{"C","D",'C', Items.iron_ingot,'D',Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemMallet), new Object[]{"CCC"," D ", " D ", 'C', Items.iron_ingot,'D',Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemPliers), new Object[]{"C E"," C ", "D D", 'C', Items.iron_ingot,'D',Items.stick, 'E', new ItemStack(itemMallet, 1, OreDictionary.WILDCARD_VALUE)});

        //420
        GameRegistry.addRecipe(new ItemStack(itemHerbGrinder), new Object[]{"C", "D", "C", 'C', itemIronPlate, 'D', itemIronWire});
        GameRegistry.addShapelessRecipe(new ItemStack(itemHempSpice, 2), new Object[]{cropHemp, itemHerbGrinder});

        GameRegistry.addShapelessRecipe(new ItemStack(itemGlassMix, 2), new Object[]{itemSodaAsh, Blocks.sand});
        //TODO


        //smelting
        GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 0);
        GameRegistry.addSmelting(oreTinOre, new ItemStack(itemTinIngot), 0);
        GameRegistry.addSmelting(oreNickelOre, new ItemStack(itemNickelIngot), 0);
        GameRegistry.addSmelting(oreLeadOre, new ItemStack(itemLeadIngot), 0);
        GameRegistry.addSmelting(oreAluminumOre, new ItemStack(itemAluminumIngot), 0);
        GameRegistry.addSmelting(oreChromiteOre, new ItemStack(itemChromiumIngot), 0);
        GameRegistry.addSmelting(oreMagnesiumOre, new ItemStack(itemMagnesiumIngot), 0);
        GameRegistry.addSmelting(oreTitaniumOre, new ItemStack(itemTitaniumIngot), 0);
        GameRegistry.addSmelting(oreZincOre, new ItemStack(itemZincIngot), 0);

        GameRegistry.addSmelting(blockPurifiedKraziteOre, new ItemStack(itemKraziteCrystal), 5);
        GameRegistry.addSmelting(blockPurifiedZarkiteOre, new ItemStack(itemZarkiteCrystal), 5);

        GameRegistry.addSmelting(itemRawLobster, new ItemStack(foodCookedLobster), 0);
        GameRegistry.addSmelting(itemCodFillet, new ItemStack(foodCookedCodFillet), 0);
        GameRegistry.addSmelting(itemCodTongue, new ItemStack(foodCookedCodTongue), 0);
        GameRegistry.addSmelting(itemCrabLegs, new ItemStack(foodCookedCrabLegs), 0);
        GameRegistry.addSmelting(itemLobsterClaws, new ItemStack(foodCookedLobsterClaws), 0);
        GameRegistry.addSmelting(itemLobsterTail, new ItemStack(foodCookedLobsterTail), 0);
        GameRegistry.addSmelting(itemFishFillet, new ItemStack(foodCookedFishFillet), 0);

        GameRegistry.addSmelting(itemKelp, new ItemStack(itemSodaAsh), 0);
        GameRegistry.addSmelting(itemRawResin, new ItemStack(itemNaturalRubber), 0);

        GameRegistry.registerFuelHandler(new FuelHandler());

        //Entities
        EntityHandler.registerMonsters(EntityCrab.class,  "Crab");

    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent postEvent) {

    }

}

