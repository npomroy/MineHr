package com.kraz.minehr.entity;

import com.kraz.minehr.MineHr;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityCrab extends EntityMob {

    public EntityCrab(World world) {
        super(world);

    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
        //TODO working?
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(0.10D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.00D);
    }

    protected Item getDropItem()
    {
        return MineHr.itemRawCrab;
    }

    protected void dropFewItems(boolean par1, int par2)
    {

        if (this.isBurning())
        {
            this.dropItem(MineHr.foodCookedCrabLegs, 1);
        }
        else
        {
            this.dropItem(MineHr.itemRawCrab, 1);
        }
    }

    protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 3.0D);
        return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity par1Entity, float par2)
    {
        if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 30;
            this.attackEntityAsMob(par1Entity);
        }
    }

    public boolean handleWaterMovement(){
        return false;
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel()
    {
        //TODO fix to not spawn at night? or during storms?
        return true;
//        int i = MathHelper.floor_double(this.posX);
//        int j = MathHelper.floor_double(this.boundingBox.minY);
//        int k = MathHelper.floor_double(this.posZ);
//
//        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand.nextInt(32))
//        {
//            return false;
//        }
//        else
//        {
//            int l = this.worldObj.getBlockLightValue(i, j, k);
//
//            if (this.worldObj.isThundering())
//            {
//                int i1 = this.worldObj.skylightSubtracted;
//                this.worldObj.skylightSubtracted = 10;
//                l = this.worldObj.getBlockLightValue(i, j, k);
//                this.worldObj.skylightSubtracted = i1;
//            }
//
//            return l <= this.rand.nextInt(8);
//        }
    }




    public boolean canBreatheUnderwater()
    {
        return true;
    }


}
