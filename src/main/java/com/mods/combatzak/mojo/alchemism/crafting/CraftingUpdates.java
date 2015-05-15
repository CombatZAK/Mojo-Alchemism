package com.mods.combatzak.mojo.alchemism.crafting;

import ic2.core.Ic2Items;

import java.util.ArrayList;
import java.util.List;

import tconstruct.tools.TinkerTools;
import tconstruct.world.TinkerWorld;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import mods.railcraft.common.items.ItemIngot.EnumIngot;
import mods.railcraft.common.items.ItemNugget;
import mods.railcraft.common.items.ItemNugget.EnumNugget;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.AddShapedAction;
import com.mods.combatzak.mojo.alchemism.actions.RemoveRecipesAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ShapedItemIngredient;

import forestry.core.config.ForestryBlock;
import forestry.core.config.ForestryItem;

import mods.railcraft.common.items.ItemIngot;

public class CraftingUpdates {
	/**
	 * Stores the recipe update actions
	 */
	private GroupAction recipeActions = new GroupAction();
	
	/**
	 * Singleton instance of the class
	 */
	private static CraftingUpdates instance = new CraftingUpdates();
	
	/**
	 * Gets the Crafting Updates singleton
	 * 
	 * @return single crafting updates instance
	 */
	public static CraftingUpdates getInstance() { return instance; }
	
	/**
	 * Registers updates to the basic crafting system 
	 */
	public void register() {
		recipeActions.apply();
	}
	
	/**
	 * Default constructor
	 */
	private CraftingUpdates() {
		recipeActions.add(addSilkyJewelRecipe());
		
		//deletion of forestry metal ingots/blocks
		recipeActions.add(new RemoveRecipesAction(ForestryItem.ingotCopper.getItemStack()));
		recipeActions.add(new RemoveRecipesAction(ForestryItem.ingotTin.getItemStack()));
		recipeActions.add(new RemoveRecipesAction(ForestryItem.ingotBronze.getItemStack()));
		recipeActions.add(new RemoveRecipesAction(ForestryBlock.resourceStorage.getItemStack(1, 1)));
		recipeActions.add(new RemoveRecipesAction(ForestryBlock.resourceStorage.getItemStack(1, 2)));
		recipeActions.add(new RemoveRecipesAction(ForestryBlock.resourceStorage.getItemStack(1, 3)));
		
		//deletion of TConstruct metal nuggets/ingots/blocks
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 19))); //iron nugget
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 20))); //copper nugget
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 21))); //tin nugget
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 22))); //aluminum nugget
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 31))); //bronze nugget
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 9)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 10)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 13)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerWorld.metalBlock, 1, 3)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerWorld.metalBlock, 1, 4)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerWorld.metalBlock, 1, 5)));
		
		//deletion of Galacticraft metal ingots/blocks
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCItems.basicItem, 1, 3))); //copper
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCItems.basicItem, 1, 4))); //tin
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCItems.basicItem, 1, 5))); //aluminum
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCBlocks.basicBlock, 1, 9))); //copper
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCBlocks.basicBlock, 1, 10))); //tin
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCBlocks.basicBlock, 1, 11))); //aluminum
		
		//deletion of IC2 metal ingots/blocks
		recipeActions.add(new RemoveRecipesAction(Ic2Items.copperIngot));
		recipeActions.add(new RemoveRecipesAction(Ic2Items.tinIngot));
		recipeActions.add(new RemoveRecipesAction(Ic2Items.bronzeIngot));
		recipeActions.add(new RemoveRecipesAction(Ic2Items.silverIngot));
		recipeActions.add(new RemoveRecipesAction(Ic2Items.leadIngot));
		
		//deletion of Railcraft metal ingots/blocks
		recipeActions.add(new RemoveRecipesAction(ItemNugget.getNugget(EnumNugget.COPPER)));
		recipeActions.add(new RemoveRecipesAction(ItemNugget.getNugget(EnumNugget.IRON)));
		recipeActions.add(new RemoveRecipesAction(ItemNugget.getNugget(EnumNugget.TIN)));
		recipeActions.add(new RemoveRecipesAction(ItemNugget.getNugget(EnumNugget.LEAD)));
		recipeActions.add(new RemoveRecipesAction(ItemIngot.getIngot(EnumIngot.COPPER)));
		recipeActions.add(new RemoveRecipesAction(ItemIngot.getIngot(EnumIngot.LEAD)));
		recipeActions.add(new RemoveRecipesAction(ItemIngot.getIngot(EnumIngot.TIN)));
		
	}
	
	private AddShapedAction addSilkyJewelRecipe() {
		ItemStack silkTouchBook = new ItemStack(Items.enchanted_book);
		silkTouchBook.addEnchantment(Enchantment.silkTouch, 1);
		
		ArrayList<IIngredient> ingredients = new ArrayList<IIngredient>();
		ingredients.add(new ShapedItemIngredient(silkTouchBook, 'a'));
		ingredients.add(new ShapedItemIngredient(new ItemStack(Items.string), 'b'));
		ingredients.add(new ShapedItemIngredient(new ItemStack(Items.diamond), 'c'));
		
		AddShapedAction result = new AddShapedAction(ingredients, new ItemStack(Items.diamond), new String[] { "ab ", "bcb", " ba" });
		return result;
	}
}
