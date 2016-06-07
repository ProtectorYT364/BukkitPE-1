package net.BukkitPE.block;

import net.BukkitPE.Player;
import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.redstone.Redstone;
import net.BukkitPE.utils.BlockColor;

/*
 * Created on 2015/12/11 by Pub4Game.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockRedstone extends BlockSolid {

    public BlockRedstone() {
        this(0);
    }

    public BlockRedstone(int meta) {
        super(0);
        this.setPowerSource(true);
        this.setPowerLevel(Redstone.POWER_STRONGEST);
    }

    @Override
    public int getId() {
        return REDSTONE_BLOCK;
    }

    @Override
    public double getResistance() {
        return 10;
    }

    @Override
    public double getHardness() {
        return 5;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public String getName() {
        return "Redstone Block";
    }

    @Override
    public boolean place(Item item, Block block, Block target, int face, double fx, double fy, double fz, Player player) {
        this.getLevel().setBlock(block, this, true, false);
        Redstone.active(this);
        this.getLevel().updateAllLight(this);
        this.getLevel().updateAroundRedstone(this);
        this.getLevel().updateAround(block);
        return true;
    }

    @Override
    public boolean onBreak(Item item) {
        int level = this.getPowerLevel();
        this.getLevel().setBlock(this, new BlockAir(), true, true);
        Redstone.deactive(this, level);
        return true;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN) {
            return new int[][]{{Item.REDSTONE_BLOCK, 0, 1}};
        } else {
            return new int[0][];
        }
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.REDSTONE_BLOCK_COLOR;
    }
}
