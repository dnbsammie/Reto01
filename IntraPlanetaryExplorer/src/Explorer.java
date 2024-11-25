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
    public String planet;

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
    private static final Object monitor = new Object();

    public static List<Planet> getPlanets() {
        List<Planet> planets = new ArrayList<>();
        // Nombre del planeta | Distancia en relacioón a la tierra | Tiempo en días | %
        // de combustible necesario por viaje | Tiene (o no) anillos
        planets.add(new Planet("Mercurio", 77, 26, 16, false));
        planets.add(new Planet("Venus", 41, 15, 13, false));
        planets.add(new Planet("Marte", 78, 89.6, 20, false));
        planets.add(new Planet("Júpiter", 628, 160.7, 45, true));
        planets.add(new Planet("Saturno", 1.275, 320, 56, true));
        planets.add(new Planet("Urano", 2.724, 450, 78, true));
        planets.add(new Planet("Neptuno", 4351, 600, 85, true));
        planets.add(new Planet("Pluton", 5906, 978, 98, false));

        return planets;
    }

    public static void main(String[] args) {
        List<Planet> planets = getPlanets();
        Scanner input = new Scanner(System.in);

        loadResources();

        System.out.println("Bienvenido usuario...\nPor favor, ingresa tu nombre: ");
        String userName = input.nextLine();

        printTime("¡Bienvenido a la nave, " + userName + "!");

        for (Planet planet : planets) {
            System.out.println(planet);
        }
        showMenu(input);

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

    // Seleccion del planeta a donde quiere viajar //
    public static void showMenu(Scanner input) {

        System.out.println("\n¿A que planeta deseas ir \n");
        // OPCIONES
        // SELECION DEL PLANETA POR EL USUARIO
        List<Planet> planets = getPlanets();

        System.out.println("\n Por favor ingresa el nombre del planeta al que desear ");
        String selectedPlanet = input.nextLine().trim();

        Planet planetToVisit = null;

        for (Planet planet : planets) {

            if (planet.getPlaneName().equalsIgnoreCase(selectedPlanet))
                planetToVisit = planet;

        }

        if (planetToVisit != null) {

            System.out.println(" \nHas seleccionadao viajar a " + planetToVisit);

            // planetas a ejecutar con sus contadores

            switch (selectedPlanet) {

                case "mercurio":

                    Thread combustibleThread = new Thread(() -> combustible(16));
                    Thread timeThread = new Thread(() -> time(26));

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

                    System.out.print(" combustible disponible en la nave ");

                    combustible(16);

                    System.out.print(" tiempo restante para llegar ");

                    time(26);

                    break;

                case "venus":
                    // venus
                    Thread combustibleThreadVenus = new Thread(() -> combustible(13));
                    Thread timeThreadVenus = new Thread(() -> time(15));

                    // Iniciar hilos
                    combustibleThreadVenus.start();
                    timeThreadVenus.start();

                    try {
                        // Esperar a que ambos hilos terminen
                        combustibleThreadVenus.join();
                        timeThreadVenus.join();
                    } catch (InterruptedException e) {
                        System.out.println("Error en la simulación del viaje");
                    }

                    System.out.print(" combustible disponible en la nave ");

                    combustible(13);

                    System.out.print(" tiempo restante para llegar ");

                    time(15);

                    break;
                case "marte":

                    Thread combustibleThreadMarte = new Thread(() -> combustible(20));
                    Thread timeThreadMarte = new Thread(() -> time(89.6));

                    // Iniciar hilos
                    combustibleThreadMarte.start();
                    timeThreadMarte.start();

                    try {
                        // Esperar a que ambos hilos terminen
                        combustibleThreadMarte.join();
                        timeThreadMarte.join();
                    } catch (InterruptedException e) {
                        System.out.println("Error en la simulación del viaje");
                    }

                    System.out.print(" combustible disponible en la nave ");

                    combustible(20);

                    System.out.print(" tiempo restante para llegar ");

                    time(89.6);

                    break;

                case "jupiter":
                    // creacion de hilos
                    Thread combustibleThreadJupiter = new Thread(() -> combustible(45));
                    Thread timeThreadJupiter = new Thread(() -> time(160.7));

                    // Iniciar hilos
                    combustibleThreadJupiter.start();
                    timeThreadJupiter.start();

                    try {
                        // Esperar a que ambos hilos terminen
                        combustibleThreadJupiter.join();
                        timeThreadJupiter.join();
                    } catch (InterruptedException e) {
                        System.out.println("Error en la simulación del viaje");
                    }

                    System.out.print(" combustible disponible en la nave ");

                    combustible(45);

                    System.out.print(" tiempo restante para llegar ");

                    time(160.7);
                    break;
                case "Saturno":
                    Thread combustibleThreadSaturno = new Thread(() -> combustible(56));
                    Thread timeThreadSaturno = new Thread(() -> time(320));

                    // Iniciar hilos
                    combustibleThreadSaturno.start();
                    timeThreadSaturno.start();

                    try {
                        // Esperar a que ambos hilos terminen
                        combustibleThreadSaturno.join();
                        timeThreadSaturno.join();
                    } catch (InterruptedException e) {
                        System.out.println("Error en la simulación del viaje");
                    }

                    System.out.print(" combustible disponible en la nave ");

                    combustible(56);

                    System.out.print(" tiempo restante para llegar ");

                    time(320);

                    break;

                case "urano":
                    Thread combustibleThreadUrano = new Thread(() -> combustible(78));
                    Thread timeThreadUrano = new Thread(() -> time(450));

                    // Iniciar hilos
                    combustibleThreadUrano.start();
                    timeThreadUrano.start();

                    try {
                        // Esperar a que ambos hilos terminen
                        combustibleThreadUrano.join();
                        timeThreadUrano.join();
                    } catch (InterruptedException e) {
                        System.out.println("Error en la simulación del viaje");
                    }

                    System.out.print(" combustible disponible en la nave ");

                    combustible(78);

                    System.out.print(" tiempo restante para llegar ");

                    time(450);
                    break;

                case "neptuno":
                    Thread combustibleThreadNeptuno = new Thread(() -> combustible(85));
                    Thread timeThreadNeptuno = new Thread(() -> time(600));

                    // Iniciar hilos
                    combustibleThreadNeptuno.start();
                    timeThreadNeptuno.start();

                    try {
                        // Esperar a que ambos hilos terminen
                        combustibleThreadNeptuno.join();
                        timeThreadNeptuno.join();
                    } catch (InterruptedException e) {
                        System.out.println("Error en la simulación del viaje");
                    }

                    System.out.print(" combustible disponible en la nave ");

                    combustible(85);

                    System.out.print(" tiempo restante para llegar ");

                    time(600);

                    break;

                case "pluton":

                    Thread combustibleThreadPluton = new Thread(() -> combustible(98));
                    Thread timeThreadPluton = new Thread(() -> time(978));

                    // Iniciar hilos
                    combustibleThreadPluton.start();
                    timeThreadPluton.start();

                    try {
                        // Esperar a que ambos hilos terminen
                        combustibleThreadPluton.join();
                        timeThreadPluton.join();
                    } catch (InterruptedException e) {
                        System.out.println("Error en la simulación del viaje");
                    }

                    System.out.print(" combustible disponible en la nave ");

                    combustible(98);

                    System.out.print(" tiempo restante para llegar ");

                    time(978);
                    break;
                default:
                    System.out.println(" planeta no valido");
                    break;

            }
        }
    }

    // Combustible disponible de la nave
    private static void combustible(double recFuel) {
        for (double i = recFuel; i > 0; i--) {
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

    // // Tiempo de la nave en llegar al planeta
    private static void time(double timeTravel) {

        for (double i = timeTravel; i > 0; i--) {
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

    // horas actuales ( hora de la maquina que lo esta ejecutando )
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

// private static int fuel;
// private static final int AVERAGE_SPEED = 10000000; // 10 millones de km por
// hora
// private static final Scanner entrada = new Scanner(System.in);
// private static final Object monitor = new Object(); // Objeto para
// sincronización

// public static void main(String[] args) {
// String planet;

// System.out.println("Simulador de viaje interplanetario");

// System.out.println("¿A qué planeta deseas ir?");
// planet = entrada.nextLine().toLowerCase();

// System.out.println("Digite el valor de combustible para el viaje
// (recomendado: ingresar el número 100)");
// fuel = entrada.nextInt();

// if (fuel < 10) {
// System.out.println("Recursos insuficientes para procesar el viaje");
// return;
// }

// switch (planet) {
// case "mercurio":
// System.out.println("Seleccionaste Mercurio");
// System.out.println("La distancia a Mercurio es de 77 millones de km");
// System.out.println("La nave viaja " + AVERAGE_SPEED + " km/h");
// System.out.println("Despegamos con un combustible de " + fuel + "%");
// System.out.println("¡Perfecto, abróchate los cinturones que vamos a
// despegar!");
// System.out.println("3...");
// System.out.println("2...");
// System.out.println("1...");

// // Crear hilos
// Thread combustibleThread = new Thread(() -> combustible(fuel));
// Thread timeThread = new Thread(() -> time(77000000));

// // Iniciar hilos
// combustibleThread.start();
// timeThread.start();

// try {
// // Esperar a que ambos hilos terminen
// combustibleThread.join();
// timeThread.join();
// } catch (InterruptedException e) {
// System.out.println("Error en la simulación del viaje");
// }
// break;

// default:
// System.out.println("Planeta no reconocido");
// break;
// }
// }

// // Combustible disponible de la nave
// private static void combustible(int fuel) {
// for (int i = fuel; i > 0; i--) {
// synchronized (monitor) {
// System.out.println("Combustible disponible " + i + "%");
// monitor.notify(); // Notificar al otro hilo
// try {
// monitor.wait(); // Esperar al otro hilo
// Thread.sleep(1000); // Retraso de 1 segundo
// } catch (InterruptedException e) {
// System.out.println("Error en el combustible");
// }
// }
// }
// }

// // Tiempo de la nave en llegar al planeta
// private static void time(int distance) {
// int timeHour = distance / AVERAGE_SPEED;

// for (int i = timeHour; i > 0; i--) {
// synchronized (monitor) {
// System.out.println("Tiempo restante " + i + " horas");
// monitor.notify(); // Notificar al otro hilo
// try {
// monitor.wait(); // Esperar al otro hilo
// Thread.sleep(1000); // Retraso de 1 segundo
// } catch (InterruptedException e) {
// System.out.println("Error en la simulación del vuelo");
// }
// }
// }

// synchronized (monitor) {
// System.out.println("¡Llegaste a tu destino!");
// monitor.notify(); // Notificar al otro hilo por si está esperando
// }
// }
// }
