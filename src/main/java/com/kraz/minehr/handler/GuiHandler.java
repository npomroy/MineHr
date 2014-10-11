package com.kraz.minehr.handler;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.container.ContainerWorkbench;
import com.kraz.minehr.gui.GuiWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {


        if(ID == MineHr.guiIDWorksurface) {
            return ID == MineHr.guiIDWorksurface && world.getBlock(x, y, z) == MineHr.blockWorkbench ? new ContainerWorkbench(player.inventory, world, x, y, z) : null;
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {


        if(ID == MineHr.guiIDWorksurface) {
            return ID == MineHr.guiIDWorksurface && world.getBlock(x, y, z) == MineHr.blockWorkbench ? new GuiWorkbench(player.inventory, world, x, y, z) : null;
        }

        return null;
    }

}
