package net.BukkitPE.level.generator.object;

import net.BukkitPE.block.Block;
import net.BukkitPE.level.ChunkManager;
import net.BukkitPE.math.BukkitPERandom;
import net.BukkitPE.math.Vector3;

/**
 * author: ItsLucas
 * BukkitPE Project
 */

public class ObjectTallGrass {
    public static void growGrass(ChunkManager level, Vector3 pos, BukkitPERandom random, int count, int radius) {
        int[][] arr = {
                {Block.DANDELION, 0},
                {Block.POPPY, 0},
                {Block.TALL_GRASS, 1},
                {Block.TALL_GRASS, 1},
                {Block.TALL_GRASS, 1},
                {Block.TALL_GRASS, 1}
        };
        int arrC = arr.length - 1;
        for (int c = 0; c < count; c++) {
            int x = random.nextRange((int) (pos.x - radius), (int) (pos.x + radius));
            int z = random.nextRange((int) (pos.z) - radius, (int) (pos.z + radius));

            if (level.getBlockIdAt(x, (int) (pos.y + 1), z) == Block.AIR && level.getBlockIdAt(x, (int) (pos.y), z) == Block.GRASS) {
                int[] t = arr[random.nextRange(0, arrC)];
                level.setBlockIdAt(x, (int) (pos.y + 1), z, t[0]);
                level.setBlockDataAt(x, (int) (pos.y + 1), z, t[1]);
            }
        }
    }
}
