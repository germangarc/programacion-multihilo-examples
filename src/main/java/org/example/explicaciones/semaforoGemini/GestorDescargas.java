package org.example.explicaciones.semaforoGemini;
import java.util.concurrent.Semaphore;

public class GestorDescargas {
    // Creamos el semáforo con un aforo máximo de 2 hilos
    private final Semaphore semaforo = new Semaphore(2);

    public void descargarArchivo(String nombreHilo) {
        try {
            // 1. Intentamos coger un permiso. Si no hay, nos bloqueamos aquí.
            semaforo.acquire();
            System.out.println("🟢 " + nombreHilo + " ha conseguido permiso y empieza a descargar.");

            // 2. Simulamos la descarga (Sección Crítica con aforo máximo de 2)
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 3. OBLIGATORIO: Devolvemos el permiso en el finally pase lo que pase
            System.out.println("🔴 " + nombreHilo + " ha terminado y libera su permiso.");
            semaforo.release();
        }
    }
}

