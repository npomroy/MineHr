package com.kraz.minehr.blocks;

import com.kraz.minehr.MineHr;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurifiedKraziteOre extends Block {

    public PurifiedKraziteOre(Material material) {
        super(material);


        this.setHardness(1.0F);
        this.setResistance(2.0F);
        this.setStepSound(soundTypeSand);
        this.setCreativeTab(MineHr.mineHrTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(MineHr.modid + ":" + this.getUnlocalizedName().substring(5));
    }

}
