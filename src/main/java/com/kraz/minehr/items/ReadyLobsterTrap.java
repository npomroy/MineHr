package com.kraz.minehr.items;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.reference.Reference;
import com.kraz.minehr.tileentity.TileEntityTrapBuoy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.ForgeEventFactory;

public class ReadyLobsterTrap extends Item {
    public ReadyLobsterTrap(){
        super();
        this.maxStackSize = 1;
        this.setNoRepair();
        this.setCreativeTab(MineHr.mineHrTab);
        this.setUnlocalizedName("ReadyLobsterTrap");
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }


    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_7_ != 1)
        {
            return false;
        }
        else if (entityPlayer.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, itemStack) && entityPlayer.canPlayerEdit(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, itemStack))
        {
            if (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == MineHr.oreKelpStone && world.isAirBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_))
            {
                //raycast to bottom then lay
                int depth = 1;
                while(world.getBlock(p_77648_4_, p_77648_5_ - depth, p_77648_6_) == Blocks.water){
                    depth += 1;
                }

                world.setBlock(p_77648_4_, p_77648_5_ - depth, p_77648_6_, MineHr.blockLobsterTrap);
                --itemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World world, EntityPlayer p_77659_3_)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, p_77659_3_, true);

        if (movingobjectposition == null)
        {
            return p_77659_1_;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!world.canMineBlock(p_77659_3_, i, j, k))
                {
                    return p_77659_1_;
                }

                if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
                {
                    return p_77659_1_;
                }

                if (world.getBlock(i, j, k).getMaterial() == Material.water && world.getBlockMetadata(i, j, k) == 0 && world.isAirBlock(i, j + 1, k))
                {
                    // special case for handling block placement with water lilies
                    BlockSnapshot blocksnapshot = BlockSnapshot.getBlockSnapshot(world, i, j + 1, k);
                    world.setBlock(i, j + 1, k, MineHr.blockTrapBuoy);
                    TileEntityTrapBuoy tileentity = (TileEntityTrapBuoy)world.getTileEntity(i, j + 1, k);
                    if (ForgeEventFactory.onPlayerBlockPlace(p_77659_3_, blocksnapshot, ForgeDirection.UP).isCanceled())
                    {
                        blocksnapshot.restore(true, false);
                        return p_77659_1_;
                    }

                    if (!p_77659_3_.capabilities.isCreativeMode)
                    {
                        --p_77659_1_.stackSize;
                    }

                    int depth = 1;
                    while(world.getBlock(i, j - depth, k) == Blocks.water){
                        depth += 1;
                    }

                    world.setBlock(i, j - depth, k, MineHr.blockLobsterTrap);
                    tileentity.setDepth(depth);
                }
            }

            return p_77659_1_;
        }
    }

}
