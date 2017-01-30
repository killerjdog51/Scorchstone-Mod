package com.killerjdog51.scorchstone.blocks;

import com.killerjdog51.scorchstone.GameUtility;
import com.killerjdog51.scorchstone.Reference;
import com.killerjdog51.scorchstone.Scorchstone_Mod;
import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;
import com.killerjdog51.scorchstone.proxy.CommonProxy;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A slab or double slab of stained bricks of a certain color.
 * @author jrowlett
 *
 */
public abstract class BlockScorchStoneSlab extends BlockSlab {

	/**
     * The bit in metadata used by the half property.
     */
    private static final int HALF_META_BIT = 8;

    
    /**
     * The property used for the variant.
     * Needed for interactions with ItemSlab.
     */
    private static final PropertyBool VARIANT_PROPERTY =
        PropertyBool.create("variant");
    
	public BlockScorchStoneSlab(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
        if (!this.isDouble()) {
            setCreativeTab(Scorchstone_Mod.tabScorchstone);
        }
        this.useNeighborBrightness = !this.isDouble();
	
   
    IBlockState blockState = this.blockState.getBaseState();
    blockState = blockState.withProperty(VARIANT_PROPERTY, false);
    if (!this.isDouble()) {
        blockState = blockState.withProperty(HALF, EnumBlockHalf.BOTTOM);
    }

    setDefaultState(blockState);
    
    }
    
    public final String getId() {
        return this.innerGetId(this.isDouble());
    }
    /**
     * Gets the unlocalized name based on metadata/damage.
     * @param metadata block metadata.
     * @return the unlocalized name.
     */
    @Override
    public final String getUnlocalizedName(final int metadata) {
        return this.getUnlocalizedName();
    }

    /**
     * Gets the value of the variant property based on the item.
     * @param itemStack item stack.
     * @return the variant value null.
     */
    @Override
    public final Object getVariant(final ItemStack itemStack) {
        return false;
    }

    /**
     * Gets the variant property.
     * @return the variant property null.
     */
    @Override
    public final IProperty getVariantProperty() {
        return VARIANT_PROPERTY;
    }

    /**
     * Gets a block state from metadata.
     * @param meta the metadata or color value.
     * @return a block state with the meta encoded as the variant property.
     */
    @Override
    public final IBlockState getStateFromMeta(final int meta) {
        IBlockState blockState = this.getDefaultState();
        blockState = blockState.withProperty(VARIANT_PROPERTY, false);
        if (!this.isDouble()) {
            EnumBlockHalf value = EnumBlockHalf.BOTTOM;
            if ((meta & HALF_META_BIT) != 0) {
                value = EnumBlockHalf.TOP;
            }

            blockState = blockState.withProperty(HALF, value);
        }

        return blockState;
    }

    /**
     * Gets the metadata value from a block state.
     * @param state the block state.
     * @return the metadata or color value.
     */
    @Override
    public final int getMetaFromState(final IBlockState state) {
        if (this.isDouble()) {
           return 0;
        }

        if ((EnumBlockHalf) state.getValue(HALF) == EnumBlockHalf.TOP) {
            return HALF_META_BIT;
        } else {
            return 0;
        }
    }

    /**
     * Gets the damage for the block's item when dropped.
     * @param state the block's state.
     * @return the metadata or color value.
     */
    @Override
    public final int damageDropped(final IBlockState state) {
        return 0;
    }

    /**
     * Gets the item dropped when the block is broken.
     * @param blockState the block's state.
     * @param random the random number generator
     * @param unused an integer.
     * @return the half slab item.
     */
    @Override
    public final Item getItemDropped(
        final IBlockState blockState,
        final java.util.Random random,
        final int unused) {
        String blockId = this.innerGetId(false);
        return Item.getItemFromBlock(ScorchstoneBlocks.stoneSlab);
    }

    /**
     * Gets the item dropped when the block is broken.
     * @param world the world
     * @param blockPos the block position.
     * @return the item dropped, the half slab.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public final net.minecraft.item.Item getItem(
        final net.minecraft.world.World world,
        final net.minecraft.util.BlockPos blockPos) {
        String blockId = this.innerGetId(false);
        return Item.getItemFromBlock(ScorchstoneBlocks.stoneSlab);
    }

    /**
     * Creates the block state object.
     * @return the block state with properties defined.
     */
    @Override
    protected final BlockState createBlockState() {
        if (this.isDouble()) {
            return new BlockState(this, new IProperty[] {VARIANT_PROPERTY});
        } else {
            return new BlockState(
                this,
                new IProperty[] {VARIANT_PROPERTY, HALF});
        }
    }
    
    /**
     * Helper to register an item model for rendering.
     * @param item the item to register.
     * @param id the unique id of the item.
     * @param metadata the item metadata.
     */
    public static void registerInventoryModel(
        final Item item,
        final String id,
        final int metadata) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                item,
                metadata,
                new ModelResourceLocation(
                    Reference.MOD_ID + id,
                    "inventory"));
    }
    /**
     * Gets the ID of the block.
     * @param isDoubleStacked override the isDouble() method.
     * @return the unique block id.
     */
    private String innerGetId(final boolean isDoubleStacked) {
        String result = "";
        if (isDoubleStacked) {
            result = "double_";
        }

        return result + "scorchedstone_slab";
    }
}