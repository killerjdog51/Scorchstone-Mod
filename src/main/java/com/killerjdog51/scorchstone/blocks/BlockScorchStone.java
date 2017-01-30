package com.killerjdog51.scorchstone.blocks;

import java.util.Random;

import com.killerjdog51.scorchstone.Scorchstone_Mod;
import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockScorchStone extends Block{

	public BlockScorchStone(Material materialIn) {
		super(materialIn);
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(Scorchstone_Mod.tabScorchstone);
        this.setUnlocalizedName("scorched_stone");
        this.setStepSound(soundTypeStone);

	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ScorchstoneBlocks.scorch_cobble);
    }

}
