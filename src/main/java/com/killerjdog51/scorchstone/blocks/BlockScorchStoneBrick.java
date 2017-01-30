package com.killerjdog51.scorchstone.blocks;

import java.util.List;
import java.util.List;

import com.killerjdog51.scorchstone.Scorchstone_Mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockScorchStoneBrick extends Block
{
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockScorchStoneBrick.EnumType.class);
    public static final int DEFAULT_META = BlockScorchStoneBrick.EnumType.DEFAULT.getMetadata();
    public static final int CORRUPT_META = BlockScorchStoneBrick.EnumType.CORRUPT.getMetadata();
    public static final int CARVED_META = BlockScorchStoneBrick.EnumType.CARVED.getMetadata();
    public static final int CRACKED_META = BlockScorchStoneBrick.EnumType.CRACKED.getMetadata();
    
    private static final String __OBFID = "CL_00000318";

    public BlockScorchStoneBrick(Material materialIn)
    {
        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockScorchStoneBrick.EnumType.DEFAULT));
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(Scorchstone_Mod.tabScorchstone);
        this.setUnlocalizedName("scorched_brick");
        this.setStepSound(soundTypeStone);

    }

    /**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockScorchStoneBrick.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        BlockScorchStoneBrick.EnumType[] aenumtype = BlockScorchStoneBrick.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
            BlockScorchStoneBrick.EnumType enumtype = aenumtype[j];
            list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockScorchStoneBrick.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockScorchStoneBrick.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable
    {
        DEFAULT(0, "brick", "brick"),
        CORRUPT(1, "corrupt", "corrupt"),
        CARVED(2, "carved", "carved"),
        CRACKED(3, "cracked", "cracked");
        private static final BlockScorchStoneBrick.EnumType[] META_LOOKUP = new BlockScorchStoneBrick.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        private static final String __OBFID = "CL_00002057";

        private EnumType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

        public static BlockScorchStoneBrick.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            BlockScorchStoneBrick.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                BlockScorchStoneBrick.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}