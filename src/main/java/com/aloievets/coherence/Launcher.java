package com.aloievets.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

/**
 * Created by Andrew on 25.05.2017.
 */
public class Launcher {

    public static void main(String[] args) {
        String key = "k1";
        String value = "Hello World!";
        CacheFactory.ensureCluster();
        NamedCache cache = CacheFactory.getCache("hello-example");
        cache.put(key, value);
        System.out.println((String)cache.get(key));
        CacheFactory.shutdown();
    }
}
