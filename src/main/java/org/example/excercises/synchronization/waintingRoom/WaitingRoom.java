package org.example.excercises.synchronization.waintingRoom;

public class WaitingRoom {
    public synchronized void enter(String nombre) throws InterruptedException {
        System.out.println(nombre + " ENTERS");
        Thread.sleep(1000);              // simula trabajo dentro de la sección crítica
        System.out.println(nombre + " LEAVES");
    }
}
