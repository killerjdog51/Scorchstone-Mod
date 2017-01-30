package com.killerjdog51.scorchstone.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLLog;

import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;
import com.killerjdog51.scorchstone.init.ScorchstoneItems;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenders() {
		ScorchstoneItems.registerRenders();
		ScorchstoneBlocks.registerRenders();
		
		
	}

	 @Override
	    public final void registerInventoryModel(
	        final Item item,
	        final String id,
	        final int metadata) {
	        FMLLog.fine(
	            "Registering inventory for item %s and metadata %d",
	            id,
	            metadata);
	        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
	                item,
	                metadata,
	                new ModelResourceLocation(
	                    "ssm:" + id,
	                    "inventory"));
	    }

	    /**
	     * Helper to add a model variant in the ModelBakery.
	     * @param item the main item.
	     * @param variantName the variant name.
	     */
	    @Override
	    public final void addModelBakeryVariant(
	        final Item item,
	        final String variantName) {
	        FMLLog.fine(
	                "Registering variant %s for item %s.",
	                variantName,
	                item.getUnlocalizedName());
	        ModelBakery.addVariantName(
	                item,
	                variantName);
	    }

}
