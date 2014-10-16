package com.kraz.minehr.items;

import com.kraz.minehr.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.kraz.minehr.MineHr;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.Item.ToolMaterial;

public class IronRod extends ItemFishingRod {

    public IronRod(){
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(128);
        this.setNoRepair();
        this.setCreativeTab(MineHr.mineHrTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }

}
