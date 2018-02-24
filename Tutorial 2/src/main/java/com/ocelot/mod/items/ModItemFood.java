package com.ocelot.mod.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * A class that has the ability to create a food item that can be registered automatically as well as a custom food eating time.
 * 
 * @author Ocelot5836
 */
public class ModItemFood extends ModItem {

	/** Number of ticks to run while 'EnumAction'ing until result */
	private final int itemUseDuration;
	/** The amount this food item heals the player */
	private final int healAmount;
	/** The amount of saturation the item heals */
	private final float saturationModifier;
	/** Whether wolves like this food (true for raw and cooked porkchop) */
	private final boolean isWolfsFavoriteMeat;
	/** If this field is true, the food can be consumed even if the player don't need to eat */
	private boolean alwaysEdible;
	/** represents the potion effect that will occurr upon eating this food. Set by setPotionEffect */
	private PotionEffect potionId;
	/** probably of the set potion effect occurring */
	private float potionEffectProbability;

	/**
	 * Registers a food item with the specified registry name and unlocalized name.
	 * 
	 * @param registryName
	 *            The name that appears in game
	 * @param unlocalizedName
	 *            The name that is used for the lang file
	 * @param amount
	 *            The amount this item heals in half hunger bars
	 * @param saturation
	 *            The amount in half hunger bars this item has in saturation
	 * @param itemUseDuration
	 *            The amount of time it takes to eat this item
	 * @param isWolfFood
	 *            Whether or not this can be fed to a wolf
	 */
	public ModItemFood(String registryName, String unlocalizedName, int amount, float saturation, int itemUseDuration, boolean isWolfFood) {
		super(registryName, unlocalizedName);
		this.itemUseDuration = itemUseDuration;
		this.healAmount = amount;
		this.isWolfsFavoriteMeat = isWolfFood;
		this.saturationModifier = saturation;
	}

	/**
	 * Registers a food item with the specified name.
	 * 
	 * @param name
	 *            The registry and unlocalized names of the item
	 * @param amount
	 *            The amount this item heals in half hunger bars
	 * @param saturation
	 *            The amount in half hunger bars this item has in saturation
	 * @param itemUseDuration
	 *            The amount of time it takes to eat this item
	 * @param isWolfFood
	 *            Whether or not this can be fed to a wolf
	 */
	public ModItemFood(String name, int amount, float saturation, int itemUseDuration, boolean isWolfFood) {
		super(name);
		this.itemUseDuration = itemUseDuration;
		this.healAmount = amount;
		this.isWolfsFavoriteMeat = isWolfFood;
		this.saturationModifier = saturation;
	}

	/**
	 * Creates but does not registry a food item.
	 * 
	 * @param amount
	 *            The amount this item heals in half hunger bars
	 * @param saturation
	 *            The amount in half hunger bars this item has in saturation
	 * @param itemUseDuration
	 *            The amount of time it takes to eat this item
	 * @param isWolfFood
	 *            Whether or not this can be fed to a wolf
	 */
	public ModItemFood(int amount, float saturation, int itemUseDuration, boolean isWolfFood) {
		this.itemUseDuration = itemUseDuration;
		this.healAmount = amount;
		this.isWolfsFavoriteMeat = isWolfFood;
		this.saturationModifier = saturation;
	}

	/**
	 * Registers a food item with the specified registry name and unlocalized name.
	 * 
	 * @param registryName
	 *            The name that appears in game
	 * @param unlocalizedName
	 *            The name that is used for the lang file
	 * @param amount
	 *            The amount this item heals in half hunger bars
	 * @param saturation
	 *            The amount in half hunger bars this item has in saturation
	 * @param isWolfFood
	 *            Whether or not this can be fed to a wolf
	 */
	public ModItemFood(String registryName, String unlocalizedName, int amount, float saturation, boolean isWolfFood) {
		this(registryName, unlocalizedName, amount, saturation, 32, isWolfFood);
	}

	/**
	 * Registers a food item with the specified registry name and unlocalized name.
	 * 
	 * @param registryName
	 *            The name that appears in game
	 * @param unlocalizedName
	 *            The name that is used for the lang file
	 * @param amount
	 *            The amount this item heals in half hunger bars
	 * @param isWolfFood
	 *            Whether or not this can be fed to a wolf
	 */
	public ModItemFood(String registryName, String unlocalizedName, int amount, boolean isWolfFood) {
		this(registryName, unlocalizedName, amount, 0.6F, 32, isWolfFood);
	}

	/**
	 * Registers a food item with the specified name.
	 * 
	 * @param name
	 *            The registry and unlocalized names of the item
	 * @param amount
	 *            The amount this item heals in half hunger bars
	 * @param saturation
	 *            The amount in half hunger bars this item has in saturation
	 * @param isWolfFood
	 *            Whether or not this can be fed to a wolf
	 */
	public ModItemFood(String name, int amount, float saturation, boolean isWolfFood) {
		this(name, amount, saturation, 32, isWolfFood);
	}

	/**
	 * Registers a food item with the specified name.
	 * 
	 * @param name
	 *            The registry and unlocalized names of the item
	 * @param amount
	 *            The amount this item heals in half hunger bars
	 * @param isWolfFood
	 *            Whether or not this can be fed to a wolf
	 */
	public ModItemFood(String name, int amount, boolean isWolfFood) {
		this(name, amount, 0.6F, 32, isWolfFood);
	}

	/**
	 * Creates but does not registry a food item.
	 * 
	 * @param amount
	 *            The amount this item heals in half hunger bars
	 * @param saturation
	 *            The amount in half hunger bars this item has in saturation
	 * @param isWolfFood
	 *            Whether or not this can be fed to a wolf
	 */
	public ModItemFood(int amount, float saturation, boolean isWolfFood) {
		this(amount, saturation, 32, isWolfFood);
	}

	/**
	 * Creates but does not registry a food item.
	 * 
	 * @param amount
	 *            The amount this item heals in half hunger bars
	 * @param isWolfFood
	 *            Whether or not this can be fed to a wolf
	 */
	public ModItemFood(int amount, boolean isWolfFood) {
		this(amount, 0.6F, 32, isWolfFood);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			player.getFoodStats().addStats(getHealAmount(stack), getSaturationModifier(stack));
			world.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			this.onFoodEaten(stack, world, player);
			player.addStat(StatList.getObjectUseStats(this));

			if (player instanceof EntityPlayerMP) {
				CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP) player, stack);
			}
		}

		stack.shrink(1);
		return stack;
	}

	/**
	 * Called once this food is eaten. By default it applies the effect that will happen by chance.
	 * 
	 * @param stack
	 *            The stack the player is holding
	 * @param world
	 *            The world instance
	 * @param player
	 *            The player that ate the food
	 */
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote && this.potionId != null && world.rand.nextFloat() < this.potionEffectProbability) {
			player.addPotionEffect(new PotionEffect(this.potionId));
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return this.itemUseDuration;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.EAT;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);

		if (player.canEat(this.alwaysEdible)) {
			player.setActiveHand(hand);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
		} else {
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
		}
	}

	/**
	 * @param stack
	 *            The food stack
	 * @return The amount of food healing this stack has
	 */
	public int getHealAmount(ItemStack stack) {
		return this.healAmount;
	}

	/**
	 * @param stack
	 *            The food stack
	 * @return The amount of saturation this stack heals
	 */
	public float getSaturationModifier(ItemStack stack) {
		return this.saturationModifier;
	}

	/**
	 * Whether wolves like this food (true for raw and cooked porkchop).
	 */
	public boolean isWolfsFavoriteMeat() {
		return this.isWolfsFavoriteMeat;
	}

	/**
	 * Sets the effect that happens when this item is eaten.
	 * 
	 * @param effect
	 *            The effect being applied
	 * @param probability
	 *            The chance of this effect being applied
	 */
	public ModItemFood setPotionEffect(PotionEffect effect, float probability) {
		this.potionId = effect;
		this.potionEffectProbability = probability;
		return this;
	}

	/**
	 * Set the field 'alwaysEdible' to true, and make the food edible even if the player don't need to eat.
	 */
	public ModItemFood setAlwaysEdible() {
		this.alwaysEdible = true;
		return this;
	}
}