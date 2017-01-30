package com.killerjdog51.scorchstone;

import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.killerjdog51.scorchstone.Biomes.BiomeGenScorchedPlains;
import com.killerjdog51.scorchstone.Biomes.ScorchedstoneWorldGen;
import com.killerjdog51.scorchstone.init.ScorchstoneBlocks;
import com.killerjdog51.scorchstone.init.ScorchstoneItems;
import com.killerjdog51.scorchstone.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class Scorchstone_Mod {
	
	public static BiomeGenBase ScorchedPlains;

	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final ScorchstoneTab tabScorchstone = new ScorchstoneTab("tabScorchstone");
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ScorchstoneBlocks.init();
		ScorchstoneBlocks.register();
		ScorchstoneItems.init();
		ScorchstoneItems.register();
		
		//ScorchedPlains = new BiomeGenScorchedPlains(100).setColor(16711680).setBiomeName("Scorched Hell").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.registerRenders();
	    GameRegistry.registerWorldGenerator(new ScorchedstoneWorldGen(), 0);

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		ScorchstoneRecipes.init();
	}
}
