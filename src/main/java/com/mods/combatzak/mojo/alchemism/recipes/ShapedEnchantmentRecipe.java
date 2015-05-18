package com.mods.combatzak.mojo.alchemism.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mods.combatzak.mojo.alchemism.enchantments.EnchantmentHelpers;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class ShapedEnchantmentRecipe extends ShapedRecipes {

	/**
	 * Inherited constructor
	 */
	public ShapedEnchantmentRecipe(int p_i1917_1_, int p_i1917_2_,
			ItemStack[] p_i1917_3_, ItemStack p_i1917_4_) {
		super(p_i1917_1_, p_i1917_2_, p_i1917_3_, p_i1917_4_);
	}
	
	/**
	 * Creates a ShapedEnchantment recipe object by parsing an object array for input
	 * 
	 * @param outputObj Product of the recipe
	 * @param inputs input ingredients
	 * @return ShapedEnchantmentRecipe object based on arguments
	 */
	public static ShapedEnchantmentRecipe createRecipe(ItemStack outputObj, Object[] inputs) {
		int recipeHeight = 0;
		int recipeWidth = 0;
		List<ItemStack> inputList = new ArrayList<ItemStack>();
		
		String[] pattern = (String[])inputs[0]; //get the pattern
		recipeHeight = pattern.length;
		recipeWidth = pattern[0].length();
		
		HashMap<Character, ItemStack> inputHash;
		int idx = 1;
		for (inputHash = new HashMap<Character, ItemStack>(); idx < inputs.length; idx += 2) {
			char label = (Character)inputs[idx];
			ItemStack ingredient = (ItemStack)inputs[idx + 1];
			inputHash.put(label, ingredient);
		}
		
		for (int rowIdx = 0; rowIdx < recipeHeight; rowIdx++) {
			for (int colIdx = 0; colIdx < recipeWidth; colIdx++) {
				char patternChar = pattern[rowIdx].charAt(colIdx);
				
				if (patternChar == ' ') {
					inputList.add(null);
				}
				else {
					inputList.add(inputHash.get(patternChar));
				}
			}
		}
		
		return new ShapedEnchantmentRecipe(recipeWidth, recipeHeight, inputList.toArray(new ItemStack[0]), outputObj);
	}
	
	/**
	 * Used to check if a crafting grid matches a recipe
	 */
	@Override
	public boolean matches(InventoryCrafting craftingGrid, World realm) {
		for (int i = 0; i <= 3 - this.recipeWidth; ++i)
        {
            for (int j = 0; j <= 3 - this.recipeHeight; ++j)
            {
                if (this.checkMatch(craftingGrid, i, j, true))
                {
                    return true;
                }

                if (this.checkMatch(craftingGrid, i, j, false))
                {
                    return true;
                }
            }
        }

        return false;
	}
	
	protected boolean checkMatch(InventoryCrafting craftingGrid, int i, int j, boolean reversed) {
		for (int k = 0; k < 3; ++k)
        {
            for (int l = 0; l < 3; ++l)
            {
                int i1 = k - i;
                int j1 = l - j;
                ItemStack itemstack = null;

                if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
                {
                    if (reversed)
                    {
                        itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
                    }
                    else
                    {
                        itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
                    }
                }

                ItemStack itemstack1 = craftingGrid.getStackInRowAndColumn(k, l);

                if (itemstack1 != null || itemstack != null)
                {
                    if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
                    {
                        return false;
                    }

                    if (itemstack.getItem() != itemstack1.getItem())
                    {
                        return false;
                    }

                    if (itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage())
                    {
                        return false;
                    }
                    
                    if (itemstack.isItemEnchanted()) {
                    	NBTTagList list = itemstack.getEnchantmentTagList();
                    	
                    	for (int enchIdx = 0; enchIdx < list.tagCount(); enchIdx++) {
                    		NBTTagCompound enchTag = list.getCompoundTagAt(enchIdx);
                    		if (!EnchantmentHelpers.itemHasEnchantment(itemstack1, enchTag))
                    			return false;
                    	}
                    }
                }
            }
        }
		
		return true;
	}
}
