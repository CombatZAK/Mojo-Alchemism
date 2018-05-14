package com.mods.combatzak.mojo.alchemism.actions.ae2.grinder;

import appeng.api.AEApi;
import appeng.api.features.IGrinderRecipe;
import appeng.api.features.IGrinderRecipeBuilder;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Replaces the output of the AE2 grinder matching an ore dictionary entry
 * Created by CombatZAK on 5/12/2018.
 */
public class ReplaceGrinderOutputAction extends GrinderAction {
    String oreEntry;
    ItemStack output;

    public ReplaceGrinderOutputAction(String oreEntry, ItemStack output) {
        this.oreEntry = oreEntry;
        this.output = output;
    }

    private boolean shouldReplaceOutput(ItemStack oldOutput) {
        return (ItemStackHelper.isOreDictMatch(oldOutput, oreEntry) && !ItemStackHelper.isDirectMatch(output, oldOutput));
    }

    @Override
    public boolean apply() {
        List<IGrinderRecipe> matches = new ArrayList<>();
        for (IGrinderRecipe recipe : AEApi.instance().registries().grinder().getRecipes()) {
            ItemStack outputStack = recipe.getOutput();
            if (shouldReplaceOutput(outputStack)) {
                matches.add(recipe);
                continue;
            }

            if (!recipe.getOptionalOutput().isPresent()) continue;
            outputStack = recipe.getOptionalOutput().get();
            if (shouldReplaceOutput(outputStack)) {
                matches.add(recipe);
                continue;
            }

            if (!recipe.getSecondOptionalOutput().isPresent()) continue;
            outputStack = recipe.getSecondOptionalOutput().get();
            if (shouldReplaceOutput(outputStack)) {
                matches.add(recipe);
            }
        }

        for (IGrinderRecipe oldRecipe : matches) {
            AEApi.instance().registries().grinder().removeRecipe(oldRecipe);
            IGrinderRecipeBuilder builder = AEApi.instance().registries().grinder().builder()
                    .withInput(oldRecipe.getInput())
                    .withTurns(oldRecipe.getRequiredTurns());

            ItemStack newOutput = !shouldReplaceOutput(oldRecipe.getOutput())
                    ? oldRecipe.getOutput()
                    : output.getCount() == oldRecipe.getOutput().getCount()
                        ? output
                        : output.copy();
            newOutput.setCount(oldRecipe.getOutput().getCount());
            builder = builder.withOutput(newOutput);

            if (oldRecipe.getOptionalOutput().isPresent()) {
                ItemStack oldOutput = oldRecipe.getOptionalOutput().get();
                newOutput = !shouldReplaceOutput(oldOutput)
                        ? oldRecipe.getOptionalOutput().get()
                        : output.getCount() == oldOutput.getCount()
                            ? output
                            : output.copy();
                newOutput.setCount(oldOutput.getCount());

                builder = builder.withFirstOptional(newOutput, oldRecipe.getOptionalChance());
            }

            if (oldRecipe.getSecondOptionalOutput().isPresent()) {
                ItemStack oldOutput = oldRecipe.getSecondOptionalOutput().get();
                newOutput = !shouldReplaceOutput(oldOutput)
                        ? oldOutput
                        : output.getCount() == oldOutput.getCount()
                            ? output
                            : output.copy();
                newOutput.setCount(oldOutput.getCount());

                builder = builder.withSecondOptional(newOutput, oldRecipe.getSecondOptionalChance());
            }

            AEApi.instance().registries().grinder().addRecipe(builder.build());
        }

        setApplied();
        return true;
    }
}
