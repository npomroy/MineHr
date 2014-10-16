package com.kraz.minehr.armor;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class RubberArmor extends ItemArmor {

    public RubberArmor(ArmorMaterial material, int id,
                       int slot) {
        super(material, id, slot);
        this.setCreativeTab(MineHr.mineHrTab);

        if(slot == 0) {
            this.setTextureName(Reference.MOD_ID + ":RubberHat");
        } else if(slot == 1) {
            this.setTextureName(Reference.MOD_ID + ":RubberChest");
        } else if(slot == 2) {
            this.setTextureName(Reference.MOD_ID + ":RubberLegs");
        } else if(slot == 3) {
            this.setTextureName(Reference.MOD_ID + ":RubberBoots");
        }
    }

    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
        if(itemstack.getItem() == MineHr.armorRubberHat || itemstack.getItem() == MineHr.armorRubberChest || itemstack.getItem() == MineHr.armorRubberBoots){
            return Reference.MOD_ID + ":textures/model/armor/rubber_layer_1.png";
        } else if(itemstack.getItem() == MineHr.armorRubberLegs) {
            return Reference.MOD_ID + ":textures/model/armor/rubber_layer_2.png";
        } else {
            return null;
        }

    }

}