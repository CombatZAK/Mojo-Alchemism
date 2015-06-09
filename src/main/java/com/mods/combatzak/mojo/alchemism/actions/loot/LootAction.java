package com.mods.combatzak.mojo.alchemism.actions.loot;

import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.MojoAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

public abstract class LootAction extends MojoAction {
	/**
	 * The type of loot chest where the item can be found
	 */
	protected String lootType;
	
	/**
	 * Item that will appear in the loot
	 */
	protected ItemStack loot;
	
	/**
	 * minimum stack size for the loot
	 */
	protected int min;
	
	/**
	 * maximum stack size for the loot
	 */
	protected int max;
	
	/**
	 * Relative likelihood for item to appear
	 */
	protected int weight;
	
	/**
	 * Gets the type of loot chest
	 * 
	 * @return chest ID
	 */
	public String getLootType() {
		return this.lootType;
	}
	
	/**
	 * Sets the type of loot chest
	 * 
	 * @param value chest ID
	 */
	public void setLootType(String value) {
		this.lootType = value;
	}
	
	/**
	 * Self-referentially sets the type of loot chest
	 * 
	 * @param value chest ID
	 * @return self-reference
	 */
	public LootAction withLootType(String value) {
		this.setLootType(value);
		return this;
	}
	
	/**
	 * Gets the item that could appear in the loot
	 * 
	 * @return item or oreDict entry
	 */
	public ItemStack getLoot() {
		return this.loot;
	}
	
	/**
	 * Sets the item that could appear in the loot
	 * 
	 * @param value item or oreDict entry
	 */
	public void setLoot(ItemStack value) {
		this.loot = value;
	}
	
	/**
	 * Self-referentially sets the item that could appear in the loot
	 * 
	 * @param value item or oredict entry
	 * @return self-reference
	 */
	public LootAction withLoot(ItemStack value) {
		this.setLoot(value);
		return this;
	}
	
	/**
	 * Gets the minimum stack size to appear in loot
	 * 
	 * @return min stack size
	 */
	public int getMin() {
		return this.min;
	}
	
	/**
	 * Sets the minimum stack size to appear in loot
	 * 
	 * @param value min stack size
	 */
	public void setMin(int value) {
		this.min = value;
	}
	
	/**
	 * Self-referentially sets the mininum stack size to appear in the loot
	 * 
	 * @param value min stack size
	 * @return self-reference
	 */
	public LootAction withMin(int value) {
		this.setMin(value);
		return this;
	}
	
	/**
	 * Gets the maximum stack size to appear in loot
	 * 
	 * @return max stack size
	 */
	public int getMax() {
		return this.max;
	}
	
	/**
	 * Sets the maximum stack size to appear in loot
	 * 
	 * @param value max stack size
	 */
	public void setMax(int value) {
		this.max = value;
	}
	
	/**
	 * Self-referentially sets the maximum stack size to appear in loot
	 * 
	 * @param value max stack size
	 * @return self-reference
	 */
	public LootAction withMax(int value) {
		this.setMax(value);
		return this;
	}
	
	/**
	 * Gets the relative chance to generate item in loot
	 * 
	 * @return weighted chance
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * Sets the relative chance to generate loot
	 * 
	 * @param value weighted chance
	 */
	public void setWeight(int value) {
		this.weight = value;
	}
	
	/**
	 * Self-referentially sets the relative chance to generate loot
	 * 
	 * @param value weighted chance
	 * @return self-reference
	 */
	public LootAction withWeight(int value) {
		this.setWeight(value);
		return this;
	}
	
	/**
	 * Creates a new LootAction instance
	 * 
	 * @param lootType chest ID
	 * @param loot item to appear in loot chest
	 * @param min minimum stack size
	 * @param max maximum stack size
	 * @param weight relative chance for loot to appear
	 */
	public LootAction(String lootType, ItemStack loot, int min, int max, int weight) {
		this.lootType = lootType;
		this.loot = loot;
		this.min = min;
		this.max = max;
		this.weight = weight;
	}
	
	/**
	 * Default constructor
	 */
	public LootAction() {
		this(null, null, 0, 0, 0);
	}
}
