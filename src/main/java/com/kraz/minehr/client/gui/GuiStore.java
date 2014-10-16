package com.kraz.minehr.client.gui;

import com.kraz.minehr.container.ContainerStore;
import com.kraz.minehr.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiStore extends GuiContainer {

    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + Reference.guiStoreLocation);

    public GuiStore(InventoryPlayer invPlayer, World world, int x, int y, int z) {
        super(new ContainerStore(invPlayer, world, x, y, z));
        // TODO Auto-generated constructor stub

        this.xSize = 175;
        this.ySize = 160;

    }

    public void onGuiClosed() {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("For Sale"), 44, 10, 0000000);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Wanted"), 44, 40, 0000000);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Inventory"), 20, 68, 0000000);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }


}
