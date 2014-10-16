package com.kraz.minehr.proxy;

import com.kraz.minehr.client.settings.Keybindings;
import com.kraz.minehr.entity.EntityCrab;
import com.kraz.minehr.model.ModelCrab;
import com.kraz.minehr.renderer.*;
import com.kraz.minehr.tileentity.TileEntityLobsterTrap;
import com.kraz.minehr.tileentity.TileEntityOilLamp;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import com.kraz.minehr.MineHr;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    public void registerRenderThings() {
        //Lobster Trap
        TileEntitySpecialRenderer render = new RenderLobsterTrap();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLobsterTrap.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MineHr.blockLobsterTrap), new ItemRenderLobsterTrap(render, new TileEntityLobsterTrap()));

        //OilLamp
        TileEntitySpecialRenderer render1 = new RenderOilLamp();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOilLamp.class, render1);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MineHr.blockOilLampOff), new ItemRenderOilLamp(render1, new TileEntityOilLamp()));

        //Entities
        RenderingRegistry.registerEntityRenderingHandler(EntityCrab.class, new RenderCrab(new ModelCrab(), 0.3F));
    }

    public void registerTileEntitySpecialRenderer(){

    }

    @Override
    public void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(Keybindings.light);
    }
}
