package com.finco.cache;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LRUCacheTest {
    public static void main(String... args)  throws InterruptedException{

        LRUCache<Integer, String> cache = new LRUCache<>(5);
        for (int i = 1; i < 10; i++) {
            cache.put(i, "hi", i);
        }
        // entries 0-4 have already been removed
        // entries 5-9 are ordered
        System.out.println("cache = " + cache);

        System.out.println(cache.get(7));
        // entry 7 has moved to the end
        System.out.println("cache = " + cache);

        for (int i = 10; i < 14; i++) {
            cache.put(i, "hi", 10);
        }
        // entries 5,6,8,9 have been removed (eldest entries)
        // entry 7 is at the beginning now
        System.out.println("cache = " + cache);

        cache.put(42, "meaning of life", 10);
        // entry 7 is gone too
        System.out.println("cache = " + cache);
        TimeUnit.SECONDS.sleep(5);

        for (int i = 1; i < 14; i++) {
            System.out.println(cache.get(i));
        }
    }
}
