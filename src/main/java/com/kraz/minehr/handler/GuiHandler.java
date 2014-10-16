package com.kraz.minehr.handler;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.client.gui.GuiOilLamp;
import com.kraz.minehr.client.gui.GuiStore;
import com.kraz.minehr.container.ContainerOilLamp;
import com.kraz.minehr.container.ContainerStore;
import com.kraz.minehr.container.ContainerWorkbench;
import com.kraz.minehr.client.gui.GuiWorkbench;
import com.kraz.minehr.reference.Reference;
import com.kraz.minehr.tileentity.TileEntityOilLamp;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {


        if(ID == Reference.guiIDWorksurface) {
            return ID == Reference.guiIDWorksurface && world.getBlock(x, y, z) == MineHr.blockWorkbench ? new ContainerWorkbench(player.inventory, world, x, y, z) : null;
        }

        if(ID == Reference.guiIDStoreBlock) {
            return ID == Reference.guiIDStoreBlock && world.getBlock(x, y, z) == MineHr.blockStore ? new ContainerStore(player.inventory, world, x, y, z) : null;
        }

        if(ID == Reference.guiIDOilLamp) {
            TileEntityOilLamp tileentityLamp = (TileEntityOilLamp)world.getTileEntity(x, y, z);
            return ID == Reference.guiIDOilLamp && (world.getBlock(x, y, z) == MineHr.blockOilLampOff || world.getBlock(x, y, z) == MineHr.blockOilLampOn) ? new ContainerOilLamp(player.inventory, tileentityLamp) : null;
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {


        if(ID == Reference.guiIDWorksurface) {
            return ID == Reference.guiIDWorksurface && world.getBlock(x, y, z) == MineHr.blockWorkbench ? new GuiWorkbench(player.inventory, world, x, y, z) : null;
        }

        if(ID == Reference.guiIDStoreBlock) {
            return ID == Reference.guiIDStoreBlock && world.getBlock(x, y, z) == MineHr.blockStore ? new GuiStore(player.inventory, world, x, y, z) : null;
        }

        if(ID == Reference.guiIDOilLamp) {
            TileEntityOilLamp tileentityLamp = (TileEntityOilLamp)world.getTileEntity(x, y, z);
            return ID == Reference.guiIDOilLamp && (world.getBlock(x, y, z) == MineHr.blockOilLampOff || world.getBlock(x, y, z) == MineHr.blockOilLampOn) ? new GuiOilLamp(player.inventory, tileentityLamp) : null;
        }

        return null;
    }

}
