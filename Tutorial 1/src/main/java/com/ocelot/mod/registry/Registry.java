package com.ocelot.mod.registry;

import static com.ocelot.mod.init.RenderHandler.registerModel;

import com.ocelot.mod.init.ModItems;
import com.ocelot.mod.init.RenderHandler;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * <em><b>Copyright (c) 2018 The Starcraft Minecraft (SCMC) Mod Team.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Handles all the registry in the mod.
 * 
 * @author Ocelot5836
 */
public class Registry {

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.getItems());
	}

	@SubscribeEvent
	public void registerRenders(ModelRegistryEvent event) {
		RenderHandler.registerMetaItemRenders();
		for (int i = 0; i < ModItems.getItems().length; i++) {
			Item item = ModItems.getItems()[i];
			if (item != null && !item.getHasSubtypes()) {
				registerModel(item);
			}
		}
	}
}