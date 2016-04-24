package net.BukkitPE.item;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package net.BukkitPE.item in project BukkitPE.
 */
public class ItemFishingRod extends Item {

    public ItemFishingRod() {
        this(0, 1);
    }

    public ItemFishingRod(Integer meta) {
        this(meta, 1);
    }

    public ItemFishingRod(Integer meta, int count) {
        super(FISHING_ROD, meta, count, "Fishing Rod");
    }

    @Override
    public int getEnchantAbility() {
        return 1;
    }
}
