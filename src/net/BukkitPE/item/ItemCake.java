package net.BukkitPE.item;

import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockCake;
import net.BukkitPE.level.Level;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ItemCake extends Item {

    public ItemCake() {
        this(0, 1);
    }

    public ItemCake(Integer meta) {
        this(meta, 1);
    }

    public ItemCake(Integer meta, int count) {
        super(CAKE, 0, count, "Cake");
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public boolean onActivate(Level level, Player player, Block block, Block target, int face, double fx, double fy, double fz) {

        level.setBlock(block, new BlockCake(), true);
        return true;
    }

}
