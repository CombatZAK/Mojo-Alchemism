package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ic2.thermalcentrifuge.AddOrReplaceCentrifugeRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.ic2.thermalcentrifuge.ReplaceCentrifugeOutputAction;
import erogenousbeef.bigreactors.init.BrItems;
import net.minecraft.item.ItemStack;

/**
 * Stores the updates to Thermal Centrifuge recipes
 *
 * Created by CombatZAK on 5/5/2018.
 */
public class ThermalCentrifugeUpdateManager extends UpdateManager {
    private static ThermalCentrifugeUpdateManager ourInstance = new ThermalCentrifugeUpdateManager();

    public static ThermalCentrifugeUpdateManager getInstance() {
        return ourInstance;
    }

    private ThermalCentrifugeUpdateManager() {
        //DUSTS
        updateActions.add(new ReplaceCentrifugeOutputAction("dustCopper", ItemMaterial.dustCopper));
        updateActions.add(new ReplaceCentrifugeOutputAction("dustTin", ItemMaterial.dustTin));
        updateActions.add(new ReplaceCentrifugeOutputAction("dustIron", ItemMaterial.dustIron));
        updateActions.add(new ReplaceCentrifugeOutputAction("dustLead", ItemMaterial.dustLead));
        updateActions.add(new ReplaceCentrifugeOutputAction("dustSilver", ItemMaterial.dustSilver));
        updateActions.add(new ReplaceCentrifugeOutputAction("dustGold", ItemMaterial.dustGold));
        updateActions.add(new ReplaceCentrifugeOutputAction("dustAluminum", ItemMaterial.dustAluminum));
        updateActions.add(new ReplaceCentrifugeOutputAction("dustCoal", ItemMaterial.dustCopper));

        //Cyanite Reprocessing
        updateActions.add(new AddOrReplaceCentrifugeRecipeAction((short)1500, new ItemStack(BrItems.dustCyanite, 2), new ItemStack(BrItems.dustBlutonium)));
    }
}
