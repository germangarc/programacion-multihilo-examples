package org.example.excercises.account;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        Deposit task1 = new Deposit(account);
        Deposit task2 = new Deposit(account);

        ExecutorService es = Executors.newFixedThreadPool(2);

        for (int d = 0; d < 100000; d++) {
            es.submit(task1);
            es.submit(task2);
        }

        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("The accound have: " + account.getSaldo());
    }
}
