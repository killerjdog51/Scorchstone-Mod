package com.killerjdog51.scorchstone.init;

import com.killerjdog51.scorchstone.Reference;
import com.killerjdog51.scorchstone.Scorchstone_Mod;
import com.killerjdog51.scorchstone.blocks.BlockDoubleScorchBrickSlab;
import com.killerjdog51.scorchstone.blocks.BlockDoubleScorchCobbleSlab;
import com.killerjdog51.scorchstone.blocks.BlockDoubleScorchStoneSlab;
import com.killerjdog51.scorchstone.blocks.BlockHalfScorchBrickSlab;
import com.killerjdog51.scorchstone.blocks.BlockHalfScorchCobbleSlab;
import com.killerjdog51.scorchstone.blocks.BlockHalfScorchStoneSlab;
import com.killerjdog51.scorchstone.blocks.BlockMigma;
import com.killerjdog51.scorchstone.blocks.BlockScorchStone;
import com.killerjdog51.scorchstone.blocks.BlockScorchStoneBrick;
import com.killerjdog51.scorchstone.blocks.BlockScorchStoneCobble;
import com.killerjdog51.scorchstone.blocks.BlockScorchStoneSlab;
import com.killerjdog51.scorchstone.blocks.BlockScorchStoneStair;
import com.killerjdog51.scorchstone.blocks.ItemScorchBrickSlab;
import com.killerjdog51.scorchstone.blocks.ItemScorchCobbleSlab;
import com.killerjdog51.scorchstone.blocks.ItemScorchStoneSlab;
import com.killerjdog51.scorchstone.blocks.itemMigmaBlock;
import com.killerjdog51.scorchstone.blocks.itemScorchBrick;
import com.killerjdog51.scorchstone.blocks.itemScorchCobble;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ScorchstoneBlocks {
	
	public static Block scorch_stone;
	public static Block scorch_cobble;
	public static Block scorch_brick;
	public static Block stoneSlab;
	public static Block stoneDoubleSlab;
	public static Block cobbleSlab;
	public static Block cobbleDoubleSlab;
	public static Block brickSlab;
	public static Block brickDoubleSlab;
	public static Block stoneStair;
	public static Block cobbleStair;
	public static Block brickStair;
	public static Block migma;
		
	public static void init() {
		scorch_stone = new BlockScorchStone(Material.rock);
		scorch_cobble = new BlockScorchStoneCobble(Material.rock);
		scorch_brick = new BlockScorchStoneBrick(Material.rock);

		stoneSlab = new BlockHalfScorchStoneSlab(Material.rock);
		stoneDoubleSlab = new BlockDoubleScorchStoneSlab(Material.rock);

		cobbleSlab = new BlockHalfScorchCobbleSlab(Material.rock);
		cobbleDoubleSlab = new BlockDoubleScorchCobbleSlab(Material.rock);

		brickSlab = new BlockHalfScorchBrickSlab(Material.rock);
		brickDoubleSlab = new BlockDoubleScorchBrickSlab(Material.rock);

		stoneStair = new BlockScorchStoneStair(scorch_stone).setUnlocalizedName("scorchstone_Stairs");
		cobbleStair = new BlockScorchStoneStair(scorch_cobble).setUnlocalizedName("scorchstone_Cobble_Stairs");
		brickStair = new BlockScorchStoneStair(scorch_brick).setUnlocalizedName("scorchstone_Brick_Stairs");
		
		migma = new BlockMigma(Material.rock);
	}
	
	public static void register() {
		GameRegistry.registerBlock(scorch_stone, scorch_stone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(scorch_cobble, itemScorchCobble.class, scorch_cobble.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(scorch_brick, itemScorchBrick.class, scorch_brick.getUnlocalizedName().substring(5));

		 GameRegistry.registerBlock(stoneSlab, ItemScorchStoneSlab.class, "scorchstone_slab",stoneSlab,stoneDoubleSlab, false);
		 GameRegistry.registerBlock(stoneDoubleSlab, ItemScorchStoneSlab.class, "scorchstone_double_slab",stoneSlab,stoneDoubleSlab, true);

		 GameRegistry.registerBlock(cobbleSlab, ItemScorchCobbleSlab.class, "scorchstone_cobble_slab",cobbleSlab,cobbleDoubleSlab, false);
		 GameRegistry.registerBlock(cobbleDoubleSlab, ItemScorchCobbleSlab.class, "scorchstone_double_cobble_slab",cobbleSlab,cobbleDoubleSlab, true);

		 GameRegistry.registerBlock(brickSlab, ItemScorchBrickSlab.class, "scorchstone_brick_slab",brickSlab,brickDoubleSlab, false);
		 GameRegistry.registerBlock(brickDoubleSlab, ItemScorchBrickSlab.class, "scorchstone_double_brick_slab",brickSlab,brickDoubleSlab, true);

		 GameRegistry.registerBlock(stoneStair, "scorched_stone_stairs");
		 GameRegistry.registerBlock(cobbleStair, "scorched_cobble_stairs");
		 GameRegistry.registerBlock(brickStair, "scorched_brick_stairs");
		 
		 GameRegistry.registerBlock(migma, itemMigmaBlock.class, "migma");

	}
	
	public static void registerRenders() {
		
		Item itemScorchedStone = Item.getItemFromBlock(scorch_stone);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedStone, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + itemScorchedStone.getUnlocalizedName().substring(5), "inventory"));
		
		Item itemScorchedCobble = GameRegistry.findItem("ssm", "scorched_cobble");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedCobble, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "scorched_cobble", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedCobble, 1, new ModelResourceLocation(Reference.MOD_ID + ":" + "scorched_cobble_corrupt", "inventory"));
		ModelBakery.addVariantName(itemScorchedCobble, new String[]{"ssm:scorched_cobble", "ssm:scorched_cobble_corrupt"});

		Item itemScorchedBrick = GameRegistry.findItem("ssm", "scorched_brick");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedBrick, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "scorched_brick", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedBrick, 1, new ModelResourceLocation(Reference.MOD_ID + ":" + "scorched_brick_corrupt", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedBrick, 2, new ModelResourceLocation(Reference.MOD_ID + ":" + "scorched_brick_carved", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedBrick, 3, new ModelResourceLocation(Reference.MOD_ID + ":" + "scorched_brick_cracked", "inventory"));
		ModelBakery.addVariantName(itemScorchedCobble, new String[]{"ssm:scorched_brick", "ssm:scorched_brick_corrupt", "ssm:scorched_brick_carved", "ssm:scorched_brick_cracked"});

		Item itemScorchedSlab = GameRegistry.findItem("ssm", "scorchstone_slab");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedSlab, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "half_slab_scorch_stone", "inventory"));
		ModelBakery.addVariantName(itemScorchedSlab, new String[]{"ssm:half_slab_scorch_stone", "ssm:scorched_stone_slab"});

		Item itemScorchedCobbleSlab = GameRegistry.findItem("ssm", "scorchstone_cobble_slab");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedCobbleSlab, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "half_slab_scorch_cobble", "inventory"));
		ModelBakery.addVariantName(itemScorchedCobbleSlab, new String[]{"ssm:half_slab_scorch_cobble", "ssm:scorched_cobble_slab"});

		Item itemScorchedBrickSlab = GameRegistry.findItem("ssm", "scorchstone_brick_slab");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedBrickSlab, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "half_slab_scorch_brick", "inventory"));
		ModelBakery.addVariantName(itemScorchedBrickSlab, new String[]{"ssm:half_slab_scorch_brick", "ssm:scorched_brick_slab"});

		Item itemScorchedStoneStair = GameRegistry.findItem("ssm", "scorched_stone_stairs");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedStoneStair, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "scorched_stone_stairs", "inventory"));
        
        Item itemScorchedCobbleStair = GameRegistry.findItem("ssm", "scorched_cobble_stairs");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedCobbleStair, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "scorched_cobble_stairs", "inventory"));
        
        Item itemScorchedBrickStair = GameRegistry.findItem("ssm", "scorched_brick_stairs");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemScorchedBrickStair, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "scorched_brick_stairs", "inventory"));
        
        Item itemMigma = GameRegistry.findItem("ssm", "migma");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemMigma, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "migma_cobble", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemMigma, 1, new ModelResourceLocation(Reference.MOD_ID + ":" + "migma_brick", "inventory"));
		ModelBakery.addVariantName(itemMigma, new String[]{"ssm:migma_cobble", "ssm:migma_brick"});

	}
	
}
