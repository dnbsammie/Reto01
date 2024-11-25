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
                "Tiempo de viaje: " + timeTravel + "días\n" +
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
        Scanner input = new Scanner(System.in);

        loadResources();

        System.out.println("Bienvenido usuario...\nPor favor, ingresa tu nombre: ");
        String userName = input.nextLine();

        printTime("¡Bienvenido a la nave, " + userName + "!");

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
    }

    public static void printTime(String message) {
        LocalDateTime timeAndHour = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

        System.out.println(message);
        System.out.println("Fecha y hora actual: " + timeAndHour.format(format));
        System.out.println();
    }
}