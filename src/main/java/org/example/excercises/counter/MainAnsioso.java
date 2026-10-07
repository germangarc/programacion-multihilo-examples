package org.example.excercises.counter;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainAnsioso {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(8);
        long startTime = System.nanoTime();

        List<Thread> threads = new LinkedList<>();

        for (int i = 0; i < 5; i++){
            Thread t = new Thread(new Counter("Counter-" + i, 5));
            threads.add(t);
        }

        for (Thread t: threads) {
            t.join();
        }

        System.out.println("The main has finish");

        long endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000);
    }
}
