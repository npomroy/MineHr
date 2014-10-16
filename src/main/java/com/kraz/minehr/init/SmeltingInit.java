package com.kraz.minehr.init;

import com.kraz.minehr.MineHr;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

/**
 * Created by Nick on 10/14/2014.
 */
public class SmeltingInit {

    public static void init() {
        GameRegistry.addSmelting(MineHr.oreCopperOre, new ItemStack(ItemInit.itemCopperIngot), 0);
        GameRegistry.addSmelting(MineHr.oreTinOre, new ItemStack(ItemInit.itemTinIngot), 0);
        GameRegistry.addSmelting(MineHr.oreNickelOre, new ItemStack(ItemInit.itemNickelIngot), 0);
        GameRegistry.addSmelting(MineHr.oreLeadOre, new ItemStack(ItemInit.itemLeadIngot), 0);
        GameRegistry.addSmelting(MineHr.oreAluminumOre, new ItemStack(ItemInit.itemAluminumIngot), 0);
        GameRegistry.addSmelting(MineHr.oreChromiteOre, new ItemStack(ItemInit.itemChromiumIngot), 0);
        GameRegistry.addSmelting(MineHr.oreMagnesiumOre, new ItemStack(ItemInit.itemMagnesiumIngot), 0);
        GameRegistry.addSmelting(MineHr.oreTitaniumOre, new ItemStack(ItemInit.itemTitaniumIngot), 0);
        GameRegistry.addSmelting(MineHr.oreZincOre, new ItemStack(ItemInit.itemZincIngot), 0);

        GameRegistry.addSmelting(MineHr.blockPurifiedKraziteOre, new ItemStack(ItemInit.itemKraziteCrystal), 5);
        GameRegistry.addSmelting(MineHr.blockPurifiedZarkiteOre, new ItemStack(ItemInit.itemZarkiteCrystal), 5);

        GameRegistry.addSmelting(ItemInit.itemRawLobster, new ItemStack(MineHr.foodCookedLobster), 0);
        GameRegistry.addSmelting(MineHr.itemCodFillet, new ItemStack(MineHr.foodCookedCodFillet), 0);
        GameRegistry.addSmelting(ItemInit.itemCodTongue, new ItemStack(MineHr.foodCookedCodTongue), 0);
        GameRegistry.addSmelting(ItemInit.itemCrabLegs, new ItemStack(MineHr.foodCookedCrabLegs), 0);
        GameRegistry.addSmelting(ItemInit.itemLobsterClaws, new ItemStack(MineHr.foodCookedLobsterClaws), 0);
        GameRegistry.addSmelting(ItemInit.itemLobsterTail, new ItemStack(MineHr.foodCookedLobsterTail), 0);
        GameRegistry.addSmelting(ItemInit.itemFishFillet, new ItemStack(MineHr.foodCookedFishFillet), 0);

        GameRegistry.addSmelting(ItemInit.itemKelp, new ItemStack(ItemInit.itemSodaAsh), 0);
        GameRegistry.addSmelting(ItemInit.itemRawResin, new ItemStack(ItemInit.itemNaturalRubber), 0);
    }
}
