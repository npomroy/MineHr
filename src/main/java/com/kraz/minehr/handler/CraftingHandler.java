package com.kraz.minehr.handler;

import java.util.Random;

import com.kraz.minehr.MineHr;
import com.kraz.minehr.init.ItemInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {

    @SubscribeEvent
    public void onCrafting(ItemCraftedEvent event) {
        final IInventory craftMatrix = null;
        Random random = new Random();
        for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
            if(event.craftMatrix.getStackInSlot(i) != null) {
                ItemStack item0 = event.craftMatrix.getStackInSlot(i);
                if(item0 != null && item0.getItem() == MineHr.itemFilletKnife) {
                    ItemStack k = new ItemStack(MineHr.itemFilletKnife, 2, (item0.getItemDamage() + 1));
                    ItemStack f = new ItemStack(ItemInit.itemFishGuts, 2);


                    if(k.getItemDamage() >= k.getMaxDamage()){
                        k.stackSize--;
                    }

                    //TODO FIX (crafting not working when guts show up
                    event.craftMatrix.setInventorySlotContents(i,  k);

                    if(random.nextInt(10) >= 7) {
                        if(i >= 8) i = 1;
                        event.craftMatrix.setInventorySlotContents(i + 2, f);
                    }

                } else if(item0.getItem() == MineHr.itemMallet) {
                    ItemStack k = new ItemStack(MineHr.itemMallet, 2, (item0.getItemDamage() + 1));

                    if(k.getItemDamage() >= k.getMaxDamage()){
                        k.stackSize--;
                    }
                    event.craftMatrix.setInventorySlotContents(i,  k);
                } else if(item0.getItem() == MineHr.itemPliers) {
                    ItemStack k = new ItemStack(MineHr.itemPliers, 2, (item0.getItemDamage() + 1));

                    if(k.getItemDamage() >= k.getMaxDamage()){
                        k.stackSize--;
                    }
                    event.craftMatrix.setInventorySlotContents(i,  k);
                } else if(item0.getItem() == MineHr.itemHerbGrinder) {
                    ItemStack k = new ItemStack(MineHr.itemHerbGrinder, 2, (item0.getItemDamage()));


                    event.craftMatrix.setInventorySlotContents(i,  k);
                }
            }
        }
        //TODO enchanted crafting
        if(event.crafting.getItem() == MineHr.toolHorizonSword) {
            for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {

                ItemStack item0 = event.craftMatrix.getStackInSlot(5);
                if(item0 != null && item0.getItem() == Items.diamond) {
                    event.crafting.addEnchantment(Enchantment.unbreaking, 4);
                }
            }
        }
    }

}
