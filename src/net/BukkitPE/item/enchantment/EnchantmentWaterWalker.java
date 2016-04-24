package net.BukkitPE.item.enchantment;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class EnchantmentWaterWalker extends Enchantment {
    protected EnchantmentWaterWalker() {
        super(ID_WATER_WALKER, "waterWalker", 2, EnchantmentType.ARMOR_FEET);
    }

    @Override
    public int getMinEnchantAbility(int level) {
        return level * 10;
    }

    @Override
    public int getMaxEnchantAbility(int level) {
        return this.getMinEnchantAbility(level) + 15;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
