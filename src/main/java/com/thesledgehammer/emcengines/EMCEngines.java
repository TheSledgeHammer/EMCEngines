/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.emcengines;

import com.thesledgehammer.emcengines.compat.TOPCompat;
import com.thesledgehammer.groovymc.api.GroovyLoader;
import com.thesledgehammer.groovymc.config.Constants;
import com.thesledgehammer.groovymc.utils.ObjectManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
		modid = EMCEngines.MOD_ID,
		name = EMCEngines.MOD_NAME,
		version = EMCEngines.VERSION,
		acceptedMinecraftVersions = EMCEngines.MCVERSION,
		dependencies = "required-after:groovymc;required-after:projecte;"
)
public class EMCEngines {

	public static final String MOD_ID = "com/thesledgehammer";
	public static final String MOD_NAME = "EMCEngines";
	public static final String VERSION = "1.0.0";
	public static final String MCVERSION = "1.12.2";
	//public static final String UPDATE_JSON = "@UPDATE@";

	protected static GroovyLoader groovyLoader = new GroovyLoader(Constants.getMOD_PATH(), Constants.getRESOURCE_PATH(), "java", Constants.getURL(), MOD_ID);

	@Mod.Instance("com/thesledgehammer")
	public static  EMCEngines instance;

	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		//proxy.preInit(event);
		ModBlocks.init();
		if(Loader.isModLoaded("theoneprobe")) {
			TOPCompat.registerProviders();
		}
		//EngineModels.fmlPreInit();
		ModBlocks.initModels();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		//proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		//proxy.postInit(event);
	}


	public static void registerItem(Item item) {
		ObjectManager.registerItemClient(item);
	}

	public static void registerBlock(Block block) {
		ObjectManager.registerBlockClient(block);
	}
}
