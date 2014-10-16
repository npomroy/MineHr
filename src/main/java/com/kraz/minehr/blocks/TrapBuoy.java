package com.kraz.minehr.blocks;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.init.ItemInit;
import com.kraz.minehr.reference.Reference;
import com.kraz.minehr.tileentity.TileEntityTrapBuoy;
import com.kraz.minehr.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class TrapBuoy extends BlockContainer {

    private int haulTick;
    private int haulMax;


    public TrapBuoy(Material material) {
        super(material);


        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeCloth);
        this.setCreativeTab(MineHr.mineHrTab);
        this.setTickRandomly(true);
        haulMax = 20;
        haulTick = 0;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }

    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
        TileEntityTrapBuoy tileentity = (TileEntityTrapBuoy)world.getTileEntity(x, y, z);
        //pull in trap
        if(tileentity != null) {
            if(haulTick == haulMax && haulMax != 0) {
                ItemStack buoyStack = new ItemStack(MineHr.blockTrapBuoy);
                ItemStack ropeStack = new ItemStack(ItemInit.itemRope, 8);
                ItemStack trapStack = new ItemStack(MineHr.blockLobsterTrap);
                ItemStack fishStack = new ItemStack(ItemInit.itemRawLobster, tileentity.getFishAmount());
                player.inventory.addItemStackToInventory(buoyStack);
                player.inventory.addItemStackToInventory(ropeStack);
                player.inventory.addItemStackToInventory(trapStack);
                player.inventory.addItemStackToInventory(fishStack);
                world.setBlockToAir(x, y, z);
                world.setBlock(x, y - tileentity.getDepth() - 1, z, Blocks.water);
                world.removeTileEntity(x, y, z);
                haulTick = 0;
            }else{
                haulTick++;
            }
            return true;
        } else {
            return false;
        }
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityTrapBuoy();
    }

    public int quantityDropped() {
        return 0;
    }

    public void breakBlock(World world, int x, int y, int z, int i, int j) {

        world.removeTileEntity(x, y, z);
        world.setBlockToAir(x, y, z);
    }

    public void updateTick(World world, int x, int y, int z, Random random)
    {
        TileEntityTrapBuoy tileentity = (TileEntityTrapBuoy)world.getTileEntity(x, y, z);
        if (tileentity.getDepth() >= Reference.lobsterTrapMinDepth && tileentity.getDepth() < Reference.lobsterTrapBonusDepth) {
            int i1 = world.getBlockMetadata(x, y, z);
            Random random1 = new Random();

            if (i1 == 15 && Math.floor(random1.nextInt(100)) <= Reference.lobsterTrapCatchChance)
            {
                tileentity.incrementFishAmount();
                world.setBlockMetadataWithNotify(x, y, z, 0, 4);
            }
            else
            {
                world.setBlockMetadataWithNotify(x, y, z, i1 + 1, 4);
            }
        } else if (tileentity.getDepth() >= Reference.lobsterTrapBonusDepth) {
            int i1 = world.getBlockMetadata(x, y, z);
            Random random1 = new Random();

            if (i1 == 15 && Math.floor(random1.nextInt(100 * Reference.lobsterTrapBonusFactor)) <= Reference.lobsterTrapCatchChance)
            {
                tileentity.incrementFishAmount();
                world.setBlockMetadataWithNotify(x, y, z, 0, 4);
            }
            else
            {
                world.setBlockMetadataWithNotify(x, y, z, i1 + 1, 4);
            }
        }
    }


}
