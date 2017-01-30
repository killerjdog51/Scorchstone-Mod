package com.killerjdog51.scorchstone;

import java.util.Random;

import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ScorchstoneRecipes {
	
	public static void init() {
		/**
		 * Crafting Recipes
		 */
		
		//Slabs
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.cobbleSlab, 6), new Object[]{
			"BBB", 'B', new ItemStack(ScorchstoneBlocks.scorch_cobble)
		});
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.stoneSlab, 6), new Object[]{
			"BBB", 'B', new ItemStack(ScorchstoneBlocks.scorch_stone)
		});
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.brickSlab, 6), new Object[]{
			"BBB", 'B', new ItemStack(ScorchstoneBlocks.scorch_brick)
		});
		
		//Stairs
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.cobbleStair, 4), new Object[]{
			"B  ", "BB ", "BBB", 'B', new ItemStack(ScorchstoneBlocks.scorch_cobble)
		});
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.stoneStair, 4), new Object[]{
			"B  ", "BB ", "BBB", 'B', new ItemStack(ScorchstoneBlocks.scorch_stone)
		});
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.brickStair, 4), new Object[]{
			"B  ", "BB ", "BBB", 'B', new ItemStack(ScorchstoneBlocks.scorch_brick)
		});
		
		//Brick
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.scorch_brick, 4, 0), new Object[]{
			"BB", "BB", 'B', new ItemStack(ScorchstoneBlocks.scorch_stone)
		});
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.scorch_brick, 1, 2), new Object[]{
			"B", "B", 'B', new ItemStack(ScorchstoneBlocks.brickSlab)
		});
		
		//Corrupt blocks
		
		GameRegistry.addShapelessRecipe(new ItemStack(ScorchstoneBlocks.scorch_cobble, 1, 1), new ItemStack(ScorchstoneBlocks.scorch_cobble, 0, 0), Items.nether_wart);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ScorchstoneBlocks.scorch_brick, 1, 1), new ItemStack(ScorchstoneBlocks.scorch_brick, 0, 0), Items.nether_wart);
		
		
		//Migma blocks
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.migma, 8, 1), new Object[]{
			"BBB", "BLB", "BBB", 'B', new ItemStack(ScorchstoneBlocks.scorch_brick, 0), 'L', new ItemStack(Items.lava_bucket)
		});
		GameRegistry.addRecipe(new ItemStack(ScorchstoneBlocks.migma, 8, 0), new Object[]{
			"BBB", "BLB", "BBB", 'B', new ItemStack(ScorchstoneBlocks.scorch_cobble, 0), 'L', new ItemStack(Items.lava_bucket)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(ScorchstoneBlocks.migma, 1, 0), new ItemStack(ScorchstoneBlocks.scorch_cobble, 0, 0), Items.magma_cream);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ScorchstoneBlocks.migma, 1, 1), new ItemStack(ScorchstoneBlocks.scorch_brick, 0, 0), Items.magma_cream);
		
		/**
		 * Furnace Recipes
		 */
		
		GameRegistry.addSmelting(new ItemStack(ScorchstoneBlocks.scorch_brick, 0), new ItemStack(ScorchstoneBlocks.scorch_brick, 1, 3), 2.0F);
		GameRegistry.addSmelting(new ItemStack(ScorchstoneBlocks.scorch_cobble, 0), new ItemStack(ScorchstoneBlocks.scorch_stone, 1), 2.0F);


	}
	
}
