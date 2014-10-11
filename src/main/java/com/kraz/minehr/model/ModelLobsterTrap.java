// Java generated by Techne

package com.kraz.minehr.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLobsterTrap extends ModelBase
{
    //fields
    ModelRenderer Post1;
    ModelRenderer Post2;
    ModelRenderer Post3;
    ModelRenderer Post4;
    ModelRenderer Top;
    ModelRenderer Bottom;

    public ModelLobsterTrap()
    {
        textureWidth = 128;
        textureHeight = 32;

        Post1 = new ModelRenderer(this, 0, 0);
        Post1.addBox(0F, 0F, 0F, 2, 10, 2);
        Post1.setRotationPoint(-7F, 12F, -7F);
        Post1.setTextureSize(128, 32);
        Post1.mirror = true;
        setRotation(Post1, 0F, 0F, 0F);
        Post2 = new ModelRenderer(this, 74, 0);
        Post2.addBox(0F, 0F, 0F, 2, 10, 2);
        Post2.setRotationPoint(21F, 12F, -7F);
        Post2.setTextureSize(128, 32);
        Post2.mirror = true;
        setRotation(Post2, 0F, 0F, 0F);
        Post3 = new ModelRenderer(this, 0, 16);
        Post3.addBox(0F, 0F, 0F, 2, 10, 2);
        Post3.setRotationPoint(21F, 12F, 5F);
        Post3.setTextureSize(128, 32);
        Post3.mirror = true;
        setRotation(Post3, 0F, 0F, 0F);
        Post4 = new ModelRenderer(this, 74, 16);
        Post4.addBox(0F, 0F, 0F, 2, 10, 2);
        Post4.setRotationPoint(-7F, 12F, 5F);
        Post4.setTextureSize(128, 32);
        Post4.mirror = true;
        setRotation(Post4, 0F, 0F, 0F);
        Top = new ModelRenderer(this, 0, 0);
        Top.addBox(0F, 0F, 0F, 30, 2, 14);
        Top.setRotationPoint(-7F, 10F, -7F);
        Top.setTextureSize(128, 32);
        Top.mirror = true;
        setRotation(Top, 0F, 0F, 0F);
        Bottom = new ModelRenderer(this, 0, 16);
        Bottom.addBox(0F, 0F, 0F, 30, 2, 14);
        Bottom.setRotationPoint(-7F, 22F, -7F);
        Bottom.setTextureSize(128, 32);
        Bottom.mirror = true;
        setRotation(Bottom, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Post1.render(f5);
        Post2.render(f5);
        Post3.render(f5);
        Post4.render(f5);
        Top.render(f5);
        Bottom.render(f5);
    }

    public void renderModel(float f5) {
        Post1.render(f5);
        Post2.render(f5);
        Post3.render(f5);
        Post4.render(f5);
        Top.render(f5);
        Bottom.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}
