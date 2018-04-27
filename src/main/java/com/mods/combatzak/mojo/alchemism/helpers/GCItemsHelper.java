package com.mods.combatzak.mojo.alchemism.helpers;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.minecraft.item.ItemStack;

import java.util.LinkedList;

/**
 * The GC4 API is broken - awesome. Let's write our own request items function
 *
 * Created by CombatZAK on 4/23/2018.
 */
public class GCItemsHelper {
    public static final ItemStack dustAluminum = new ItemStack(GCItems.ic2compat, 1); //the metas on these are an absurd hack
    public static final ItemStack orePurifiedAluminum = new ItemStack(GCItems.ic2compat, 1, 1);
    public static final ItemStack oreCrushedAluminum = new ItemStack(GCItems.ic2compat, 1, 2);
    public static final ItemStack tinyDustTitantium = new ItemStack(GCItems.ic2compat, 1, 7);

    public static final ItemStack ingotCopper = new ItemStack(GCItems.basicItem, 1, 3);
    public static final ItemStack ingotTin = new ItemStack(GCItems.basicItem, 1, 4);
    public static final ItemStack ingotAluminum = new ItemStack(GCItems.basicItem, 1, 5);
    public static final ItemStack ingotLead = new ItemStack(VenusItems.basicItem, 1, 1);

    public static final ItemStack blockCopper = new ItemStack(GCBlocks.basicBlock, 1, 9);
    public static final ItemStack blockTin = new ItemStack(GCBlocks.basicBlock, 1, 10);
    public static final ItemStack blockAluminum = new ItemStack(GCBlocks.basicBlock, 11);
    public static final ItemStack blockLead = new ItemStack(VenusBlocks.venusBlock, 1, 12);
}
