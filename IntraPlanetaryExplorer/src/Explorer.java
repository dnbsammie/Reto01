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

    public String getPlanetName() {
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

class SpaceShip {
    private String shipName; // Nombre de la nave
    private int maxSpeed; // Velocidad Máxima de la nave
    private int crewCapacity; // Capacidad de tripulantes
    private int gravityControl; // Control de gravedad (Maniobrilidad)
    private int fuelCapacity; // Capacidad máxima de combustible
    private int damage; // % de daño actual de la nave
    private int toughness; // Resistencia de la nave

    public SpaceShip(String shipName, int maxSpeed, int crewCapacity, int gravityControl, int fuelCapacity, int damage,
            int toughness) {
        this.shipName = shipName;
        this.maxSpeed = maxSpeed;
        this.crewCapacity = crewCapacity;
        this.gravityControl = gravityControl;
        this.fuelCapacity = fuelCapacity;
        this.damage = damage;
        this.toughness = toughness;
    }

    // Setters
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    public void setGravityControl(int gravityControl) {
        this.gravityControl = gravityControl;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    // Getters
    public String getShipName() {
        return shipName;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public int getGravityControl() {
        return gravityControl;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getDamage() {
        return damage;
    }

    public int getToughness() {
        return toughness;
    }

    public void showShipStats() {
        System.out.println("Nombre de la Nave: " + shipName);
        System.out.println("Velocidad Máxima: " + maxSpeed);
        System.out.println("Capacidad de tripulantes: " + crewCapacity);
        System.out.println("Control de gravedad: " + gravityControl);
        System.out.println("Capacidad de combustible: " + shipName);
        System.out.println("Daño actual: " + damage);
        System.out.println("Resistencia de la nave: " + toughness);
    }
}

public class Explorer {
    private static Planet selectedPlanet; // Variable global para el planeta seleccionado
    private static SpaceShip selectedShip;

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

    // Carga de sistemas de la nave
    public static void loadResources() {
        System.out.print("Iniciando secuencias de carga");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Sistemas de nave activados");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n¡Listo para el lanzamiento!\n");
    }

    // Hora actual ( hora de la maquina que lo esta ejecutando )
    public static void printTime(String message) {
        LocalDateTime timeAndHour = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        System.out.println(message);
        System.out.println("Fecha y hora actual: " + timeAndHour.format(format));
        System.out.println();
    }

    // Metodo principal
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        loadResources();

        System.out.println("Usuario. Por favor, ingresa tu Alias: ");
        String userName = input.nextLine();

        Random random = new Random();
        int userId = random.nextInt(9000) + 1000;

        System.out.println("\nGenerando ID...\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printTime("¡Bienvenido a la nave, " + userName + userId + "!");

        boolean cont = true;
        while (cont) {
            showMenu();
            int option = input.nextInt();

            switch (option) {
                case 1:
                    planetSelector(input); // Planeta de destino
                    break;
                case 2:
                    shipSelector(input); // Selección de nave
                    break;
                case 3:
                    spaceTrip(input); // Inicio de viaje
                    break;
                case 4:
                    settingsManager(input); // Menu de opciones
                    break;
                case 5:
                    shutDownShip(false);
                    cont = false;
                    break;
                default:
                    System.out.println("¡OPCIÓN INVALIDA!");
                    System.out.println(
                            userName + userId + "Por favor " + userName + userId + ",elige una opción correcta.");
            }
        }
        input.close();
    }

    public static void showMenu() {
        System.out.println("\n--- PANEL CENTRAL ---\n");
        System.out.println("1. Planeta de destino.");

        System.out.println("2. Selección de nave.");
        System.out.println("3. Inicio del Viaje.");
        System.out.println("4. Opciones.");
        System.out.println("5. Salir de la nave.");
        System.out.print("\nElige una opción: \n");
    }

    // Seleccion del planeta a donde quiere viajar //
    public static void planetSelector(Scanner input) {
        List<Planet> planets = getPlanets();
        System.out.println(" Escribe el numero al cual le correponde cada planeta para seleccionarlos :");
        for (int i = 0; i < planets.size(); i++) {
            System.out.println((i + 1) + ". " + planets.get(i).getPlanetName());
        }

        int planetChoice = input.nextInt();
        input.nextLine(); // limpieza de buffer despues de leer un entero 
        Planet selectedPlanet = planets.get(planetChoice - 1);
        System.out.println("Has seleccionado el planeta: " + selectedPlanet.getPlanetName());
        System.out.println(selectedPlanet);
    }

    // Seleccionador de Naves
    public static void shipSelector(Scanner input) {
        List<SpaceShip> ships = new ArrayList<>();
        ships.add(new SpaceShip("Odyssey", 5000, 100, 200, 100, 0, 50));
        ships.add(new SpaceShip("LightStar", 4500, 200, 300, 70, 0, 10));
        ships.add(new SpaceShip("Nucleus", 6000, 150, 250, 80, 0, 100));
        ships.add(new SpaceShip("Apollo", 800, 8, 90, 95, 20, 110));

        System.out.println("Selecciona una nave:");
        for (int i = 0; i < ships.size(); i++) {
            System.out.println((i + 1) + ". " + ships.get(i).getShipName());
        }

        int shipChoice = input.nextInt();
        input.nextLine(); 
        SpaceShip selectedShip = ships.get(shipChoice - 1);
        System.out.println("Has seleccionado la nave: " + selectedShip.getShipName());
        selectedShip.showShipStats();
    }

    public static void spaceTrip(Scanner input) {
        if (selectedPlanet == null || selectedShip == null) {
            System.out.println("Debes seleccionar un planeta y una nave antes de comenzar el viaje.");
            return;
        }

        System.out.println("\nComenzando el viaje hacia " + selectedPlanet.getPlanetName());
        System.out.println("Distancia al planeta: " + selectedPlanet.getEarthDistance() + " millones de km");
        System.out.println("Tiempo estimado de viaje: " + selectedPlanet.getTimeTravel() + " días");

        // Si la nave tiene suficiente combustible para el viaje
        if (selectedShip.getFuelCapacity() <= 0) {
            System.out.println("¡La nave no tiene suficiente combustible! El viaje no puede realizarse.");
            return;
        }

        // Si la nave tiene suficiente resistencia (para el daño) antes de partir
        if (selectedShip.getToughness() > 50) {
            System.out.println("¡La nave tiene un daño significativo y no puede viajar con seguridad!");
            return;
        }

        // Simulación del viaje
        System.out.println("\nEl viaje ha comenzado...\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        eventManager(input);

        if (selectedShip.getFuelCapacity() <= 0) {
            System.out.println("¡La nave se quedó sin combustible durante el viaje!");
            shutDownShip(true);
            return;
        }

        if (selectedShip.getDamage() > 50) {
            System.out.println("¡La nave sufrió demasiados daños durante el viaje!");
            shutDownShip(true);
            return;
        }

        System.out.println("\n¡Has llegado al planeta " + selectedPlanet.getPlanetName() + "!");
        System.out.println("Tiempo total de viaje: " + selectedPlanet.getTimeTravel() + " días");
        printTime("En la tierra la hora es:");
    }

    public static void eventManager(Scanner input) {
        Random random = new Random();

        // Evento de pérdida de combustible
        if (random.nextInt(100) < 20) { // 20% de probabilidad
            System.out.println("¡Atención! La nave ha perdido parte de su combustible debido a una fuga.");
            selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 10); // Decrementamos el combustible
    
            // Oportunidad de reparación
            System.out.println("¿Quieres intentar reparar la fuga? Responde correctamente para sellarla y recuperar combustible.");
            System.out.println("Pregunta: ¿Cuál es el elemento más abundante en el universo?");
            System.out.println("a) Hidrógeno\nb) Oxígeno\nc) Carbono\nd) Helio");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("a")) {
                System.out.println("¡Correcto! Has sellado la fuga y recuperado 8 unidades de combustible.");
                selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() + 8); // Recupera parte del combustible
            } else {
                System.out.println("Respuesta incorrecta. La fuga no pudo ser sellada.");
            }
        }
        // falla electronica
        if (random.nextInt(100) < 99) { // 25% de probabilidad
            System.out.println("¡Interferencia electromagnética detectada! Los sistemas de navegación están inestables.");
            selectedShip.setGravityControl(selectedShip.getGravityControl() - 10); // Reducción en maniobrabilidad
    
            // Oportunidad de estabilización
            System.out.println("¿Quieres intentar estabilizar los sistemas? Responde correctamente para restaurar el control.");
            System.out.println("Pregunta: ¿En qué año aterrizó el primer humano en la Luna?");
            System.out.println("a) 1965\nb) 1969\nc) 1972\nd) 1975");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("b")) {
                System.out.println("¡Correcto! Has estabilizado los sistemas y restaurado el control de gravedad.");
                selectedShip.setGravityControl(selectedShip.getGravityControl() + 10); // Recupera maniobrabilidad
            } else {
                System.out.println("Respuesta incorrecta. Los sistemas siguen inestables.");
            }
        }

        // sobrecaliento del motor
        if (random.nextInt(100) < 30) { // 30% de probabilidad
            System.out.println("¡Alerta! El motor está sobrecalentado debido a las altas temperaturas espaciales.");
            selectedShip.setDamage(selectedShip.getDamage() + 5); // Aumento del daño
    
            // Oportunidad de enfriamiento
            System.out.println("¿Quieres intentar enfriar el motor? Responde correctamente para reducir el daño.");
            System.out.println("Pregunta: ¿Qué planeta del Sistema Solar es conocido como el 'Planeta Rojo'?");
            System.out.println("a) Marte\nb) Venus\nc) Júpiter\nd) Saturno");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("a")) {
                System.out.println("¡Correcto! Has enfriado el motor y reducido el daño en 3 unidades.");
                selectedShip.setDamage(selectedShip.getDamage() - 3); // Reduce parte del daño
            } else {
                System.out.println("Respuesta incorrecta. El motor sigue sobrecalentado.");
            }
        }
        // Evento de daño adicional
        if (random.nextInt(100) < 15) { // 15% de probabilidad
            System.out.println("¡Un meteorito ha impactado la nave! La nave ha sufrido daño adicional.");
            selectedShip.setDamage(selectedShip.getDamage() + 10); // Aumentamos el daño
        }
        // Advertencia
        if (random.nextInt(100) < 45) {
            System.out.println(
                    " ¡perdida de combustible fragementos de roca en el espacio detectados ten cuidado de no peder proviciones ");

        }

        // Evento de colisión con micro-asteroides
        if (random.nextInt(100) < 10) { // 10% de probabilidad
            System.out.println("¡Colisión con micro-asteroides! El casco de la nave ha sido dañado.");
            selectedShip.setDamage(selectedShip.getDamage() + 8); // Incremento de daño
            selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 3); // Pequeña pérdida de combustible
        }

        // Evento de tormenta de radiación
        if (random.nextInt(100) < 12) { // 12% de probabilidad
            System.out.println("¡Tormenta de radiación espacial! Los escudos han sido debilitados.");
            selectedShip.setToughness(selectedShip.getToughness() - 5); // Reducción en resistencia
        }

        System.out.println("\nEventos de viaje gestionados.");

    }

    public static void settingsManager(Scanner input) {

    }

    public static void shutDownShip(boolean isFailure) {
        // Salir de la nave por fallas
        if (isFailure) {
            if (selectedShip.getDamage() >= 50 || selectedShip.getFuelCapacity() <= 10) {
                System.out.println("La nave ha fallado: ");
                if (selectedShip.getDamage() >= 50) {
                    System.out.println("Daño excesivo: " + selectedShip.getDamage() + "%.");
                }
                if (selectedShip.getFuelCapacity() <= 10) {
                    System.out.println("Combustible insuficiente.");
                }
                System.out.println("El viaje ha fracasado debido a fallas técnicas. Apagando los sistemas.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Sistema de la nave apagado con éxito debido a fallas. El viaje ha terminado.");
                System.exit(0);
            }
        }
        // Salida normal
        System.out.print("Revisando componentes");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Todos los subsistemas han sido apagados de manera segura");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n¡Sistema de la nave apagado con éxito!\n");
        System.exit(0);
    }
}

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
// // Seleccion del planeta a donde quiere viajar //
// public static void planetSelector() {
// System.out.println("\n¿A que planeta deseas ir \n");
// // OPCIONES
// // SELECION DEL PLANETA POR EL USUARIO
// List<Planet> planets = getPlanets();

// System.out.println("\n Por favor ingresa el nombre del planeta al que desear
// ");
// String selectedPlanet = input.nextLine().trim();

// Planet planetToVisit = null;

// for (Planet planet : planets) {

// if (planet.getPlaneName().equalsIgnoreCase(selectedPlanet))
// planetToVisit = planet;

// }

// if (planetToVisit != null) {

// System.out.println(" \nHas seleccionadao viajar a " + planetToVisit);

// // planetas a ejecutar con sus contadores

// switch (selectedPlanet) {

// case "mercurio":

// Thread combustibleThread = new Thread(() -> combustible(16));
// Thread timeThread = new Thread(() -> time(26));

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

// System.out.print(" combustible disponible en la nave ");

// combustible(16);

// System.out.print(" tiempo restante para llegar ");

// time(26);

// break;

// case "venus":
// // venus
// Thread combustibleThreadVenus = new Thread(() -> combustible(13));
// Thread timeThreadVenus = new Thread(() -> time(15));

// // Iniciar hilos
// combustibleThreadVenus.start();
// timeThreadVenus.start();

// try {
// // Esperar a que ambos hilos terminen
// combustibleThreadVenus.join();
// timeThreadVenus.join();
// } catch (InterruptedException e) {
// System.out.println("Error en la simulación del viaje");
// }

// System.out.print(" combustible disponible en la nave ");

// combustible(13);

// System.out.print(" tiempo restante para llegar ");

// time(15);

// break;
// case "marte":

// Thread combustibleThreadMarte = new Thread(() -> combustible(20));
// Thread timeThreadMarte = new Thread(() -> time(89.6));

// // Iniciar hilos
// combustibleThreadMarte.start();
// timeThreadMarte.start();

// try {
// // Esperar a que ambos hilos terminen
// combustibleThreadMarte.join();
// timeThreadMarte.join();
// } catch (InterruptedException e) {
// System.out.println("Error en la simulación del viaje");
// }

// System.out.print(" combustible disponible en la nave ");

// combustible(20);

// System.out.print(" tiempo restante para llegar ");

// time(89.6);

// break;

// case "jupiter":
// // creacion de hilos
// Thread combustibleThreadJupiter = new Thread(() -> combustible(45));
// Thread timeThreadJupiter = new Thread(() -> time(160.7));

// // Iniciar hilos
// combustibleThreadJupiter.start();
// timeThreadJupiter.start();

// try {
// // Esperar a que ambos hilos terminen
// combustibleThreadJupiter.join();
// timeThreadJupiter.join();
// } catch (InterruptedException e) {
// System.out.println("Error en la simulación del viaje");
// }

// System.out.print(" combustible disponible en la nave ");

// combustible(45);

// System.out.print(" tiempo restante para llegar ");

// time(160.7);
// break;
// case "Saturno":
// Thread combustibleThreadSaturno = new Thread(() -> combustible(56));
// Thread timeThreadSaturno = new Thread(() -> time(320));

// // Iniciar hilos
// combustibleThreadSaturno.start();
// timeThreadSaturno.start();

// try {
// // Esperar a que ambos hilos terminen
// combustibleThreadSaturno.join();
// timeThreadSaturno.join();
// } catch (InterruptedException e) {
// System.out.println("Error en la simulación del viaje");
// }

// System.out.print(" combustible disponible en la nave ");

// combustible(56);

// System.out.print(" tiempo restante para llegar ");

// time(320);

// break;

// case "urano":
// Thread combustibleThreadUrano = new Thread(() -> combustible(78));
// Thread timeThreadUrano = new Thread(() -> time(450));

// // Iniciar hilos
// combustibleThreadUrano.start();
// timeThreadUrano.start();

// try {
// // Esperar a que ambos hilos terminen
// combustibleThreadUrano.join();
// timeThreadUrano.join();
// } catch (InterruptedException e) {
// System.out.println("Error en la simulación del viaje");
// }

// System.out.print(" combustible disponible en la nave ");

// combustible(78);

// System.out.print(" tiempo restante para llegar ");

// time(450);
// break;

// case "neptuno":
// Thread combustibleThreadNeptuno = new Thread(() -> combustible(85));
// Thread timeThreadNeptuno = new Thread(() -> time(600));

// // Iniciar hilos
// combustibleThreadNeptuno.start();
// timeThreadNeptuno.start();

// try {
// // Esperar a que ambos hilos terminen
// combustibleThreadNeptuno.join();
// timeThreadNeptuno.join();
// } catch (InterruptedException e) {
// System.out.println("Error en la simulación del viaje");
// }

// System.out.print(" combustible disponible en la nave ");

// combustible(85);

// System.out.print(" tiempo restante para llegar ");

// time(600);

// break;

// case "pluton":

// Thread combustibleThreadPluton = new Thread(() -> combustible(98));
// Thread timeThreadPluton = new Thread(() -> time(978));

// // Iniciar hilos
// combustibleThreadPluton.start();
// timeThreadPluton.start();

// try {
// // Esperar a que ambos hilos terminen
// combustibleThreadPluton.join();
// timeThreadPluton.join();
// } catch (InterruptedException e) {
// System.out.println("Error en la simulación del viaje");
// }

// System.out.print(" combustible disponible en la nave ");

// combustible(98);

// System.out.print(" tiempo restante para llegar ");

// time(978);
// break;
// default:
// System.out.println(" planeta no valido");
// break;

// }
// }
// }

// // Combustible disponible de la nave
// private static void combustible(double recFuel) {
// for (double i = recFuel; i > 0; i--) {
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

// // // Tiempo de la nave en llegar al planeta
// private static void time(double timeTravel) {

// for (double i = timeTravel; i > 0; i--) {
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