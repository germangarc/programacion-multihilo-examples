package org.example.excercises.counter;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(8);
        long startTime = System.nanoTime();

        for (int i = 0; i < 5; i++){
            es.submit(new Counter("Counter-" + i, 5));
        }

        es.shutdown();

        es.awaitTermination(10, TimeUnit.MINUTES);

        System.out.println("The main has finish");

        long endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000);
    }
}
