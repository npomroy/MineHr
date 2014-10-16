package com.kraz.minehr.blocks;

import com.kraz.minehr.reference.Reference;
import com.kraz.minehr.tileentity.TileEntityLobsterTrap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.kraz.minehr.MineHr;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LobsterTrap extends BlockContainer {

    public LobsterTrap(Material material) {
        super(material);

        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setBlockBounds(0.0F, 0F, 0.0F, 1.0F, 0.625F, 1.0F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(MineHr.mineHrTab);
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityLobsterTrap();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }

}
