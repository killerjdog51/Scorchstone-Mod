package com.killerjdog51.scorchstone.blocks;

import com.killerjdog51.scorchstone.Scorchstone_Mod;

import net.minecraft.block.material.Material;

/**
 * Regular slab of stained bricks.
 *
 */
public class BlockHalfScorchCobbleSlab extends BlockScorchCobbleSlab {
    public BlockHalfScorchCobbleSlab(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 2);
        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(Scorchstone_Mod.tabScorchstone);
        this.setUnlocalizedName("scorchstoneCobbleSlab");
        this.setStepSound(soundTypePiston);		}

	/**
     * Gets whether or not this is double height.
     * @return always false.
     */
    @Override
    public final boolean isDouble() {
        return false;
    }
}