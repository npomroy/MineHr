package com.kraz.minehr.items;
import com.kraz.minehr.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.kraz.minehr.MineHr;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

//@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class MHItems extends Item {

    public MHItems() {
        super();
        this.setCreativeTab(MineHr.mineHrTab);
        //this.setUnlocalizedName("MineHr");
    }

    public MHItems(String name) {
        super();
        this.setCreativeTab(MineHr.mineHrTab);
        this.setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }





}
