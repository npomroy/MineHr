package com.kraz.minehr.blocks;

import java.util.Random;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.init.ItemInit;
import com.kraz.minehr.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KelpStone extends Block {
    public KelpStone(Material material) {
        super(material);


        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(MineHr.mineHrTab);
    }

    public Item getItemDropped(int i, Random random, int j) {
        return ItemInit.itemKelp;
    }

    public int quantityDropped(Random random) {
        return 1 + random.nextInt(3);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }
}
