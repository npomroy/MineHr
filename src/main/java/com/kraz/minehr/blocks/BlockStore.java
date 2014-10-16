package com.kraz.minehr.blocks;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Nick on 10/14/2014.
 */
public class BlockStore extends Block {


    public BlockStore() {
        super(Material.wood);

        this.setHardness(3.5F);
        this.setResistance(5.0F);
        this.setCreativeTab(MineHr.mineHrTab);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons (IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "StoreBlock");
    }

    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
        if (!player.isSneaking()){
            player.openGui(MineHr.instance, Reference.guiIDStoreBlock, world, x, y, z);
            return true;
        } else {
            return false;
        }
    }

}