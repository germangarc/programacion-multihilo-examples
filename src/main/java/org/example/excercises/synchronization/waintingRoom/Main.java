package org.example.excercises.synchronization.waintingRoom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WaitingRoom waitingRoom = new WaitingRoom();

        Thread t1 = new Thread( () -> {
            try {
                waitingRoom.enter("Task 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread( () -> {
            try {
                waitingRoom.enter("Task 2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t3 = new Thread( () -> {
            try {
                waitingRoom.enter("Task 3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t4 = new Thread( () -> {
            try {
                waitingRoom.enter("Task 4");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
