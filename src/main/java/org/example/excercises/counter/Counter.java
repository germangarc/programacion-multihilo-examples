package org.example.excercises.counter;

import java.util.Random;

public class Counter implements Runnable {
    private final String name;
    private final int numbLaps;

    public Counter(String name, int numbLaps) {
        this.name = name;
        this.numbLaps = numbLaps;
    }

    @Override
    public void run(){
        Random random = new Random();
        for (int i = 0; i < numbLaps; i++) {
            System.out.println("I'm " + name + ", lap " + (i + 1) + ".");

            try {
                Thread.sleep(random.nextLong(10, 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
