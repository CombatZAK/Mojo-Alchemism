package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.cofh.furnace.ReplaceRedstoneFurnaceOutputAction;
import erogenousbeef.bigreactors.init.BrItems;
import net.minecraft.item.ItemStack;

/**
 * Manages updates and modifications to the Redstone Furnace
 *
 * Created by CombatZAK on 4/30/2018.
 */
public class RedstoneFurnaceUpdateManager extends UpdateManager {
    private static RedstoneFurnaceUpdateManager ourInstance = new RedstoneFurnaceUpdateManager();

    public static RedstoneFurnaceUpdateManager getInstance() {
        return ourInstance;
    }

    private RedstoneFurnaceUpdateManager() {
        //INGOTS
        updateActions.add(new ReplaceRedstoneFurnaceOutputAction("ingotCopper", ItemMaterial.ingotCopper));
        updateActions.add(new ReplaceRedstoneFurnaceOutputAction("ingotTin", ItemMaterial.ingotTin));
        updateActions.add(new ReplaceRedstoneFurnaceOutputAction("ingotLead", ItemMaterial.ingotLead));
        updateActions.add(new ReplaceRedstoneFurnaceOutputAction("ingotSilver", ItemMaterial.ingotSilver));
        updateActions.add(new ReplaceRedstoneFurnaceOutputAction("ingotUranium", new ItemStack(BrItems.ingotYellorium)));

        //DUSTS
        updateActions.add(new ReplaceRedstoneFurnaceOutputAction("dustCoal", ItemMaterial.dustCoal));
    }
}
