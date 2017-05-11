package net.BukkitPE.item;

/**
 * BukkitPE Project
 */
public class ItemChestplateGold extends ItemArmor {

    public ItemChestplateGold() {
        this(0, 1);
    }

    public ItemChestplateGold(Integer meta) {
        this(meta, 1);
    }

    public ItemChestplateGold(Integer meta, int count) {
        super(GOLD_CHESTPLATE, meta, count, "Gold Chestplate");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_GOLD;
    }

    @Override
    public boolean isChestplate() {
        return true;
    }
}
