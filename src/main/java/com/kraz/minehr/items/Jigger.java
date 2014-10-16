package com.kraz.minehr.items;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.init.ItemInit;
import com.kraz.minehr.reference.Reference;
import com.kraz.minehr.tileentity.TileEntityTrapBuoy;
import com.kraz.minehr.util.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Jigger extends Item {

    private int jigTick;
    private int jigMax;

    public Jigger(){
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(128);
        this.setNoRepair();
        this.setCreativeTab(MineHr.mineHrTab);
        jigMax = 10;
        jigTick = jigMax;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

        if (movingobjectposition == null)
        {
            return itemStack;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!world.canMineBlock(player, i, j, k))
                {
                    return itemStack;
                }

                if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack))
                {
                    return itemStack;
                }

                if (world.getBlock(i, j, k).getMaterial() == Material.water)
                {

                    if(jigTick == jigMax && jigMax != 0) {

                        world.playSoundAtEntity(player, "random.bow", 1.0f, 1.0f);

                        if (!player.capabilities.isCreativeMode) {
                            itemStack.setItemDamage(itemStack.getItemDamage() + 1);
                        }

                        int depth = 1;
                        while (world.getBlock(i, j - depth, k) == Blocks.water) {
                            depth += 1;
                        }

                        if (depth >= Reference.jigMinDepth && depth < Reference.jigBonusDepth) {
                            Random random = new Random();
                            if (random.nextInt(100) <= Reference.jigCatchChance) {
                                ItemStack fish = new ItemStack(ItemInit.itemRawCod, 1);
                                player.inventory.addItemStackToInventory(fish);
                            }
                        } else if (depth >= Reference.jigBonusDepth) {
                            Random random = new Random();
                            if (random.nextInt(100) <= Reference.jigBonusCatchChance) {
                                ItemStack fish = new ItemStack(ItemInit.itemRawCod, 1);
                                player.inventory.addItemStackToInventory(fish);
                            }
                        }
                        jigTick = 0;
                    } else {
                        ++jigTick;
                    }
                }
            }

            return itemStack;
        }
    }
}
