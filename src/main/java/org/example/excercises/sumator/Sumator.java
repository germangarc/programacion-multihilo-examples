package org.example.excercises.sumator;

public class Sumator implements Runnable {
    private final int[] numbers;
    private final int init;
    private final int end;

    private int res = 0;

    public Sumator(int[] numbers, int init, int end) {
        this.numbers = numbers;
        this.init = init; // X
        this.end = end; // Y
    }
    /// La suma sucesoria desde X hasta Y se puede escribir cómo: (Y - X +1)  * (X + Y) / 2;

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        res = (end - init + 1) * (init + end) / 2;
    }

    public int getRes() {
        return res;
    }
}
