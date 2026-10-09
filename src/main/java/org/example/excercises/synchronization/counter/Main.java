package org.example.excercises.synchronization.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int ITINERATIONS   = 100_000;

    public static void main(String[] args) {

        Counter counter = new Counter();

        Runnable incrementALot = () -> {
            for (int i = 0; i < ITINERATIONS; i++) {
                counter.increment();
            }
        };

        try (ExecutorService pool = Executors.newFixedThreadPool(2)) {
            pool.submit(incrementALot);
            pool.submit(incrementALot);
        }

        System.out.println("Resultado: " + counter.getValue());
    }
}
