package com.aetherteam.aether.utils;

import com.aetherteam.aether.mixin.mixins.common.accessor.EntityAccessor;
import io.github.fabricators_of_create.porting_lib.enchant.CustomEnchantingBehaviorItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
//import com.aetherteam.aether.Aether;
import it.unimi.dsi.fastutil.doubles.DoubleIterator;

import java.util.Map;

public class FabricUtils {

    public static boolean isInFluidType(Entity livingEntity) {
        for (DoubleIterator itr = ((EntityAccessor) livingEntity).getFluidHeight().values().iterator(); itr.hasNext();) {
            double fluidHeight = itr.nextDouble();
                if (fluidHeight > 0) { return true; }
            }
        return false;
        // Thank you TropheusJay asdf
    }

    public static boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (stack.getItem() instanceof CustomEnchantingBehaviorItem enchantingItem)
            return enchantingItem.canApplyAtEnchantingTable(stack, enchantment);
        return enchantment.category.canEnchant(stack.getItem());
    }

    public static Map<Enchantment, Integer> getAllEnchantments(ItemStack stack) {
        return EnchantmentHelper.deserializeEnchantments(stack.getEnchantmentTags());
    }
}
