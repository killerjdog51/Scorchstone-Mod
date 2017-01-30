package com.killerjdog51.scorchstone.proxy;

import net.minecraft.item.Item;

public abstract class CommonProxy {

	public void registerRenders() {
		
	}
	
	public abstract void registerInventoryModel(
	        final Item item,
	        final String id,
	        final int metadata);

	    /**
	     * Helper to add a model variant in the ModelBakery.
	     * @param item the main item.
	     * @param variantName the variant name.
	     */
	    public abstract void addModelBakeryVariant(
	        final Item item,
	        final String variantName);
}
