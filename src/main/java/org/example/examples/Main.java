package org.example.examples;

public class Main {
    public static void main(String[] args) {
        Thread hilo = new Thread(new Tarea("A"));
        hilo.start();
        System.out.println("Fin");
    }
}
