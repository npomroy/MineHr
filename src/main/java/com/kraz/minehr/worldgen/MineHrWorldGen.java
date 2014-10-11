package com.kraz.minehr.worldgen;


import com.kraz.minehr.MineHr;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

import java.util.Random;

public class MineHrWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId) {
            case 0 :
                //Generate our surface world
                generateSurface(world, random, chunkX*16, chunkZ*16);
            case -1 :
                //Generate our nether
                generateNether(world, random, chunkX*16, chunkZ*16);
            case 1 :
                //Generate our end world
                generateEnd(world, random, chunkX*16, chunkZ*16);
        }
    }

    private void generateEnd(World world, Random random, int x, int z) {

    }

    private void generateNether(World world, Random random, int x, int z) {

        this.addNetherOreSpawn(MineHr.oreKraziteOre, world, random, x, z, 16, 16, 2+random.nextInt(4), 10, 12, 44);
        this.addNetherOreSpawn(MineHr.oreZarkiteOre, world, random, x, z, 16, 16, 2+random.nextInt(4), 10, 12, 44);

    }

    private void generateSurface(World world, Random random, int x, int z) {
        //this.addOreSpawn(MineHarbour.oreMyOre, world, random, x = blockXpos, z = blockZpos, maxX, maxZ, maxVienSize, chanceToSpawn, minY, maxY
        this.addOreSpawn(MineHr.oreCopperOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 15, 40, 100);
        this.addOreSpawn(MineHr.oreTinOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 15, 35, 70);
        this.addOreSpawn(MineHr.oreNickelOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 10, 30, 58);
        this.addOreSpawn(MineHr.oreLeadOre, world, random, x, z, 16, 16, 1+random.nextInt(8), 5, 10, 40);
        this.addOreSpawn(MineHr.oreAluminumOre, world, random, x, z, 16, 16, 4+random.nextInt(8), 20, 38, 100);
        this.addOreSpawn(MineHr.oreChromiteOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 5, 20, 50);
        this.addOreSpawn(MineHr.oreMagnesiumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 3, 10, 30);
        this.addOreSpawn(MineHr.oreTitaniumOre, world, random, x, z, 16, 16, 2+random.nextInt(4), 4, 5, 12);
        this.addOreSpawn(MineHr.oreZincOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 12, 24);
        //TODO kelp


    }

    private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
        for(int i = 0; i < chanceToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }

    private void addNetherOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
        for(int i = 0; i < chanceToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenNetherMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }

}
