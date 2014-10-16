package com.kraz.minehr.client.gui;

import com.kraz.minehr.container.ContainerOilLamp;
import com.kraz.minehr.reference.Reference;
import com.kraz.minehr.tileentity.TileEntityOilLamp;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by Nick on 10/15/2014.
 */
public class GuiOilLamp extends GuiContainer {

    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + Reference.guiOilLampLocation);

    public GuiOilLamp(InventoryPlayer invPlayer, TileEntityOilLamp tileentityLamp) {
        super(new ContainerOilLamp(invPlayer, tileentityLamp));
        // TODO Auto-generated constructor stub

        this.xSize = 176;
        this.ySize = 178;
    }

    public void onGuiClosed() {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Oil Lamp"), 107, 12, 0000000);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Inventory"), 107, 84, 0000000);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }
}
