package controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import managers.EventManager;
import models.Planet;
import models.SpaceShip;
import utils.ConsoleUtil;
import utils.TimeUtil;

public class SimulationController {
    private Planet planet;
    private SpaceShip ship;
    private final List<Planet> planets;
    private final List<SpaceShip> ships;

    public SimulationController() {
        this.planets = List.of(new Planet("Mercurio", 77, 26, 16, false), new Planet("Venus", 41, 15, 13, false),
                new Planet("Marte", 78, 89.6, 20, false), new Planet("Ceres", 413, 130, 22, false),
                new Planet("Júpiter", 628, 160.7, 45, true), new Planet("Saturno", 1275, 320, 56, true),
                new Planet("Urano", 2724, 450, 78, true), new Planet("Neptuno", 4351, 600, 85, true),
                new Planet("Haumea", 635, 800, 48, false), new Planet("Makemake", 1420, 1200, 65, false),
                new Planet("Plutón", 5906, 978, 98, false), new Planet("Eris", 9630, 1600, 90, false));

        this.ships = List.of(new SpaceShip("Odyssey", 7000, 100, 300, 95, 60, 80, 0, 40,
                "Nave robusta y rápida, ideal para explorar planetas cercanos como Mercurio, Venus y Marte.\nResistencia y velocidad adecuadas para misiones cortas y medias."),
                new SpaceShip("LightStar", 6000, 180, 350, 80, 50, 70, 0, 30,
                        "Nave ligera y ágil, perfecta para viajar a Ceres, Júpiter y Saturno.\nAlta velocidad y maniobrabilidad para misiones rápidas."),
                new SpaceShip("Nucleus", 8000, 150, 300, 100, 80, 100, 0, 50,
                        "Nave resistente y de alta capacidad, diseñada para explorar Urano, Neptuno y Haumea.\nIdeal para viajes prolongados y condiciones adversas."),
                new SpaceShip("Apollo", 9000, 60, 200, 100, 90, 120, 0, 60,
                        "Nave resistente y bien protegida, adecuada para explorar los planetas más lejanos como Makemake, Plutón y Eris.\nDiseñada para soportar largos viajes y condiciones extremas."));
    }

    public List<Planet> getPlanets() { return planets; }

    private double calculateTravelTime(double distance, int speed) {
        return (speed <= 0) ? Double.MAX_VALUE : distance / speed;
    }

    public void planetSelector(Scanner input) {
        for (int i = 0; i < planets.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, planets.get(i).getName());
        }

        var choice = input.nextInt() - 1;
        input.nextLine();

        if (choice >= 0 && choice < planets.size()) {
            planet = planets.get(choice);
            System.out.printf("\nHas seleccionado el planeta: %s\n%s", planet.getName(), planet);
        } else {
            System.out.println("Selección no válida.");
        }
    }

    public void shipSelector(Scanner input) {
        for (int i = 0; i < ships.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, ships.get(i).getName());
            System.out.printf("   %s\n", ships.get(i).getSpecialNote());
        }

        var choice = input.nextInt() - 1;
        input.nextLine();

        if (choice >= 0 && choice < ships.size()) {
            ship = ships.get(choice);
            System.out.printf("\nHas seleccionado la nave: %s\n", ship.getName());
            ship.showStats();
        } else {
            System.out.println("Selección no válida.");
        }
    }

    public void spaceTrip(Scanner input) {
        if (planet == null || ship == null) {
            System.out.println("Debes seleccionar un planeta y una nave antes de comenzar el viaje.");
            return;
        }

        var distance = planet.getEarthDistance();
        var travelTime = calculateTravelTime(distance, ship.getSpeed());
        System.out.printf("La distancia a %s es %.2f millones de km y el tiempo de viaje estimado es %.2f días\n",
                planet.getName(), distance, travelTime);

        if (ship.getFuelCapacity() <= 0 || ship.getToughness() < 50 || ship.getShieldStrength() < 20) {
            System.out.println("¡La nave no está en condiciones óptimas de realizar el viaje!");
            return;
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\n\n[OK] ¡Listo para el lanzamiento!");
        System.out.println("Sistema de navegación, motores y energía preparados.");
        System.out.print("Despegue en ");

        for (int i = 3; i > 0; i--) {
            System.out.print(i + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nEl viaje ha comenzado...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double distanceTraveled = 0;
        double elapsedDays = 0;

        Set<String> eventHistory = new HashSet<>();

        while (distanceTraveled < distance) {
            distanceTraveled += ship.getSpeed() * 0.1;

            if (distanceTraveled > distance) {
                distanceTraveled = distance;
            }

            elapsedDays += 0.1;

            showState(distanceTraveled, distance, elapsedDays, travelTime, null, input);

            EventManager.triggerEvents(input, ship, planet, eventHistory);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (ship.getFuelCapacity() <= 0 || ship.getToughness() < 20 || ship.getDamage() > 50) {
                EventManager.shutDownShip(true);
                System.out.println("¡La nave ha sido dañada en el viaje y se ha apagado!");
                return;
            }
        }

        TimeUtil.printTime("El viaje se ha completado con éxito.");
    }

    public void showState(double distanceTraveled, double totalDistance, double elapsedDays, double totalTravelTime,
            String userId, Scanner input) {
        System.out.println("\n--- PANEL DE CONTROL ---");
        System.out.println("COMANDANTE " + (userId != null ? userId : ""));

        double progressPercentage = (distanceTraveled / totalDistance) * 100;
        if (progressPercentage > 100) {
            progressPercentage = 100;
        }

        System.out.printf("- Progreso del Viaje: %.2f%%\n", progressPercentage);
        System.out.printf("- Distancia Recorrida: %.2f millones de km / %.2f millones de km\n", distanceTraveled,
                totalDistance);

        System.out.println("\n--- RECURSOS ---");
        System.out.printf("- Combustible: %d\n", ship.getFuelCapacity());
        System.out.printf("- Energía: %d\n", ship.getEnergyLevel());
        System.out.printf("- Daño actual: %d\n", ship.getDamage());

        System.out.println("\n--- TIEMPO ---");
        System.out.printf("Tiempo Transcurrido: %.2f días\n", elapsedDays);
        double remainingDays = totalTravelTime - elapsedDays;
        System.out.printf("Tiempo Restante: %.2f días\n", remainingDays);

        System.out.println("\n--- ESTADO DE LA NAVE ---");
        String shipStatus = (ship.getFuelCapacity() <= 0 || ship.getToughness() < 20 || ship.getDamage() > 50)
                ? "NAVE EN PELIGRO"
                : "NAVE EN BUEN ESTADO";
        System.out.println("Estado de la nave: " + shipStatus);

        System.out.println("\n--- BARRA DE PROGRESO ---");
        ConsoleUtil.printProgressBar(progressPercentage);

        System.out.println("\n--- MANTENTE ALERTA " + (userId != null ? userId : "") + " ---");
    }

    public void settingsManager(Scanner input) {
        while (true) {
            ConsoleUtil.showSettingsMenu();

            int option = ConsoleUtil.getValidOption(input, 5);

            switch (option) {
            case 1:
                planetSelector(input);
                break;
            case 2:
                shipSelector(input);
                break;
            case 3:
                showSelectedPlanetInfo();
                break;
            case 4:
                showSelectedShipInfo();
                break;
            case 5:
                return;
            default:
                System.out.println("¡Opción inválida! Por favor, selecciona una opción válida.");
            }
        }
    }

    public void showSelectedPlanetInfo() {
        if (planet != null) {
            System.out.println(planet);
        } else {
            System.out.println("No has seleccionado ningún planeta.");
        }
    }

    public void showSelectedShipInfo() {
        if (ship != null) {
            ship.showStats();
        } else {
            System.out.println("No has seleccionado ninguna nave.");
        }
    }
}
