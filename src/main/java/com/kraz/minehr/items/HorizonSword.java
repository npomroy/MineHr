package com.kraz.minehr.items;

import com.kraz.minehr.MineHr;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HorizonSword extends ItemSword {

    public HorizonSword() {
        super(MineHr.HorizonToolMaterial);

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(MineHr.modid + ":" + this.getUnlocalizedName().substring(5));
    }


}

