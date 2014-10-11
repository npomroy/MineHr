package com.kraz.minehr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.kraz.minehr.MineHr;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;

public class HorizonPickaxe extends ItemPickaxe {

    public HorizonPickaxe() {
        super(MineHr.HorizonToolMaterial);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(MineHr.modid + ":" + this.getUnlocalizedName().substring(5));
    }


}
