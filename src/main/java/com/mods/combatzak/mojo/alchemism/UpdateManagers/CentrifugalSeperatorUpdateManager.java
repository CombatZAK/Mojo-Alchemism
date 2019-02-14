package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import binnie.extrabees.items.types.ExtraBeeItems;
import com.mods.combatzak.mojo.alchemism.actions.cofh.separator.AddOrReplaceSeparatorRecipeAction;
import erogenousbeef.bigreactors.init.BrItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;

/**
 * Stores the recipe modifications for the Centrifugal Separator
 *
 * Created by CombatZAK on 5/6/2018.
 */
public class CentrifugalSeperatorUpdateManager extends UpdateManager {
    private static CentrifugalSeperatorUpdateManager ourInstance = new CentrifugalSeperatorUpdateManager();

    public static CentrifugalSeperatorUpdateManager getInstance() {
        return ourInstance;
    }

    private CentrifugalSeperatorUpdateManager() {
        updateActions.add(new AddOrReplaceSeparatorRecipeAction(8000, new ItemStack(BrItems.dustBlutonium, 1), null, new Tuple<>(ExtraBeeItems.BLUTONIUM_DUST.get(1), null), new Tuple<>(ExtraBeeItems.BLUTONIUM_DUST.get(1), 33)));
    }
}
