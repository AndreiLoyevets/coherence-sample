package com.aloievets.coherence.server;

import com.tangosol.net.DefaultCacheServer;

import java.io.IOException;

/**
 * Created by Andrew on 26.05.2017.
 */
public class Launcher {

    public static void main(String[] args) throws IOException {
        DefaultCacheServer.main(args);
    }
}
