package org.example.excercises.turtleRun;

import org.example.excercises.counter.Counter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(8);
        long startTime = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < 5; i++){
            es.submit(new Turtle("Turtle-" + i, random));
        }

        es.shutdown();
        System.out.println("The main has finish");

        long endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000);
    }
}
