package com.aloievets.coherence;

import com.tangosol.net.CacheFactory;

import java.io.IOException;

/**
 * Created by Andrew on 25.05.2017.
 */
public class NodeLauncher {

    public static void main(String[] args) {
        CacheFactory.ensureCluster();

        try {
            System.out.println("Press Enter to stop the node");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
