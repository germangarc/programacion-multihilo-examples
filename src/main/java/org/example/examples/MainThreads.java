package org.example.examples;

import org.example.excercises.counter.Counter;

import java.util.LinkedList;
import java.util.List;

public class MainThreads {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();

        List<Thread> threads = new LinkedList<>();

        for(int i = 0; i < 5; i++){
            Thread t = new Thread(new Counter("Counter-" + i, 5));
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("El main ha terminado");

        long endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000);

    }
}
