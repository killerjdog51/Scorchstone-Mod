package com.killerjdog51.scorchstone.blocks;

import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import javax.annotation.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class itemMigmaBlock extends ItemBlock {

	public static final String[] field_94407_b = new String[]{"migma_cobble", "migma_brick"};


	public itemMigmaBlock(Block block) {
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

	/**
     * Crafting/Smelting
     */
	
	/**
    @Override 
    public void onCreated(ItemStack item, World world, EntityPlayer player){
   	 if (item =(Item.getItemFromBlock(ScorchstoneBlocks.scorch_brick)){
    	 switch(world.provider.getDimensionId()){
	      case -1 : item.setItem(Item.getItemFromBlock(ScorchstoneBlocks.scorch_brick));
	      item.setItemDamage(3);
	      break;
	      default : item = new ItemStack(ScorchstoneBlocks.migma, 1, 1);
	      break;
	      }}else{
	    	  switch(world.provider.getDimensionId()){
		      case -1 : item.setItem(Item.getItemFromBlock(ScorchstoneBlocks.scorch_stone));
		      break;
		      default : item = new ItemStack(ScorchstoneBlocks.migma, 1, 0);
		      break;
	      }
    }
}
    
    /**
	 * The NBT key used to indicate that the replacement logic has been run.
	 * <p>
	 * This is needed to ensure that items crafted in a dimension without a replacement don't get replaced as soon as the player enters a dimension with a replacement.
	 */
	private static final String KEY_REPLACED = "Replaced";

	/**
	 * The replacement {@link ItemStack} for each {@link DimensionType}.
	 */
//	private final Map<DimensionManager, ItemStack> replacements = new HashMap<>();

	

	/**
	 * Add a replacement for this item.
	 *
	 * @param dimensionType The dimension type
	 * @param itemStack     The replacement
	 */
	
	/**
	public void addReplacement(DimensionManager dimensionType, ItemStack itemStack) {
		replacements.put(dimensionType, itemStack);
	}

	/**
	 * Get the replacement for the specified {@link World}.
	 *
	 * @param world The World
	 * @return The replacement
	 */
	
	/**
	@Nullable
	private ItemStack getReplacement(World world) {
		return replacements.get(world.provider.getDimensionId());
	}

	@Override
	public void onUpdate(NBTTagCompound stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		final NBTTagCompound stackTagCompound = ItemStack.setTagCompound(stack);

		if (!stackTagCompound.getBoolean(KEY_REPLACED)) { // If the replacement logic hasn't been run,
			stackTagCompound.setBoolean(KEY_REPLACED, true); // Mark it as run

			final ItemStack replacement = getReplacement(worldIn); // Get the replacement for this dimension
			if (replacement != null) { // If it exists,
				final int stackSize = stack.stackSize; // Record the original stack size
				stack.deserializeNBT(replacement.serializeNBT()); // Replace this item
				stack.stackSize = stackSize; // Restore the original stack size
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		final ItemStack replacement = getReplacement(playerIn.getEntityWorld());

		if (replacement != null) {
			tooltip.add(I18n.translateToLocalFormatted("item.testmod3:dimensionReplacement.replacement.desc", replacement.getDisplayName()));
		} else {
			tooltip.add(I18n.translateToLocal("item.testmod3:dimensionReplacement.noReplacement.desc"));
		}
	}
	*/
}