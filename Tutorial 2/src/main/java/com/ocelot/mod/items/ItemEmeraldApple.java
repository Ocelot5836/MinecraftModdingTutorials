package com.ocelot.mod.items;

import com.ocelot.mod.creativetabs.ModCreativeTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * The first item added. A very basic item that was added to show custom items.
 * 
 * @author Ocelot5836
 */
public class ItemEmeraldApple extends ModItemFood {

	public ItemEmeraldApple() {
		super("emerald_apple", "appleEmerald", 8, 6.5f, true);
		setAlwaysEdible();
		setCreativeTab(ModCreativeTabs.ITEMS);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 60 * 20, 2));
			player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 120 * 20, 4));
		}
	}
}