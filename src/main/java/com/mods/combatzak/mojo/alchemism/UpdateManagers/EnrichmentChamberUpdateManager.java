package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.mekanism.enrichmentchamber.ReplaceEnrichmentChamberOutputAction;

/**
 * Contains updates to Enrichment Chamber recipes
 * Created by CombatZAK on 5/9/2018.
 */
public class EnrichmentChamberUpdateManager extends UpdateManager {
    private static EnrichmentChamberUpdateManager ourInstance = new EnrichmentChamberUpdateManager();

    public static EnrichmentChamberUpdateManager getInstance() {
        return ourInstance;
    }

    private EnrichmentChamberUpdateManager() {
        //DUSTS
        updateActions.add(new ReplaceEnrichmentChamberOutputAction("dustCopper", ItemMaterial.dustCopper));
        updateActions.add(new ReplaceEnrichmentChamberOutputAction("dustTin", ItemMaterial.dustTin));
        updateActions.add(new ReplaceEnrichmentChamberOutputAction("dustIron", ItemMaterial.dustIron));
        updateActions.add(new ReplaceEnrichmentChamberOutputAction("dustLead", ItemMaterial.dustLead));
        updateActions.add(new ReplaceEnrichmentChamberOutputAction("dustSilver", ItemMaterial.dustSilver));
        updateActions.add(new ReplaceEnrichmentChamberOutputAction("dustGold", ItemMaterial.dustGold));
        updateActions.add(new ReplaceEnrichmentChamberOutputAction("dustObsidian", ItemMaterial.dustObsidian));
    }
}
