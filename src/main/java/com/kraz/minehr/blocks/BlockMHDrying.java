package com.kraz.minehr.blocks;

import static net.minecraftforge.common.EnumPlantType.Cave;
import static net.minecraftforge.common.EnumPlantType.Crop;
import static net.minecraftforge.common.EnumPlantType.Desert;
import static net.minecraftforge.common.EnumPlantType.Nether;
import static net.minecraftforge.common.EnumPlantType.Plains;
import static net.minecraftforge.common.EnumPlantType.Water;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.kraz.minehr.MineHr;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockMHDrying extends BlockBush implements IGrowable{
    private final Item parentItem;
    private static final String __OBFID = "CL_00000208";

    public BlockMHDrying(Item item)
    {
        super(Material.coral);
        this.parentItem = item;
        this.setTickRandomly(true);
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.1F, 0.9F);
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.iconArray = new IIcon[4];

        for(int i = 0; i < this.iconArray.length; i++) {
            this.iconArray[i] = iconRegister.registerIcon(MineHr.modid + ":" + this.getUnlocalizedName().substring(5) + (i + 1));
        }
    }

    public IIcon getIcon(int side, int metadata) {
        if (metadata < 7) {
            if (metadata == 6) {
                metadata = 5;
            }

            return this.iconArray[metadata >> 1];
        }

        return this.iconArray[3];
    }



    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return this.canBlockStay(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);

    }

    /**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return p_149854_1_ == MineHr.blockStage;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        this.checkAndDropBlock(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
    }

    /**
     * checks if the block can stay, if not drop as item
     */
    protected void checkAndDropBlock(World world, int x, int y, int z)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlock(x, y, z, getBlockById(0), 0, 2);
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_)
    {
        return  p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_) == MineHr.blockStage;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 0;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {


        return Plains;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return this;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }



    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return p_149650_1_ == 7 ? MineHr.foodCookedCodFillet : MineHr.itemCodFillet;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    public void func_149874_m(World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);

        if (l > 7)
        {
            l = 7;
        }

        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    //stillGrowing
    @Override
    public boolean func_149851_a(World world, int x, int y, int z,
                                 boolean var5) {
        // TODO Auto-generated method stub
        return world.getBlockMetadata(x, y, z) != 7;
    }

    //reactstoBonemeal
    @Override
    public boolean func_149852_a(World var1, Random var2, int var3, int var4,
                                 int var5) {
        // TODO Auto-generated method stub
        return false;
    }

    //increment growth
    @Override
    public void func_149853_b(World world, Random random, int x, int y, int z)
    {
        this.func_149874_m(world, x, y, z);
    }
}

