package com.killerjdog51.scorchstone.Biomes;

import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;

import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;

public class BiomeGenScorchedPlains extends BiomeGenBase
{
    private static final String __OBFID = "CL_00000173";
    private static final WorldGenBlockScorchBlob field_150643_aG = new WorldGenBlockScorchBlob(ScorchstoneBlocks.scorch_stone, 8);

    public BiomeGenScorchedPlains(int p_i1981_1_)
    {
        super(p_i1981_1_);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityGhast.class, 50, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityMagmaCube.class, 1, 4, 4));
        System.out.println("Scorchstone Biome Spanws");
    }
}