package edu.escuelaing.arsw.ASE.app;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClienteMultiHilos {
    public static void main(String[] args) throws IOException {
        int numThreads = Integer.parseInt(args[0]);
        ExecutorService poolDeHilos = Executors.newFixedThreadPool(7);
        while (numThreads > 0) {
            numThreads--;
            MultiHilosProcessor processor = new MultiHilosProcessor(getPort());
            poolDeHilos.execute(processor);
        }
        poolDeHilos.shutdown();
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt((System.getenv("PORT")));
        }
        return 35000;
    }
}
