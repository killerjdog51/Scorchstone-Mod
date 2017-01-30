package com.killerjdog51.scorchstone.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class itemScorchBrick extends ItemBlock {

	public static final String[] field_94407_b = new String[]{"scorched_brick", "scorched_brick_corrupt", "scorched_brick_carved", "scorched_brick_cracked"};


	public itemScorchBrick(Block block) {
		super(block);
		this.setHasSubtypes(true);

	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= field_94407_b.length) {
			i = 0;
		}
		return super.getUnlocalizedName() + "." + field_94407_b[i];
	}

	public int getMetadata(int meta) {
		return meta;
	}

}