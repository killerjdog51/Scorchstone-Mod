package com.killerjdog51.scorchstone;

import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;
import com.killerjdog51.scorchstone.init.ScorchstoneItems;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ScorchstoneTab extends CreativeTabs{

	public ScorchstoneTab(String label) {
		super(label);
		this.setBackgroundImageName("scorchstone.png");
	}

	
	public Item getTabIconItem() {
		ItemStack iStack = new ItemStack(ScorchstoneBlocks.scorch_stone);
		return iStack.getItem();
	}

}
