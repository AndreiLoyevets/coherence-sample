package com.aloievets.coherence;

import com.tangosol.net.NamedCache;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notEmpty;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * Created by Andrew on 26.05.2017.
 */
public class Utils {

    private Utils() {
    }

    public static void repeatPrintCacheSizeAndMessage(NamedCache cache, String message, long timeout) {
        PrintCacheSizeAndMessage printCacheSizeAndMessage = new PrintCacheSizeAndMessage();
        printCacheSizeAndMessage.setCache(cache);
        printCacheSizeAndMessage.setMessage(message);
        new RepeatableAction(printCacheSizeAndMessage, timeout).start();
    }

    private static class RepeatableAction extends Thread {

        private final Runnable action;
        private final long timeout;

        public RepeatableAction(Runnable action, long timeout) {
            this.action = notNull(action);
            isTrue(timeout > 0, "timeout must be > 0");
            this.timeout = timeout;
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                action.run();
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class PrintCacheSizeAndMessage implements Runnable {

        private NamedCache cache;
        private String message;

        public void setCache(NamedCache cache) {
            this.cache = notNull(cache);
        }

        public void setMessage(String message) {
            this.message = notEmpty(message);
        }

        @Override
        public void run() {
            if (cache != null) {
                System.out.println(cache.size() + " items in cache " + cache.getCacheName());
            }
            if (message != null) {
                System.out.println(message);
            }
        }
    }

}
