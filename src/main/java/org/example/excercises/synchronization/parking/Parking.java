package org.example.excercises.synchronization.parking;

import java.util.random.RandomGenerator;

public class Parking {
    public void park(int car) {
        try {
            System.out.println("Car " + car + " arrives.");

            Thread.sleep(RandomGenerator.getDefault().nextInt(1000, 3000));

            System.out.println("   Car " + car + " is leaving");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
