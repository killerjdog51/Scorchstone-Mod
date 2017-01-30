package com.killerjdog51.scorchstone.blocks;

import java.lang.reflect.Field;
import java.util.List;
import java.util.List;

import com.killerjdog51.scorchstone.Scorchstone_Mod;
import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMigma extends Block
{
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockMigma.EnumType.class);
    public static final int COBBLE_META = BlockMigma.EnumType.COBBLE.getMetadata();
    public static final int BRICK_META = BlockMigma.EnumType.BRICK.getMetadata();
   
    
    private static final String __OBFID = "CL_00000318";

    public BlockMigma(Material materialIn)
    {
        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockMigma.EnumType.COBBLE));
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(Scorchstone_Mod.tabScorchstone);
        this.setUnlocalizedName("migma");
        this.setLightLevel(0.5F);
        this.setStepSound(soundTypeStone);
        }

    /**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockMigma.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        BlockMigma.EnumType[] aenumtype = BlockMigma.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
            BlockMigma.EnumType enumtype = aenumtype[j];
            list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockMigma.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockMigma.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable
    {
        COBBLE(0, "cobble", "cobble"),
        BRICK(1, "brick", "brick");
        private static final BlockMigma.EnumType[] META_LOOKUP = new BlockMigma.EnumType[values().length];
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

        public static BlockMigma.EnumType byMetadata(int meta)
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
            BlockMigma.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                BlockMigma.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
    public boolean isFullCube()
    {
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        float f = 0.0625F;
        float f1 = 1.0F;
        float f2 = 0.0011F;
        return new AxisAlignedBB((double)((float)pos.getX() + f1), (double)pos.getY(), (double)((float)pos.getZ() + f1), (double)((float)(pos.getX() + 1) - f1), (double)((float)(pos.getY() + 1) - f2), (double)((float)(pos.getZ() + 1) - f1));
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
    {
        float f = 0.0625F;
        float f1 = 1.0F;
        return new AxisAlignedBB((double)((float)pos.getX() + f1), (double)pos.getY(), (double)((float)pos.getZ() + f1), (double)((float)(pos.getX() + 1) - f1), (double)(pos.getY() + 1), (double)((float)(pos.getZ() + 1) - f1));
    }
    
    /**
     * Sets entity on fire if walked on
     */
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity){
    	
    	entity.setFire(5);
    	entity.attackEntityFrom(DamageSource.inFire, 1.0F);
    }
    
    /**
     * Crafting/Smelting
     */
    
    public void onCreated(ItemStack item, World world, EntityPlayer player){
    	 switch(world.provider.getDimensionId()){
	      case -1 : item.setItem(Item.getItemFromBlock(ScorchstoneBlocks.scorch_brick));
	      item.setItemDamage(3);
	      break;
	      default : item = new ItemStack(ScorchstoneBlocks.migma, 1, 1);
	      break;
	      }
    }
}