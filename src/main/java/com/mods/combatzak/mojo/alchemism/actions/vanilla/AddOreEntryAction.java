package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Adds an item to an ore dictionary entry
 * Created by CombatZAK on 5/20/2018.
 */
public class AddOreEntryAction extends OreDictAction {
    private ItemStack item;

    public AddOreEntryAction(ItemStack item, String oreEntry) {
        super(oreEntry);
        this.item = item;
    }

    @Override
    public boolean apply() {
        OreDictionary.registerOre(oreEntry, item);

        setApplied();
        return true;
    }
}
