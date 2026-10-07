package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        // Crea un pool de hilos con 3 hilos
        ExecutorService pool = Executors.newFixedThreadPool(3);
        // Define la duración de cada tarea
        int[] duration = {3, 2, 4, 2, 1, 3, 2, 4, 2};

        // Creamos 9 tareas que se van a ejecutar sobre esos 3 hilos, de manera que habrá un máximo
        // de 3 tareas ejecutándose concurrentemente
        for (int i = 0; i < 9; i++) {
            int n = i + 1;
            int taskDuration = duration[i];
            pool.submit(() -> {
                try {
                    Thread.sleep(taskDuration * 500L);
                    System.out.println("Tarea " + n + " finalizada");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        // Ordenamos destruir el pool y sus threads
        pool.shutdown();
        // Esperamos a que acaben las tareas que se estén ejecutando, como máximo espera 1 minuto
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }
}