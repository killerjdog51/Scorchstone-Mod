package com.killerjdog51.scorchstone.blocks;

import com.killerjdog51.scorchstone.Scorchstone_Mod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

/**
 * Stained brick stairs.
 *
 */
public class BlockScorchStoneStair extends BlockStairs {
    /**
     * Initializes a new instance of the BlockStainedBrickStairs class.
     * @param scorch_brick the stained bricks block.
      */
    public BlockScorchStoneStair(final Block scorch_stone) {
        super(scorch_stone.getStateFromMeta(0));
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(Scorchstone_Mod.tabScorchstone);
        this.setStepSound(soundTypePiston);	
        }
    }
