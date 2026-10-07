package org.example.excercises.turtleRun;

import java.util.Random;

public class Turtle implements Runnable {
    private String name;
    private final Random random;

    public Turtle(String name, Random random) {
        this.name = name;
        this.random = random;
    }

    @Override
    public void run() {
        for (int p = 0; p < 20; p++){
            System.out.println("I'm " + name + " and is the step " + p);

            try {
                Thread.sleep(random.nextLong(50, 200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + "  has reached the finish line!.");
    }

}
