package com.mods.combatzak.mojo.alchemism.recipes;

import java.util.ArrayList;
import java.util.Iterator;

import com.mods.combatzak.mojo.alchemism.enchantments.EnchantmentHelpers;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ShapedOreEnchantmentRecipe extends ShapedOreRecipe {

	protected int height = 0;
	protected int width = 0;
	boolean mirrored = true;
	
	/**
	 * Creates a new ShapedOreEnchantmentRecipe instance
	 * @param result Product block
	 * @param recipe recipe
	 */
	public ShapedOreEnchantmentRecipe(Block result, Object... recipe) {
		super(result, recipe);
		
		String[] shape = (recipe[0] instanceof String[]) ? (String[])recipe[0] : (String[])recipe[1];
		if (recipe[0] instanceof Boolean) mirrored = (Boolean)recipe[0];
		height = shape.length;
		width = shape[0].length();
	}

	/**
	 * Creates a new ShapedOreEnchantmentRecipe instance
	 * @param result Product item
	 * @param recipe recipe
	 */
	public ShapedOreEnchantmentRecipe(Item result, Object... recipe) {
		super(result, recipe);
	}
	
	/**
	 * Creates a new ShapedOreEnchantmentRecipe instance
	 * @param result Product itemstack
	 * @param recipe recipe
	 */
	public ShapedOreEnchantmentRecipe(ItemStack result, Object... recipe) {
		super(result, recipe);
	}
	
	@Override
	public boolean matches(InventoryCrafting inv, World world) {
		for (int x = 0; x <= 3 - width; x++)
        {
            for (int y = 0; y <= 3 - height; ++y)
            {
                if (checkMatch(inv, x, y, false))
                {
                    return true;
                }

                if (mirrored && checkMatch(inv, x, y, true))
                {
                    return true;
                }
            }
        }

        return false;
	}
	
	protected boolean checkMatch(InventoryCrafting inv, int startX, int startY, boolean mirror)
    {
		Object[] input = getInput();
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                int subX = x - startX;
                int subY = y - startY;
                Object target = null;

                if (subX >= 0 && subY >= 0 && subX < width && subY < height)
                {
                    if (mirror)
                    {
                        target = input[width - subX - 1 + subY * width];
                    }
                    else
                    {
                        target = input[subX + subY * width];
                    }
                }

                ItemStack slot = inv.getStackInRowAndColumn(x, y);

                if (target instanceof ItemStack)
                {
                    if (!OreDictionary.itemMatches((ItemStack)target, slot, false))
                    {
                        return false;
                    }
                    if (((ItemStack) target).isItemEnchanted()) {
                    	NBTTagList list = ((ItemStack) target).getEnchantmentTagList();
                    	for (int enchIdx = 0; enchIdx < list.tagCount(); enchIdx++) {
                    		if (!EnchantmentHelpers.itemHasEnchantment(slot, list.getCompoundTagAt(enchIdx)))
                    			return false;
                    	}
                    }
                }
                else if (target instanceof ArrayList)
                {
                    boolean matched = false;

                    Iterator<ItemStack> itr = ((ArrayList<ItemStack>)target).iterator();
                    while (itr.hasNext() && !matched)
                    {
                        matched = OreDictionary.itemMatches(itr.next(), slot, false);
                    }

                    if (!matched)
                    {
                        return false;
                    }
                }
                else if (target == null && slot != null)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
