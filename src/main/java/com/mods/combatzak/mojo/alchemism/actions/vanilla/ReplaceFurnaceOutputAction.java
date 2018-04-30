package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class ReplaceFurnaceOutputAction extends FurnaceAction {
    private String oreEntry;

    public ReplaceFurnaceOutputAction(ItemStack output, String oreEntry) {
        super(null, output, 0f);
        this.oreEntry = oreEntry;
    }

    public ReplaceFurnaceOutputAction() {
        this(null, null);
    }

    public String getOreEntry() {
        return oreEntry;
    }

    public void setOreEntry(String oreEntry) {
        this.oreEntry = oreEntry;
    }

    @Override
    public boolean apply() {
        if (output == null) throw new IllegalStateException("ReplaceFurnaceOutputAction requires valid output stack");
        if (oreEntry == null) throw new IllegalStateException("ReplaceFurnaceOutputAction requires valid ore dict entry");

        List<ItemStack> inputItems = new ArrayList<>();
        for (Entry<ItemStack, ItemStack> furnaceRecipe : FurnaceRecipes.instance().getSmeltingList().entrySet()) {
            if (ItemStackHelper.isOreDictMatch(furnaceRecipe.getValue(), oreEntry) && !ItemStackHelper.isDirectMatch(furnaceRecipe.getValue(), output)) {
                inputItems.add(furnaceRecipe.getKey());
            }
        }

        for(ItemStack inputItem : inputItems) {
            ItemStack oldResult = FurnaceRecipes.instance().getSmeltingResult(inputItem);
            ItemStack outputItem = output.getCount() == oldResult.getCount()
                    ? output
                    : output.copy();
            outputItem.setCount(oldResult.getCount());

            FurnaceRecipes.instance().getSmeltingList().put(inputItem, outputItem);
        }

        setApplied();
        return true;
    }
}
