package com.kraz.minehr.init;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.crafting.RecipeRemover;
import com.kraz.minehr.handler.ConfigurationHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Nick on 10/14/2014.
 */
public class RecipeInit {
    public static void init () {
        if (!ConfigurationHandler.vRecipeBoat) {
            RecipeRemover.removeRecipe(Items.boat);
        }
        if (!ConfigurationHandler.vRecipeFishingRod) {
            RecipeRemover.removeRecipe(Items.fishing_rod);
        }
        if (!ConfigurationHandler.vRecipeStoneTools) {
            RecipeRemover.removeRecipe(Items.stone_axe);
            RecipeRemover.removeRecipe(Items.stone_pickaxe);
            RecipeRemover.removeRecipe(Items.stone_hoe);
            RecipeRemover.removeRecipe(Items.stone_shovel);
            RecipeRemover.removeRecipe(Items.stone_sword);
        }

        //Recipes - Metal Blocks
        GameRegistry.addRecipe(new ItemStack(MineHr.blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', ItemInit.itemCopperIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockTinBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemTinIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockBronzeBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemBronzeIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockBrassBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemBrassIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockNickelBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemNickelIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockLeadBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemLeadIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockAluminumBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemAluminumIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockChromiumBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemChromiumIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockMagnesiumBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemMagnesiumIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockTitaniumBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemTitaniumIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockZincBlock), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemZincIngot});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockPurifiedKraziteOre), new Object[]{"CC","CC",'C', ItemInit.itemKraziteDust});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockPurifiedZarkiteOre), new Object[]{"CC","CC",'C', ItemInit.itemZarkiteDust});

        //Recipes - Stone Tools
        GameRegistry.addRecipe(new ItemStack(Items.stone_axe), new Object[]{" CC","EDC"," D ",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});
        GameRegistry.addRecipe(new ItemStack(Items.stone_pickaxe), new Object[]{"CCC","EDE"," D ",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});
        GameRegistry.addRecipe(new ItemStack(Items.stone_shovel), new Object[]{" C ","EDE"," D ",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});
        GameRegistry.addRecipe(new ItemStack(Items.stone_hoe), new Object[]{"CC ","ED "," D ",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});
        GameRegistry.addRecipe(new ItemStack(Items.stone_sword), new Object[]{" C "," C ","EDE",'C', Blocks.cobblestone, 'D', Items.stick, 'E', Items.string});

        //Recipes - Horizon Tools and Armor
        GameRegistry.addRecipe(new ItemStack(MineHr.toolHorizonAxe), new Object[]{" CC","EDC"," D ",'C', ItemInit.itemHorizonCrystal, 'D', Items.stick, 'E', ItemInit.itemRawResin});
        GameRegistry.addRecipe(new ItemStack(MineHr.toolHorizonPickaxe), new Object[]{"CCC","EDE"," D ",'C', ItemInit.itemHorizonCrystal, 'D', Items.stick, 'E', ItemInit.itemRawResin});
        GameRegistry.addRecipe(new ItemStack(MineHr.toolHorizonShovel), new Object[]{" C ","EDE"," D ",'C', ItemInit.itemHorizonCrystal, 'D', Items.stick, 'E', ItemInit.itemRawResin});
        GameRegistry.addRecipe(new ItemStack(MineHr.toolHorizonHoe), new Object[]{"CC ","ED "," D ",'C', ItemInit.itemHorizonCrystal, 'D', Items.stick, 'E', ItemInit.itemRawResin});
        GameRegistry.addRecipe(new ItemStack(MineHr.toolHorizonSword), new Object[]{" C "," C ","EDE",'C', ItemInit.itemHorizonCrystal, 'D', Items.stick, 'E', ItemInit.itemRawResin});
        //TODO enchanted cratingMineHr.
        GameRegistry.addRecipe(new ItemStack(MineHr.toolHorizonSword), new Object[]{" C "," CF","EDE",'C', ItemInit.itemHorizonCrystal, 'D', Items.stick, 'E', ItemInit.itemRawResin, 'F', Items.diamond});

        //Recipes - Alloys
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemBronzeIngot, 2), new Object[]{"CC", "CD", 'C', ItemInit.itemCopperIngot, 'D', ItemInit.itemTinIngot});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemBrassIngot, 2), new Object[]{"CC", "CD", 'C', ItemInit.itemCopperIngot, 'D', ItemInit.itemZincIngot});

        //Recipes - Mod Blocks
        GameRegistry.addRecipe(new ItemStack(MineHr.blockKelpPile), new Object[]{"CCC","CCC","CCC",'C', ItemInit.itemKelp});
        GameRegistry.addRecipe(new ItemStack(MineHr.blockWorkbench), new Object[]{"CCC", "DED", "DFD", 'C', Blocks.planks, 'D', Items.stick, 'E', new ItemStack(MineHr.itemPliers, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(MineHr.itemMallet, 1, OreDictionary.WILDCARD_VALUE)});

        //Recipes - Food
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemFishFillet), new Object[]{"   "," C "," D ",'C', new ItemStack(MineHr.itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', Items.fish});
        GameRegistry.addRecipe(new ItemStack(MineHr.itemCodFillet), new Object[]{"   "," C "," D ",'C', new ItemStack(MineHr.itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', ItemInit.itemRawCod});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemCodTongue), new Object[]{"   ","CD ","   ",'C', new ItemStack(MineHr.itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', ItemInit.itemRawCod});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemCrabLegs), new Object[]{"C","D",'C', new ItemStack(MineHr.itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', ItemInit.itemRawCrab});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemLobsterClaws), new Object[]{"C  "," D ",'C', new ItemStack(MineHr.itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', ItemInit.itemRawLobster});
        GameRegistry.addRecipe(new ItemStack(MineHr.foodCookedLobsterClaws), new Object[]{"C  "," D ",'C', new ItemStack(MineHr.itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', MineHr.foodCookedLobster});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemLobsterTail), new Object[]{"C","D",'C', new ItemStack(MineHr.itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', ItemInit.itemRawLobster});
        GameRegistry.addRecipe(new ItemStack(MineHr.foodCookedLobsterTail), new Object[]{"C","D",'C', new ItemStack(MineHr.itemFilletKnife, 1, OreDictionary.WILDCARD_VALUE), 'D', MineHr.foodCookedLobster});
        GameRegistry.addShapelessRecipe(new ItemStack(MineHr.foodLobsterMeal), new Object[]{MineHr.foodCookedLobsterClaws, MineHr.foodCookedLobsterTail, Items.carrot, Items.potato});

        //Recipes - Components
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemIronPlate, 2), new Object[]{"C","D",'C', new ItemStack(MineHr.itemMallet, 1, OreDictionary.WILDCARD_VALUE), 'D', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemIronWire, 3), new Object[]{"D","C",'C', new ItemStack(MineHr.itemPliers, 1, OreDictionary.WILDCARD_VALUE), 'D', ItemInit.itemIronPlate});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemIronHook), new Object[]{"CD",'C', new ItemStack(MineHr.itemPliers, 1, OreDictionary.WILDCARD_VALUE), 'D', ItemInit.itemIronWire});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemBoneHook), new Object[]{"CD",'C', new ItemStack(MineHr.itemPliers, 1, OreDictionary.WILDCARD_VALUE), 'D', Items.bone});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemRope), new Object[]{"CCC",'C', Items.string});
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.itemTwine, 2), new Object[]{Items.string});
        GameRegistry.addRecipe(new ItemStack(ItemInit.itemNetting), new Object[]{"CDC", "DDD", "CDC", 'C', ItemInit.itemRope, 'D', ItemInit.itemTwine});

        //Recipes - Tools
        GameRegistry.addRecipe(new ItemStack(MineHr.itemFilletKnife), new Object[]{"C","D",'C', Items.iron_ingot,'D',Items.stick});
        GameRegistry.addRecipe(new ItemStack(MineHr.itemMallet), new Object[]{"CCC"," D ", " D ", 'C', Items.iron_ingot,'D',Items.stick});
        GameRegistry.addRecipe(new ItemStack(MineHr.itemPliers), new Object[]{"C E"," C ", "D D", 'C', Items.iron_ingot,'D',Items.stick, 'E', new ItemStack(MineHr.itemMallet, 1, OreDictionary.WILDCARD_VALUE)});

        //420
        GameRegistry.addRecipe(new ItemStack(MineHr.itemHerbGrinder), new Object[]{"C", "D", "C", 'C', ItemInit.itemIronPlate, 'D', ItemInit.itemIronWire});
        GameRegistry.addShapelessRecipe(new ItemStack(MineHr.itemHempSpice, 2), new Object[]{MineHr.cropHemp, MineHr.itemHerbGrinder});

        GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.itemGlassMix, 2), new Object[]{ItemInit.itemSodaAsh, Blocks.sand});
    }
}
