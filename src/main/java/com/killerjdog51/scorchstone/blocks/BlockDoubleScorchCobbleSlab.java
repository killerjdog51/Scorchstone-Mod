package com.killerjdog51.scorchstone.blocks;

import com.killerjdog51.scorchstone.Scorchstone_Mod;

import net.minecraft.block.material.Material;

/**
 * Double slab of stained bricks.
 *
 */
public class BlockDoubleScorchCobbleSlab extends BlockScorchCobbleSlab {
    public BlockDoubleScorchCobbleSlab(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 2);
        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setUnlocalizedName("scorchstoneCobbleSlab");
        this.setStepSound(soundTypePiston);		}

	/**
     * Gets whether or not this is a double stacked slab.
     * @return always true.
     */
    @Override
    public final boolean isDouble() {
        return true;
    }
}
