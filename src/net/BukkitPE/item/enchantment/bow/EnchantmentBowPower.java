package net.BukkitPE.item.enchantment.bow;

import net.BukkitPE.item.enchantment.Enchantment;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class EnchantmentBowPower extends EnchantmentBow {
    public EnchantmentBowPower() {
        super(Enchantment.ID_BOW_POWER, "arrowDamage", 10);
    }

    @Override
    public int getMinEnchantAbility(int level) {
        return 1 + (level - 1) * 20;
    }

    @Override
    public int getMaxEnchantAbility(int level) {
        return this.getMinEnchantAbility(level) + 15;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
