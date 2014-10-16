package com.kraz.minehr.items;

import java.util.Iterator;
import java.util.List;

import com.kraz.minehr.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.kraz.minehr.MineHr;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class HempSpice extends ItemFood {

    private int potionId;
    private int potionId2;
    private int potionId3;
    private int potionDuration;
    private int potionDuration2;
    private int potionDuration3;
    private int potionAmplifier;
    private int potionAmplifier2;
    private int potionAmplifier3;
    private float potionEffectProbability;
    private float potionEffectProbability2;
    private float potionEffectProbability3;

    public HempSpice(int heal, float saturation, boolean isWolfMeat) {
        super(heal, saturation, isWolfMeat);

        this.setCreativeTab(MineHr.mineHrTab);

        //potionID, duration(*20), amplifier, prob
        this.setPotionEffect(10, 15, 0, 1.0F);
        this.setPotionEffect2(17, 25, 0, 1.0F);
        this.setPotionEffect3(3, 50, 0, 1.0F);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }

    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par2World.isRemote && this.potionId > 0 && par2World.rand.nextFloat() < this.potionEffectProbability)
        {
            par3EntityPlayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
            par3EntityPlayer.addPotionEffect(new PotionEffect(this.potionId2, this.potionDuration2 * 20, this.potionAmplifier2));
            par3EntityPlayer.addPotionEffect(new PotionEffect(this.potionId3, this.potionDuration3 * 20, this.potionAmplifier3));
        }
    }

    public ItemFood setPotionEffect(int par1, int par2, int par3, float par4)
    {
        this.potionId = par1;
        this.potionDuration = par2;
        this.potionAmplifier = par3;
        this.potionEffectProbability = par4;
        return this;
    }

    public ItemFood setPotionEffect2(int par1, int par2, int par3, float par4)
    {
        this.potionId2 = par1;
        this.potionDuration2 = par2;
        this.potionAmplifier2 = par3;
        this.potionEffectProbability2 = par4;
        return this;
    }

    public ItemFood setPotionEffect3(int par1, int par2, int par3, float par4)
    {
        this.potionId3 = par1;
        this.potionDuration3 = par2;
        this.potionAmplifier3 = par3;
        this.potionEffectProbability3 = par4;
        return this;
    }

}
