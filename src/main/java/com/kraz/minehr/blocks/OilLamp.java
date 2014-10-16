package com.kraz.minehr.blocks;

import java.util.Random;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.reference.Reference;
import com.kraz.minehr.tileentity.TileEntityOilLamp;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;



public class OilLamp extends BlockContainer {

    private final boolean isOn;

    public OilLamp(boolean isOn) {
        super(Material.redstoneLight);
        //TODO block bounds
        this.setBlockBounds(0.3125F, 0F, 0.3125F, 0.6875F, 0.8125F, 0.6875F);
        this.isOn = isOn;

        if(isOn) {
            this.setLightLevel(1.0F);
        }
    }


    public void onBlockAdded(World world, int x, int y, int z) {
        if(!world.isRemote) {
            if(this.isOn && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
                world.scheduleBlockUpdate(x, y, z, this, 4);
            } else if (!this.isOn && world.isBlockIndirectlyGettingPowered(x, y, z)){
                world.setBlock(x, y, z, MineHr.blockOilLampOn, 0, 2);
            }
        }
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(!world.isRemote) {
            if(this.isOn && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
                world.scheduleBlockUpdate(x, y, z, this, 4);
            } else if (!this.isOn && world.isBlockIndirectlyGettingPowered(x, y, z)){
                world.setBlock(x, y, z, MineHr.blockOilLampOn, 0, 2);
            }
        }
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
        if(!world.isRemote && this.isOn && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
            world.setBlock(x, y, z, MineHr.blockOilLampOff, 0, 2);
        }
    }

    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
        if (!player.isSneaking()){
            player.openGui(MineHr.instance, Reference.guiIDOilLamp, world, x, y, z);
            return true;
        } else {
            return false;
        }
    }

    public Item getItemDropped(int i, Random random, int j) {
        return Item.getItemFromBlock(MineHr.blockOilLampOff);
    }

    public ItemStack createStackedBlock(int i) {
        return new ItemStack(MineHr.blockOilLampOff);
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityOilLamp();
    }

}
