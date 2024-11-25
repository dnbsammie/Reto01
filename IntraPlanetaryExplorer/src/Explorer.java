/*
 * Dev Senior | Reto 01 - Modulo 01
 * Integrantes:
 * Luis Miguel Triana Rueda
 * Samuel Esteban Rivera Mosquera
 */
package IntraPlanetaryExplorer.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Planet {
    private String planetName; // Nombre del planeta
    private double earthDistance; // Distancia desde la tierra
    private double timeTravel; // Tiempo de viaje
    private double recFuel; // Combustible recomendado por planeta
    private boolean ringSystem; // El planeta tiene Anillos / Discos?

    // Metodo constructor
    public Planet(String planetName, double earthDistance, double timeTravel, double recFuel, boolean ringSystem) {
            this.planetName = planetName;
            this.earthDistance = earthDistance;
            this.timeTravel = timeTravel;
        this.recFuel = recFuel;
        this.ringSystem = ringSystem;
    }

    public String getPlaneName() {
        return planetName;
    }

    public double getEarthDistance() {
        return earthDistance;
    }

    public double getTimeTravel() {
        return timeTravel;
    }

    public double getRecFuel() {
        return recFuel;
    }

    public boolean getRingSystem() {
        return ringSystem;
    }

    @Override
    public String toString() {
        return "Planeta: " + planetName + "\n" +
                "Distancia desde la tierra: " + earthDistance + " millones de km\n" +
                "Tiempo de viaje: " + timeTravel + " días\n" +
                "Combustible recomendado: " + recFuel + "%\n" +
                "Tiene anillos: " + (ringSystem ? "Sí" : "No") + "\n";
    }
}

public class Explorer {
    public static List<Planet> getPlanets() {
        List<Planet> planets = new ArrayList<>();
        // Nombre del planeta | Distancia en relacioón a la tierra | Tiempo en días | % de combustible necesario por viaje | Tiene (o no) anillos  
        planets.add(new Planet("Mercurio", 77, 3, 15.25, false));
        planets.add(new Planet("Venus", 41, 2.5, 0.95, false));
        planets.add(new Planet("Marte", 78, 89.6, 0.53, false));
        planets.add(new Planet("Júpiter", 628, 160.7, 11.2, true));
        planets.add(new Planet("Saturno", 1.275, 50, 9.5, true));
        planets.add(new Planet("Urano", 2.724, 1, 4.0, true));
        planets.add(new Planet("Neptuno", 4351, 1, 3.9, true));
        planets.add(new Planet("Pluton", 5906, 1, 3.9, false));

        return planets;
    }

    public static void main(String[] args) {
        List<Planet> planets=getPlanets();
        Scanner input = new Scanner(System.in);

        loadResources();

        System.out.println("Bienvenido usuario...\nPor favor, ingresa tu nombre: ");
        String userName = input.nextLine();

        printTime("¡Bienvenido a la nave, " + userName + "!");

        for(Planet planet : planets){
            System.out.println(planet);
        }
        showMenu();

        input.close();
    }

    public static void loadResources() {
        System.out.println("Iniciando secuencias de carga...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sistemas de nave activados....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Revisando componentes...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n¡Listo para el lanzamiento!\n");
    }

    public static void showMenu() {
        System.out.println("\n¿Que desea realizar?\n");
        // OPCIONES
    }

    public static void printTime(String message) {
        LocalDateTime timeAndHour = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

        System.out.println(message);
        System.out.println("Fecha y hora actual: " + timeAndHour.format(format));
        System.out.println();
    }
}

// package retoFundamentos;

// import java.util.Scanner;

// public class reto1 {

//     private static int fuel;
//     private static final int AVERAGE_SPEED = 10000000; // 10 millones de km por hora
//     private static final Scanner entrada = new Scanner(System.in);
//     private static final Object monitor = new Object(); // Objeto para sincronización

//     public static void main(String[] args) {
//         String planet;

//         System.out.println("Simulador de viaje interplanetario");

//         System.out.println("¿A qué planeta deseas ir?");
//         planet = entrada.nextLine().toLowerCase();

//         System.out.println("Digite el valor de combustible para el viaje (recomendado: ingresar el número 100)");
//         fuel = entrada.nextInt();

//         if (fuel < 10) {
//             System.out.println("Recursos insuficientes para procesar el viaje");
//             return;
//         }

//         switch (planet) {
//             case "mercurio":
//                 System.out.println("Seleccionaste Mercurio");
//                 System.out.println("La distancia a Mercurio es de 77 millones de km");
//                 System.out.println("La nave viaja " + AVERAGE_SPEED + " km/h");
//                 System.out.println("Despegamos con un combustible de " + fuel + "%");
//                 System.out.println("¡Perfecto, abróchate los cinturones que vamos a despegar!");
//                 System.out.println("3...");
//                 System.out.println("2...");
//                 System.out.println("1...");

//                 // Crear hilos
//                 Thread combustibleThread = new Thread(() -> combustible(fuel));
//                 Thread timeThread = new Thread(() -> time(77000000));

//                 // Iniciar hilos
//                 combustibleThread.start();
//                 timeThread.start();

//                 try {
//                     // Esperar a que ambos hilos terminen
//                     combustibleThread.join();
//                     timeThread.join();
//                 } catch (InterruptedException e) {
//                     System.out.println("Error en la simulación del viaje");
//                 }
//                 break;

//             default:
//                 System.out.println("Planeta no reconocido");
//                 break;
//         }
//     }

//     // Combustible disponible de la nave
//     private static void combustible(int fuel) {
//         for (int i = fuel; i > 0; i--) {
//             synchronized (monitor) {
//                 System.out.println("Combustible disponible " + i + "%");
//                 monitor.notify(); // Notificar al otro hilo
//                 try {
//                     monitor.wait(); // Esperar al otro hilo
//                     Thread.sleep(1000); // Retraso de 1 segundo
//                 } catch (InterruptedException e) {
//                     System.out.println("Error en el combustible");
//                 }
//             }
//         }
//     }

//     // Tiempo de la nave en llegar al planeta
//     private static void time(int distance) {
//         int timeHour = distance / AVERAGE_SPEED;

//         for (int i = timeHour; i > 0; i--) {
//             synchronized (monitor) {
//                 System.out.println("Tiempo restante " + i + " horas");
//                 monitor.notify(); // Notificar al otro hilo
//                 try {
//                     monitor.wait(); // Esperar al otro hilo
//                     Thread.sleep(1000); // Retraso de 1 segundo
//                 } catch (InterruptedException e) {
//                     System.out.println("Error en la simulación del vuelo");
//                 }
//             }
//         }

//         synchronized (monitor) {
//             System.out.println("¡Llegaste a tu destino!");
//             monitor.notify(); // Notificar al otro hilo por si está esperando
//         }
//     }
// }
