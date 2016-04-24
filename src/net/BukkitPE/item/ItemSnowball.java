package net.BukkitPE.item;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ItemSnowball extends Item {

    public ItemSnowball() {
        this(0, 1);
    }

    public ItemSnowball(Integer meta) {
        this(meta, 1);
    }

    public ItemSnowball(Integer meta, int count) {
        super(SNOWBALL, 0, count, "Snowball");
    }

    @Override
    public int getMaxStackSize() {
        return 16;
    }
}
