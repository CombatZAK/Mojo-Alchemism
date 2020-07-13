package com.mods.combatzak.mojo.alchemism.helpers;

import blusunrize.immersiveengineering.common.IEContent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.icannt.netherendingores.common.registry.BlockData;
import org.icannt.netherendingores.common.registry.BlockRegistry;
import thaumcraft.api.items.ItemsTC;

import java.util.Arrays;
import java.util.List;

/**
 * Contains helper methods for ItemStacks
 *
 * Created by CombatZAK on 4/21/2018.
 */
public class ItemStackHelper {
    public static final ItemStack paper = new ItemStack(Items.PAPER);
    public static final ItemStack copperGrit = new ItemStack(IEContent.itemMetal, 1, 9);
    public static final ItemStack leadGrit = new ItemStack(IEContent.itemMetal, 1, 11);
    public static final ItemStack ironGrit = new ItemStack(IEContent.itemMetal, 1, 18);
    public static final ItemStack silverGrit = new ItemStack(IEContent.itemMetal, 1, 12);
    public static final ItemStack goldGrit = new ItemStack(IEContent.itemMetal, 1, 19);
    public static final ItemStack aluminumGrit = new ItemStack(IEContent.itemMetal, 1, 10);
    public static final ItemStack ieDustSulfur = new ItemStack(IEContent.itemMaterial, 1, 25);
    public static final ItemStack tcCopperNugget = new ItemStack(ItemsTC.nuggets, 1, 1);
    public static final ItemStack tcTinNugget = new ItemStack(ItemsTC.nuggets, 1, 2);
    public static final ItemStack tcSilverNugget = new ItemStack(ItemsTC.nuggets, 1, 3);
    public static final ItemStack tcLeadNugget = new ItemStack(ItemsTC.nuggets, 1, 4);

    /**
     * Compares two item stacks for simple equivalence (no NBT or durability comparison)
     *
     * @param item1 first item to be compared
     * @param item2 second item to be compared
     * @param ignoreQuantity whether or not to compare item quantity
     * @return true if the stacks contain the same item type/subtype; false otherwise
     */
    public static boolean isDirectMatch(ItemStack item1, ItemStack item2, boolean ignoreQuantity) {
        if (item1 == null ^ item2 == null) return false; //exactly one of the items is null so they can't be equivalent
        if (item1 == null) return true; //the previous condition would have pre-empted only one item being null, so if one stack is null here, they both are
        if (item1.getItem() != item2.getItem()) return false; //base item types must match
        if (item1.getHasSubtypes() && item1.getItemDamage() != item2.getItemDamage()) return false; //subtypes must match if they have any
        if (ignoreQuantity && item1.getCount() != item2.getCount()) return false; //only checking count if the option indicates that it should be checked

        return true; //no fail condition encountered so the stacks match
    }

    /**
     * Compares two item stacks for simple equivalence (no NBT or durability comparison)
     *
     * @param item1 first item to be compared
     * @param item2 second item to be compared
     * @return true if the stacks contain the same item type/subtype; false otherwise
     */
    public static boolean isDirectMatch(ItemStack item1, ItemStack item2) {
        return isDirectMatch(item1, item2, false);
    }

    /**
     * Compares an item stack against and ore dictionary name
     *
     * @param item item to check for membership
     * @param oreDict ore dictionary entry to check
     * @return true if the item is a member of the ore dictionary entry
     */
    public static boolean isOreDictMatch(ItemStack item, String oreDict) {
        if (item == null || oreDict == null) return false; //either argument being null will cause this to fail
        List<ItemStack> oreDictEntry = OreDictionary.getOres(oreDict, false);
        if (oreDictEntry == null || oreDictEntry.isEmpty()) return false; //no ores means there cannot be a match

        for (ItemStack oreItem : oreDictEntry) {
            if (isDirectMatch(item, oreItem)) return true; //direct match found, stop here
        }

        return false; //no match
    }

    /**
     * Scans for any overlapping ore dictionary entries between two item stacks
     *
     * @return true if item1 and item2 share at least one ore dictionary entry in common; false otherwise
     */
    public static boolean isOreDictMatch(ItemStack item1, ItemStack item2) {
        if (item1 == null || item2 == null) return false; //no ore dict entries for null items
        int[] item1Entries = OreDictionary.getOreIDs(item1);
        int[] item2Entries = OreDictionary.getOreIDs(item2);

        return Arrays.stream(item1Entries).anyMatch(ore1 -> Arrays.stream(item2Entries).anyMatch(ore2 -> ore1 == ore2)); //first intersection element yields success
    }
}
