package org.example.excercises.sumator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[40];

        for (int i = 0; i < numbers.length; i++ ) {
            numbers[i] = i;
        }

        Sumator task1 = new Sumator(numbers, 0, 9);
        Sumator task2 = new Sumator(numbers, 10, 19);
        Sumator task3 = new Sumator(numbers, 20, 29);
        Sumator task4 = new Sumator(numbers, 30, 39);

        ExecutorService es = Executors.newFixedThreadPool(4);
        es.submit(task1);
        es.submit(task2);
        es.submit(task3);
        es.submit(task4);

        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES);

        int res = task1.getRes() + task2.getRes() + task3.getRes() + task4.getRes();

        System.out.println(res);
    }
}
