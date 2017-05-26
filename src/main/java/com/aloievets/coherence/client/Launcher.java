package com.aloievets.coherence.client;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

import java.io.IOException;

import static com.aloievets.coherence.Utils.repeatPrintCacheSizeAndMessage;

/**
 * Created by Andrew on 26.05.2017.
 */
public class Launcher {

    public static void main(String[] args) throws IOException {
        CacheFactory.ensureCluster();
        NamedCache cache = CacheFactory.getCache("dist-extend");

        String key = "k1";
        String value = "Hello World!";
        cache.put(key, value);
        System.out.println("Entry in cache: " + cache.get(key));

        repeatPrintCacheSizeAndMessage(cache, "Press Enter to exit", 5000);
        System.in.read();
        CacheFactory.shutdown();
    }
}
