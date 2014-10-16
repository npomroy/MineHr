package com.kraz.minehr.items;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Mallet extends Item {

    public Mallet(){
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(64);
        this.setNoRepair();
        this.setCreativeTab(MineHr.mineHrTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }

}
