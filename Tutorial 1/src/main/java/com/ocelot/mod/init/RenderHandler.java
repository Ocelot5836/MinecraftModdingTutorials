package com.ocelot.mod.init;

import com.ocelot.mod.registry.Registry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Handles all the rendering registry for the mod. Called from {@link Registry#registerRenders(net.minecraftforge.client.event.ModelRegistryEvent)}.
 * 
 * @author Ocelot5836
 */
public class RenderHandler {

	public static void registerMetaItemRenders() {

	}

	public static void registerMetaBlockRenders() {

	}

	/**
	 * Registers an item render.
	 * 
	 * @param item
	 *            The item to register the render for
	 */
	public static void registerModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	/**
	 * Registers a block render if the item is not null.
	 * 
	 * @param block
	 *            The block to register the render for
	 */
	public static void registerModel(Block block) {
		if (Item.getItemFromBlock(block) != null) {
			registerModel(Item.getItemFromBlock(block));
		}
	}
}