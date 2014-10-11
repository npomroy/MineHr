package com.kraz.minehr.container;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.crafting.WorkbenchCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerWorkbench extends Container {

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerWorkbench(InventoryPlayer invPlayer, World world, int x, int y, int z) {
        //4 x 4 CRAFTING TABLE
        this.craftMatrix = new InventoryCrafting(this, 4, 4);
        this.craftResult = new InventoryCraftResult();
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;

        this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 124, 35));

        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                this.addSlotToContainer(new Slot(craftMatrix, k + i * 4, 18 + k * 18, 8 + i * 18));
            }
        }

        for (int i = 0; i < 3; i++) {
            for(int k = 0; k < 9; k++) {
                this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 97 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 155));
        }

        onCraftMatrixChanged(craftMatrix);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 >= 10 && par2 < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (par2 >= 37 && par2 < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }

    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        super.onContainerClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }

    public void onCraftMatrixChanged(IInventory iinventory) {
        craftResult.setInventorySlotContents(0, WorkbenchCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        if(worldObj.getBlock(posX,  posY, posZ) != MineHr.blockWorkbench) {
            return false;
        } else {
            return player.getDistanceSq((double)posX + 0.5D, (double)posY +0.5D, (double)posZ + 0.5D) <= 64.0D;
        }
    }

}