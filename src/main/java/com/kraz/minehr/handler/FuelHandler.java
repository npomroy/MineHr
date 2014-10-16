package com.kraz.minehr.handler;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.init.ItemInit;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if(fuel.getItem() == ItemInit.itemKelp) return 200;
        return 0;
    }

}
