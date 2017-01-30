package com.killerjdog51.scorchstone.Biomes;

import java.util.Random;

import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;

import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ScorchedstoneWorldGen implements IWorldGenerator {
	
	private WorldGenerator gen_scorchstone; //Generates Cobblestone (used in End)

	public ScorchedstoneWorldGen() {
	    this.gen_scorchstone = new WorldGenBlockScorchBlob(ScorchstoneBlocks.scorch_stone, 0);
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	    switch (world.provider.getDimensionId()) {
	    case 0: //Overworld

	        break;
	    case -1: //Nether
	        this.runGenerator(this.gen_scorchstone, world, random, chunkX, chunkZ, 2, 0, 100);

	        break;
	    case 1: //End

	        break;
	    }
	}
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(32);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(32);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
	
}
