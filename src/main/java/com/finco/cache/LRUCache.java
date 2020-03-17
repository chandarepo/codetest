package com.finco.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LRUCache <K, V> extends LinkedHashMap<K, V>  implements Solution<K,V, Integer>{

    //Map<K, Integer> ttlMap ;
    private static final long serialVersionUID = 1L;
    private int lruSize;

    public LRUCache(int lruSize) {
        super(16, 0.75f, true);
        //ttlMap = new HashMap<K, Integer>(16, 0.75f);
        this.lruSize = lruSize;
    }

    public V put(K k , V v , Integer secondsToSleep){
        if(0 == secondsToSleep) throw new IllegalArgumentException();
        //ttlMap.put(k,secondsToSleep);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(secondsToSleep);
                remove(k);
            } catch (InterruptedException ie) {
                //Thread.currentThread().interrupt();
                remove(k); //to_fix
            }
        }).start();
       return put(k,v);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > lruSize;
    }
}