package net.BukkitPE.item;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ItemHelmetDiamond extends ItemArmor {

    public ItemHelmetDiamond() {
        this(0, 1);
    }

    public ItemHelmetDiamond(Integer meta) {
        this(meta, 1);
    }

    public ItemHelmetDiamond(Integer meta, int count) {
        super(DIAMOND_HELMET, meta, count, "Diamond Helmet");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public boolean isHelmet() {
        return true;
    }
}
