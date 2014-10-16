package com.kraz.minehr.blocks;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurifiedZarkiteOre extends Block {

    public PurifiedZarkiteOre(Material material) {
        super(material);


        this.setHardness(1.0F);
        this.setResistance(2.0F);
        this.setStepSound(soundTypeSand);
        this.setCreativeTab(MineHr.mineHrTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }

}
