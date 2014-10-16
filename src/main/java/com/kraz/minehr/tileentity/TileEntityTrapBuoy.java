package com.kraz.minehr.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.NetworkManager;

/**
 * Created by Nick on 10/15/2014.
 */
public class TileEntityTrapBuoy extends TileEntity{

    private int fishAmount;
    private int depth;

    public TileEntityTrapBuoy(){

    }

    @Override
    public void writeToNBT(NBTTagCompound par1)
    {
        super.writeToNBT(par1);
        par1.setInteger("fishAmount", fishAmount);
        par1.setInteger("depth", depth);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1)
    {
        super.readFromNBT(par1);
        this.fishAmount = par1.getInteger("fishAmount");
        this.depth = par1.getInteger("depth");
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

    public void setDepth(int newDepth) {
        depth = newDepth;
    }

    public int getDepth() {
        return depth;
    }

    public void setFishAmount(int amount) {
        fishAmount = amount;
    }

    public int getFishAmount() {
        return fishAmount;
    }

    public void incrementFishAmount() {
        fishAmount++;
    }
}
