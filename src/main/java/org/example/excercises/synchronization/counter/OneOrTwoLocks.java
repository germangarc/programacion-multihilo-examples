package org.example.excercises.synchronization.counter;

public class OneOrTwoLocks {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter1.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter2.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("contador1 = " + counter1.getValue());
        System.out.println("contador2 = " + counter2.getValue());
    }
}
