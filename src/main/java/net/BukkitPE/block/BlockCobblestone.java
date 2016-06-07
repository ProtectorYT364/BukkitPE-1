package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;

/**
 * author: Angelic47
 * BukkitPE Project
 */
public class BlockCobblestone extends BlockSolid {

    public BlockCobblestone() {
        this(0);
    }

    public BlockCobblestone(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return COBBLESTONE;
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public double getResistance() {
        return 30;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public String getName() {
        return "Cobblestone";
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN) {
            return new int[][]{new int[]{Item.COBBLESTONE, 0, 1}};
        } else {
            return new int[0][];
        }
    }

}
