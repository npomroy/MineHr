package com.kraz.minehr.blocks;

import java.util.Random;
import com.kraz.minehr.MineHr;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TrapBuoy extends Block {
    public TrapBuoy(Material material) {
        super(material);


        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeCloth);
        this.setCreativeTab(MineHr.mineHrTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(MineHr.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
