package com.mods.combatzak.mojo.alchemism.recipes;

import com.sun.istack.internal.NotNull;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

/**
 * Created by CombatZAK on 5/24/2018.
 */
public class EnchantmentForgeIngredient extends Ingredient {
    ItemStack stack;
    public EnchantmentForgeIngredient(@NotNull ItemStack stack) {
        super(stack);
        this.stack = stack;
    }

    @Override
    public boolean apply(@Nullable ItemStack p_apply_1_) {
        if (p_apply_1_ == null) return false;
        if (stack.getItem() != p_apply_1_.getItem()) return false;
        //if (stack.isItemEnchanted() ^ p_apply_1_.isItemEnchanted()) return false;

        NBTTagList myEnchants = stack.getEnchantmentTagList();
        if (myEnchants.tagCount() == 0 && stack.hasTagCompound()) {
            myEnchants = stack.getTagCompound().getTagList("StoredEnchantments", Constants.NBT.TAG_COMPOUND);
        }
        NBTTagList otherEnchants = p_apply_1_.getEnchantmentTagList();
        if (otherEnchants.tagCount() == 0 && p_apply_1_.hasTagCompound()) {
            otherEnchants = p_apply_1_.getTagCompound().getTagList("StoredEnchantments", Constants.NBT.TAG_COMPOUND);
        }
        if (myEnchants == null ^ otherEnchants == null) return false;
        if (myEnchants == null) return true;

        if (myEnchants.tagCount() > otherEnchants.tagCount()) return false;
        for (NBTBase enchantTagBase : myEnchants) {
            NBTTagCompound enchantTag = (NBTTagCompound)enchantTagBase;
            short myId = enchantTag.getShort("id");
            short myLvl = enchantTag.getShort("lvl");
            boolean found = false;

            for (NBTBase otherTagBase : otherEnchants) {
                NBTTagCompound otherTag = (NBTTagCompound)otherTagBase;
                if (otherTag.getShort("id") != myId) continue;
                if (otherTag.getShort("lvl") >= myLvl) {
                    found = true;
                    break;
                }

                return false;
            }

            if (!found) return false;
        }

        return true;
    }
}
