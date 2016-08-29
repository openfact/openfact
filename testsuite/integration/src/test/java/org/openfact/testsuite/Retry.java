package org.openfact.testsuite;

public class Retry {

    public static void execute(Runnable runnable, int retry, long interval) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (RuntimeException e) {
                retry--;
                if (retry > 0) {
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException ie) {
                        throw new RuntimeException(ie);
                    }
                } else {
                    throw e;
                }
            }
        }
    }

}
