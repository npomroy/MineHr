package com.kraz.minehr.renderer;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.entity.EntityCrab;
import com.kraz.minehr.model.ModelCrab;
import com.kraz.minehr.reference.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderCrab extends RenderLiving {

    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/Crab.png");

    protected ModelCrab modelEntity;

    public RenderCrab(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);

        modelEntity = ((ModelCrab) mainModel);
    }

    public void renderCrab(EntityCrab entity, double x, double y, double z, float u, float v) {
        super.doRender(entity, x, y, z, u, v);
    }

    public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
        renderCrab((EntityCrab)entityLiving, x, y, z, u, v);

    }

    public void doRender(Entity entity, double x, double y, double z, float u, float v) {
        renderCrab((EntityCrab)entity, x, y, z, u, v);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
        return texture;
    }

}
