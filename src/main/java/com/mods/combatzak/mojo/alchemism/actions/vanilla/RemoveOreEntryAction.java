package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Removes an item from an ore dictionary
 *
 * Created by CombatZAK on 5/1/2018.
 */
public class RemoveOreEntryAction extends OreDictAction {
    private ItemStack oreItem;

    public RemoveOreEntryAction(String oreEntry, ItemStack oreItem) {
        super(oreEntry);
        this.oreItem = oreItem;
    }

    public RemoveOreEntryAction() {
        this(null, null);
    }

    @Override
    public boolean apply() {
        if (oreEntry == null || oreEntry.equals("")) throw new IllegalStateException("RemoveOreEntryAction requires valid ore name");
        if (oreItem == null) throw new IllegalStateException("RemoveOreEntryAction requires valid ore item stack");

        ItemStack match = null;
        for (ItemStack item : OreDictionary.getOres(oreEntry, false)) {
            if (ItemStackHelper.isDirectMatch(oreItem, item)) {
                match = item;
                break;
            }
        }

        if (match != null) {
            OreDictionary.getOres(oreEntry).remove(match);
        }

        setApplied();
        return true;
    }
}
