package com.kraz.minehr.renderer;

import com.kraz.minehr.model.ModelLobsterTrap;
import com.kraz.minehr.reference.Reference;
import org.lwjgl.opengl.GL11;

import com.kraz.minehr.MineHr;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderLobsterTrap extends TileEntitySpecialRenderer {

    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/LobsterTrap.png");

    private ModelLobsterTrap model;

    public RenderLobsterTrap() {
        this.model = new ModelLobsterTrap();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);

        this.bindTexture(texture);

        GL11.glPushMatrix();
        this.model.renderModel(0.0625F);
        GL11.glPopMatrix();

        GL11.glPopMatrix();

    }

}
