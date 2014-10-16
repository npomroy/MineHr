package com.kraz.minehr.items;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HorizonHoe extends ItemHoe {

    public HorizonHoe() {
        super(MineHr.HorizonToolMaterial);

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }


}
