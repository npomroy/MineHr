package com.kraz.minehr.handler;

import java.util.Random;

import com.kraz.minehr.MineHr;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {

    public static void registerMonsters(Class entityClass, String name) {
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        long x = name.hashCode();
        Random random = new Random(x);
        int mainColor = random.nextInt() * 16777215;
        int subColor = random.nextInt() * 16777215;

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
        EntityRegistry.registerModEntity(entityClass, name, entityId, MineHr.instance, 64, 1, true);
        EntityRegistry.addSpawn(entityClass, 100, 2, 4, EnumCreatureType.ambient, BiomeGenBase.beach, BiomeGenBase.deepOcean, BiomeGenBase.frozenOcean, BiomeGenBase.ocean, BiomeGenBase.forest, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.savanna, BiomeGenBase.coldBeach);
        EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
    }

}
