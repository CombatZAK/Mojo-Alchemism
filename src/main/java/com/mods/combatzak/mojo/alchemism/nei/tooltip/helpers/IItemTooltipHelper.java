package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers;

import java.util.List;

import net.minecraft.item.ItemStack;

public interface IItemTooltipHelper {
	/**
	 * Gets the tooltip to apply to the item
	 * 
	 * @return tooltips to add to item
	 */
	public List<String> getTooltip(ItemStack target);
}
