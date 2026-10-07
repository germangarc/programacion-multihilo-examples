package org.example.excercises.sumator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SequentialSum {
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[40];

        for (int i = 0; i < numbers.length; i++ ) {
            numbers[i] = i;
        }

        Sumator task1 = new Sumator(numbers, 0, 39);

        ExecutorService es = Executors.newFixedThreadPool(4);
        es.submit(task1);

        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES);

        int res = task1.getRes();

        System.out.println(res);
    }
}
