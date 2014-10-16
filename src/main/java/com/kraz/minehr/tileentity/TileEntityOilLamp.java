package com.kraz.minehr.tileentity;

import com.kraz.minehr.init.ItemInit;
import com.kraz.minehr.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityOilLamp extends TileEntity implements ISidedInventory {

    private int fuelAmount;
    private ItemStack fuelStack;
    private String field_145942_n;

    public TileEntityOilLamp() {

    }

//    public void updateEntity() {
//        if(Reference.oilLampMaxFuel - fuelAmount > Reference.oilLampFuelValue && fuelStack.stackSize > 0) {
//            fuelStack.stackSize--;
//            fuelAmount += Reference.oilLampFuelValue;
//        }
//    }

    @Override
    public void writeToNBT(NBTTagCompound par1) {
        super.writeToNBT(par1);
        par1.setInteger("fuelAmount", fuelAmount);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1) {
        super.readFromNBT(par1);
        this.fuelAmount = par1.getInteger("fuelAmount");
        int itemAmount = par1.getInteger("itemAmount");
        if(itemAmount > 0) {
            this.fuelStack = new ItemStack(ItemInit.itemFishGuts, itemAmount);
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tileTag = new NBTTagCompound();
        this.writeToNBT(tileTag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, tileTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
    }

    public int getItemAmount() {
        return this.fuelStack.stackSize;
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.field_145942_n : "container.oilLamp";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName()
    {
        return this.field_145942_n != null && this.field_145942_n.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public void func_145937_a(String p_145937_1_)
    {
        this.field_145942_n = p_145937_1_;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int p_70301_1_) {

        //return p_70301_1_ == 0 ? this.fuelStack : null;
        return this.fuelStack;
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
        this.fuelStack = p_70299_2_;
    }

    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    public boolean isItemValidForSlot(int slot, ItemStack itemstack)
    {
        //TODO oil for fuel
        return itemstack.getItem() == ItemInit.itemFishGuts;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }
}
