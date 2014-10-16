package com.kraz.minehr.blocks;

import com.kraz.minehr.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.kraz.minehr.MineHr;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class Workbench extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon workbenchTop;

    public Workbench() {
        super(Material.wood);

        this.setHardness(3.5F);
        this.setResistance(5.0F);
        this.setCreativeTab(MineHr.mineHrTab);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return side == 1 ? this.workbenchTop : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons (IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "WorkbenchSide");
        this.workbenchTop = iconRegister.registerIcon(Reference.MOD_ID + ":" + "WorkbenchTop");
    }

    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
        if (!player.isSneaking()){
            player.openGui(MineHr.instance, Reference.guiIDWorksurface, world, x, y, z);
            return true;
        } else {
            return false;
        }
    }

}
