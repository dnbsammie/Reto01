package retoFundamentos;

import java.util.Scanner;

public class reto1 {

    private static int fuel;
    private static final int AVERAGE_SPEED = 10000000; // 10 millones de km por hora
    private static final Scanner entrada = new Scanner(System.in);
    private static final Object monitor = new Object(); // Objeto para sincronización

    public static void main(String[] args) {
        String planet;

        System.out.println("Simulador de viaje interplanetario");

        System.out.println("¿A qué planeta deseas ir?");
        planet = entrada.nextLine().toLowerCase();

        System.out.println("Digite el valor de combustible para el viaje (recomendado: ingresar el número 100)");
        fuel = entrada.nextInt();

        if (fuel < 10) {
            System.out.println("Recursos insuficientes para procesar el viaje");
            return;
        }

        switch (planet) {
            case "mercurio":
                System.out.println("Seleccionaste Mercurio");
                System.out.println("La distancia a Mercurio es de 77 millones de km");
                System.out.println("La nave viaja " + AVERAGE_SPEED + " km/h");
                System.out.println("Despegamos con un combustible de " + fuel + "%");
                System.out.println("¡Perfecto, abróchate los cinturones que vamos a despegar!");
                System.out.println("3...");
                System.out.println("2...");
                System.out.println("1...");

                // Crear hilos
                Thread combustibleThread = new Thread(() -> combustible(fuel));
                Thread timeThread = new Thread(() -> time(77000000));

                // Iniciar hilos
                combustibleThread.start();
                timeThread.start();

                try {
                    // Esperar a que ambos hilos terminen
                    combustibleThread.join();
                    timeThread.join();
                } catch (InterruptedException e) {
                    System.out.println("Error en la simulación del viaje");
                }
                break;

            default:
                System.out.println("Planeta no reconocido");
                break;
        }
    }

    // Combustible disponible de la nave
    private static void combustible(int fuel) {
        for (int i = fuel; i > 0; i--) {
            synchronized (monitor) {
                System.out.println("Combustible disponible " + i + "%");
                monitor.notify(); // Notificar al otro hilo
                try {
                    monitor.wait(); // Esperar al otro hilo
                    Thread.sleep(1000); // Retraso de 1 segundo
                } catch (InterruptedException e) {
                    System.out.println("Error en el combustible");
                }
            }
        }
    }

    // Tiempo de la nave en llegar al planeta
    private static void time(int distance) {
        int timeHour = distance / AVERAGE_SPEED;

        for (int i = timeHour; i > 0; i--) {
            synchronized (monitor) {
                System.out.println("Tiempo restante " + i + " horas");
                monitor.notify(); // Notificar al otro hilo
                try {
                    monitor.wait(); // Esperar al otro hilo
                    Thread.sleep(1000); // Retraso de 1 segundo
                } catch (InterruptedException e) {
                    System.out.println("Error en la simulación del vuelo");
                }
            }
        }

        synchronized (monitor) {
            System.out.println("¡Llegaste a tu destino!");
            monitor.notify(); // Notificar al otro hilo por si está esperando
        }
    }
}
