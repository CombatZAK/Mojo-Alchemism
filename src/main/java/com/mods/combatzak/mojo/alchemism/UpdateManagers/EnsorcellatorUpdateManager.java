package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import com.mods.combatzak.mojo.alchemism.actions.cofh.ensorcellator.AddOrReplaceEnsorcellatorRecipeAction;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.shared.TinkerCommons;

/**
 * Manages updates to Arcane Ensorcellator
 * Created by CombatZAK on 5/24/2018.
 */
public class EnsorcellatorUpdateManager extends UpdateManager {
    private static EnsorcellatorUpdateManager ourInstance = new EnsorcellatorUpdateManager();

    public static EnsorcellatorUpdateManager getInstance() {
        return ourInstance;
    }

    private EnsorcellatorUpdateManager() {
        updateActions.add(new AddOrReplaceEnsorcellatorRecipeAction(TinkerCommons.matSilkyJewel, Enchantments.SILK_TOUCH.getRegistryName().toString(), 3));
    }
}
