package com.kraz.minehr;

import com.kraz.minehr.armor.HorizonArmor;
import com.kraz.minehr.armor.RubberArmor;
import com.kraz.minehr.biome.features.MHLeaves;
import com.kraz.minehr.biome.features.MHLog;
import com.kraz.minehr.biome.features.MHSapling;
import com.kraz.minehr.blocks.*;
import com.kraz.minehr.client.handler.KeyInputEventHandler;
import com.kraz.minehr.crafting.RecipeRemover;
import com.kraz.minehr.entity.EntityCrab;
import com.kraz.minehr.handler.ConfigurationHandler;
import com.kraz.minehr.handler.CraftingHandler;
import com.kraz.minehr.handler.EntityHandler;
import com.kraz.minehr.handler.FuelHandler;
import com.kraz.minehr.handler.GuiHandler;
import com.kraz.minehr.init.ItemInit;
import com.kraz.minehr.init.RecipeInit;
import com.kraz.minehr.init.SmeltingInit;
import com.kraz.minehr.items.*;
import com.kraz.minehr.proxy.CommonProxy;
import com.kraz.minehr.reference.Reference;
import com.kraz.minehr.tileentity.TileEntityLobsterTrap;
import com.kraz.minehr.tileentity.TileEntityOilLamp;
import com.kraz.minehr.tileentity.TileEntityTrapBuoy;
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

@Mod(modid= Reference.MOD_ID, name= Reference.MOD_NAME, version= Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MineHr {

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

    public static Item itemSalt;

    public static Item itemHerbGrinder;
    public static Item itemJigger;
    public static Item itemMallet;
    public static Item itemPliers;
    public static Item itemFilletKnife;
    public static Item itemIronRod;;
    public static Item foodCookedLobster;
    public static Item foodCookedFishFillet;
    public static Item itemCodFillet;
    public static Item foodCookedCodFillet;
    public static Item foodCookedCodTongue;
    public static Item foodCookedCrabLegs;
    public static Item foodCookedLobsterClaws;
    public static Item foodCookedLobsterTail;
    public static Item foodLobsterMeal;
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
    public static Block blockStore;

    public static Block blockWorkbench;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Instance(Reference.MOD_ID)
    public static com.kraz.minehr.MineHr instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent preEvent){

        ConfigurationHandler.init(preEvent.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());


        mineHrTab = new CreativeTabs("MineHr") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return MineHr.foodCookedLobster;
            }
        };

        proxy.registerKeyBindings();

        ItemInit.init();

        //Crops
        cropHempPlant = new MHCrop().setBlockName("HempPlant");
        GameRegistry.registerBlock(cropHempPlant, "HempPlant");
        cropHempSeeds = new ItemSeeds(cropHempPlant, Blocks.farmland).setUnlocalizedName("HempSeeds").setTextureName(Reference.MOD_ID + ":HempSeeds").setCreativeTab(mineHrTab);
        GameRegistry.registerItem(cropHempSeeds, "HempSeeds");
        cropHemp = new MHItems().setUnlocalizedName("Hemp");
        GameRegistry.registerItem(cropHemp, "Hemp");
        cropDryingCod = new BlockMHDrying(itemCodFillet).setBlockName("DryingCod");
        GameRegistry.registerBlock(cropDryingCod, "DryingCod");

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
        itemJigger = new Jigger().setUnlocalizedName("Jigger");
        GameRegistry.registerItem(itemJigger, "Jigger");
        itemMallet = new Mallet().setUnlocalizedName("Mallet");
        GameRegistry.registerItem(itemMallet, "Mallet");
        itemPliers = new Pliers().setUnlocalizedName("Pliers");
        GameRegistry.registerItem(itemPliers, "Pliers");
        itemFilletKnife = new FilletKnife(KnifeMaterial).setUnlocalizedName("FilletKnife");
        GameRegistry.registerItem(itemFilletKnife, "FilletKnife");
        itemIronRod = new IronRod().setUnlocalizedName("IronRod");
        GameRegistry.registerItem(itemIronRod, "IronRod");


        //Food
        //Heal amount - Saturation - isWolfMeat
        foodCookedLobster = new ItemFood(6, 0.3F, false).setUnlocalizedName("CookedLobster").setCreativeTab(mineHrTab).setTextureName(Reference.MOD_ID + ":CookedLobster");
        GameRegistry.registerItem(foodCookedLobster, "CookedLobster");
        foodCookedFishFillet = new ItemFood(4, 0.4F, true).setUnlocalizedName("CookedFishFillet").setCreativeTab(mineHrTab).setTextureName(Reference.MOD_ID + ":CookedFishFillet");
        GameRegistry.registerItem(foodCookedFishFillet, "CookedFishFillet");
        foodCookedCodFillet = new ItemFood(4, 0.4F, true).setUnlocalizedName("CookedCodFillet").setCreativeTab(mineHrTab).setTextureName(Reference.MOD_ID + ":CookedCodFillet");
        GameRegistry.registerItem(foodCookedCodFillet, "CookedCodFillet");
        foodCookedCodTongue = new CodTongue(2, 0.3F, false).setUnlocalizedName("CookedCodTongue").setCreativeTab(mineHrTab).setTextureName(Reference.MOD_ID + ":CookedCodTongue");
        GameRegistry.registerItem(foodCookedCodTongue, "CookedCodTongue");
        foodCookedCrabLegs = new ItemFood(4, 0.7F, false).setUnlocalizedName("CookedCrabLegs").setCreativeTab(mineHrTab).setTextureName(Reference.MOD_ID + ":CookedCrabLegs");
        GameRegistry.registerItem(foodCookedCrabLegs, "CookedCrabLegs");
        foodCookedLobsterClaws = new ItemFood(3, 0.5F, false).setUnlocalizedName("CookedLobsterClaws").setCreativeTab(mineHrTab).setTextureName(Reference.MOD_ID + ":CookedLobsterClaws");
        GameRegistry.registerItem(foodCookedLobsterClaws, "CookedLobsterClaws");
        foodCookedLobsterTail = new ItemFood(4, 0.6F, false).setUnlocalizedName("CookedLobsterTail").setCreativeTab(mineHrTab).setTextureName(Reference.MOD_ID + ":CookedLobsterTail");
        GameRegistry.registerItem(foodCookedLobsterTail, "CookedLobsterTail");
        foodLobsterMeal = new ItemFood(10, 0.9F, true).setUnlocalizedName("LobsterMeal").setCreativeTab(mineHrTab).setTextureName(Reference.MOD_ID + ":LobsterMeal");
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
        GameRegistry.registerTileEntity(TileEntityLobsterTrap.class, "TileEntityLobsterTrap");
        blockWorkbench = new Workbench().setBlockName("Workbench");
        GameRegistry.registerBlock(blockWorkbench, "Workbench");
        blockTrapBuoy = new TrapBuoy(Material.gourd).setBlockName("TrapBuoy");
        GameRegistry.registerBlock(blockTrapBuoy, "TrapBuoy");
        GameRegistry.registerTileEntity(TileEntityTrapBuoy.class, "TileEntityTrapBuoy");
        blockOilLampOn = new OilLamp(true).setBlockName("OilLampOn");
        GameRegistry.registerBlock(blockOilLampOn, "OilLampOn");
        blockOilLampOff = new OilLamp(false).setBlockName("OilLampOff").setCreativeTab(mineHrTab);
        GameRegistry.registerBlock(blockOilLampOff, "OilLampOff");
        GameRegistry.registerTileEntity(TileEntityOilLamp.class, "TileEntityOilLamp");
        blockStage = new Stage().setBlockName("Stage");
        GameRegistry.registerBlock(blockStage, "Stage");

        blockStore = new BlockStore().setBlockName("StoreBlock");
        GameRegistry.registerBlock(blockStore, "StoreBlock");

        itemCodFillet = new MHDryingSeed(cropDryingCod, MineHr.blockStage).setUnlocalizedName("CodFillet").setTextureName(Reference.MOD_ID + ":CodFillet");
        GameRegistry.registerItem(itemCodFillet, "CodFillet");

        //rarity 1 - 10
        MinecraftForge.addGrassSeed(new ItemStack(cropHempSeeds), 4);

        //Spawn
        GameRegistry.registerWorldGenerator(eventWorldGen, 0);

        //Renderers
        proxy.registerRenderThings();

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        FMLCommonHandler.instance().bus().register(new CraftingHandler());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        RecipeInit.init();

        SmeltingInit.init();

        GameRegistry.registerFuelHandler(new FuelHandler());

        //Entities
        EntityHandler.registerMonsters(EntityCrab.class,  "Crab");

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent postEvent) {

    }

}

