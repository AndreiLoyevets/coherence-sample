package com.aloievets.coherence.client;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

/**
 * Created by Andrew on 26.05.2017.
 */
public class Launcher {

    public static void main(String[] args) {
        CacheFactory.ensureCluster();
        NamedCache cache = CacheFactory.getCache("dist-extend");

        String key = "k1";
        String value = "Hello World!";
        cache.put(key, value);
        System.out.println("Entry in cache: " + cache.get(key));

        CacheFactory.shutdown();
    }
}
