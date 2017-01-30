package com.killerjdog51.scorchstone.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

/**
 * Wrapper around ItemSlab to allow init from GameRegistry.
 * @author jrowlett
 *
 */
public class ItemBlockScorchStoneSlab extends ItemSlab {
    /**
     * Initializes a new instance of the ItemBlockStainedBrickSlab class.
     * @param block the block behind the item.
     * @param slab the half height slab.
     * @param doubleSlab the full height slab.
     * @param stacked whether or not the block is the stacked version.
     */
    public ItemBlockScorchStoneSlab(
        final Block block,
        final BlockHalfScorchStoneSlab slab,
        final BlockDoubleScorchStoneSlab doubleSlab,
        final Boolean stacked) {
        super(block, slab, doubleSlab);
    }
}