package com.ocelot.mod.init;

import java.util.ArrayList;
import java.util.List;

import com.ocelot.mod.items.ItemEmeraldApple;
import com.ocelot.mod.items.ModItem;

import net.minecraft.item.Item;

public class ModItems {

	private static List<Item> items;

	public static Item EMERALD_APPLE;

	private static void init() {
		items = new ArrayList<Item>();

		EMERALD_APPLE = new ItemEmeraldApple();
	}

	public static void register(Item item) {
		items.add(item);
	}

	public static Item[] getItems() {
		if (items == null)
			init();
		return items.toArray(new Item[items.size()]);
	}
}