package com.kraz.minehr.armor;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.reference.Reference;
import net.minecraft.entity.Entity;
        import net.minecraft.item.ItemArmor;
        import net.minecraft.item.ItemStack;
        import net.minecraft.item.ItemArmor.ArmorMaterial;

public class HorizonArmor extends ItemArmor {

    public HorizonArmor(ArmorMaterial material, int id,
                        int slot) {
        super(material, id, slot);
        this.setCreativeTab(MineHr.mineHrTab);

        if(slot == 0) {
            this.setTextureName(Reference.MOD_ID + ":HorizonHat");
        } else if(slot == 1) {
            this.setTextureName(Reference.MOD_ID + ":HorizonChest");
        } else if(slot == 2) {
            this.setTextureName(Reference.MOD_ID + ":HorizonLegs");
        } else if(slot == 3) {
            this.setTextureName(Reference.MOD_ID + ":HorizonBoots");
        }
    }

    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
        if(itemstack.getItem() == MineHr.armorHorizonHat || itemstack.getItem() == MineHr.armorHorizonChest || itemstack.getItem() == MineHr.armorHorizonBoots){
            return Reference.MOD_ID + ":textures/model/armor/horizon_layer_1.png";
        } else if(itemstack.getItem() == MineHr.armorHorizonLegs) {
            return Reference.MOD_ID + ":textures/model/armor/horizon_layer_2.png";
        } else {
            return null;
        }

    }

}