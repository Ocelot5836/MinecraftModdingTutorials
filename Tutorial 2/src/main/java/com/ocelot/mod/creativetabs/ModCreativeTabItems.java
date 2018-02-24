package com.ocelot.mod.creativetabs;

import com.ocelot.mod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * <em><b>Copyright (c) Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Used as the first testing for a modded creative tab in this series.
 * 
 * @author Ocelot5836
 */
public class ModCreativeTabItems extends CreativeTabs {

	public ModCreativeTabItems() {
		super("items");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.EMERALD_APPLE);
	}
}