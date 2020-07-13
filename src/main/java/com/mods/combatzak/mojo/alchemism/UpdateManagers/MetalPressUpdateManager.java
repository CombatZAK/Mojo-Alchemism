package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import blusunrize.immersiveengineering.common.IEContent;
import com.mods.combatzak.mojo.alchemism.actions.ie.metalpress.ReplaceMetalPressInputAction;
import mods.railcraft.common.items.Metal;
import net.minecraft.item.ItemStack;

/**
 * Created by CombatZAK on 7/12/2020.
 */
public class MetalPressUpdateManager extends UpdateManager {
    private static MetalPressUpdateManager instance = new MetalPressUpdateManager();

    public static MetalPressUpdateManager getInstance() {
        return instance;
    }

    private MetalPressUpdateManager() {
        updateActions.add(new ReplaceMetalPressInputAction(new ItemStack(IEContent.itemMold, 1, 3), Metal.BRASS.getStack(Metal.Form.INGOT), new ItemStack(IEContent.itemBullet, 2, 0)));
    }
}
