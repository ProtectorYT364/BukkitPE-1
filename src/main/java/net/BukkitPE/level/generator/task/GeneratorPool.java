package net.BukkitPE.level.generator.task;

import net.BukkitPE.level.generator.Generator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BukkitPE Project
 */
public class GeneratorPool {
    private static final Map<Integer, Generator> generators = new ConcurrentHashMap<>();

    public static void put(int levelId, Generator generator) {
        generators.put(levelId, generator);
    }

    public static void remove(int levelId) {
        generators.remove(levelId);
    }

    public static boolean exists(int levelId) {
        return generators.containsKey(levelId);
    }

    public static Generator get(int levelId) {
        return generators.getOrDefault(levelId, null);
    }
}
