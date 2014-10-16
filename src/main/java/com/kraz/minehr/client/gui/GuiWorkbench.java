package com.kraz.minehr.client.gui;

import com.kraz.minehr.container.ContainerWorkbench;
import com.kraz.minehr.reference.Reference;
import org.lwjgl.opengl.GL11;

import com.kraz.minehr.MineHr;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiWorkbench extends GuiContainer {

    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + Reference.guiWorkbenchLocation);

    public GuiWorkbench(InventoryPlayer invPlayer, World world, int x, int y, int z) {
        super(new ContainerWorkbench(invPlayer, world, x, y, z));
        // TODO Auto-generated constructor stub

        this.xSize = 176;
        this.ySize = 178;
    }

    public void onGuiClosed() {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Workbench"), 107, 12, 0000000);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Inventory"), 107, 84, 0000000);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }

}
