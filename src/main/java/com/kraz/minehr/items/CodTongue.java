package com.kraz.minehr.items;

import net.minecraft.item.ItemFood;

public class CodTongue extends ItemFood {

    public CodTongue(int heal, float saturation, boolean isWolfMeat) {
        super(heal, saturation, isWolfMeat);

        //potionID, duration(*20), amplifier, prob
        this.setPotionEffect(13, 30, 0, 1.0F);
    }

}
