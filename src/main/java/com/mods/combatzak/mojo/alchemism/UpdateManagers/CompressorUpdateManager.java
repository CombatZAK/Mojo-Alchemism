package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ic2.compressor.ReplaceCompressorOutputAction;

/**
 * Contains updates to Compressor recipes
 *
 * Created by CombatZAK on 5/3/2018.
 */
public class CompressorUpdateManager extends UpdateManager {
    private static CompressorUpdateManager ourInstance = new CompressorUpdateManager();

    public static CompressorUpdateManager getInstance() {
        return ourInstance;
    }

    private CompressorUpdateManager() {
        //DUSTS
        updateActions.add(new ReplaceCompressorOutputAction("dustCopper", ItemMaterial.dustCopper));
        updateActions.add(new ReplaceCompressorOutputAction("dustTin", ItemMaterial.dustTin));
        updateActions.add(new ReplaceCompressorOutputAction("dustBronze", ItemMaterial.dustBronze));
        updateActions.add(new ReplaceCompressorOutputAction("dustIron", ItemMaterial.dustIron));
        updateActions.add(new ReplaceCompressorOutputAction("dustLead", ItemMaterial.dustLead));
        updateActions.add(new ReplaceCompressorOutputAction("dustSilver", ItemMaterial.dustSilver));
        updateActions.add(new ReplaceCompressorOutputAction("dustGold", ItemMaterial.dustGold));
        updateActions.add(new ReplaceCompressorOutputAction("dustSulfur", ItemMaterial.dustSulfur));
        updateActions.add(new ReplaceCompressorOutputAction("dustObsidian", ItemMaterial.dustObsidian));

        //BLOCKS
        updateActions.add(new ReplaceCompressorOutputAction("blockCopper", BlockStorage.blockCopper));
        updateActions.add(new ReplaceCompressorOutputAction("blockTin", BlockStorage.blockTin));
        updateActions.add(new ReplaceCompressorOutputAction("blockBronze", BlockStorageAlloy.blockBronze));
        updateActions.add(new ReplaceCompressorOutputAction("blockLead", BlockStorage.blockLead));
        updateActions.add(new ReplaceCompressorOutputAction("blockSilver", BlockStorage.blockSilver));
        updateActions.add(new ReplaceCompressorOutputAction("blockSteel", BlockStorageAlloy.blockSteel));
    }
}
