/*
 * Dev Senior | Reto 01 - Modulo 01
 * Integrantes:
 * Luis Miguel Triana Rueda
 * Samuel Esteban Rivera Mosquera
 */
package IntraPlanetaryExplorer.src;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Planet {
    private final String name;
    private final double earthDistance, timeTravel, recFuel;
    private final boolean ringSystem;

    public Planet(String name, double earthDistance, double timeTravel, double recFuel, boolean ringSystem) {
        this.name = name;
        this.earthDistance = earthDistance;
        this.timeTravel = timeTravel;
        this.recFuel = recFuel;
        this.ringSystem = ringSystem;
    }

    public String getName() {return name;}
    public double getEarthDistance() {return earthDistance;}
    public double getTimeTravel() {return timeTravel;}
    public double getRecFuel() {return recFuel;}
    public boolean hasRingSystem() {return ringSystem;}

    @Override
    public String toString() {
        return String.format(
                "Planeta: %s\nDistancia desde la tierra: %.2f millones de km\nTiempo de viaje: %.2f días\n" +
                        "Combustible recomendado: %.2f%%\nTiene anillos: %s\n",
                name, earthDistance, timeTravel, recFuel, ringSystem ? "Sí" : "No");
    }
}

class SpaceShip {
    private String name;
    private int fuelCapacity, speed, cargoCapacity, toughness, shieldStrength, energyLevel, gravityControl, damage;
    private String specialNote;

    public SpaceShip(String name, int fuelCapacity, int speed, int cargoCapacity, int toughness, int shieldStrength, int energyLevel, int gravityControl, int damage, String specialNote) {
        this.name = name;
        this.fuelCapacity = fuelCapacity;
        this.speed = speed;
        this.cargoCapacity = cargoCapacity;
        this.toughness = toughness;
        this.shieldStrength = shieldStrength;
        this.energyLevel = energyLevel;
        this.gravityControl = gravityControl;
        this.damage = damage;
        this.specialNote = specialNote;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getFuelCapacity() {return fuelCapacity;}
    public void setFuelCapacity(int fuelCapacity) {this.fuelCapacity = fuelCapacity;}
    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}
    public int getCargoCapacity() {return cargoCapacity;}
    public void setCargoCapacity(int cargoCapacity) {this.cargoCapacity = cargoCapacity;}
    public int getToughness() {return toughness;}
    public void setToughness(int toughness) {this.toughness = toughness;}
    public int getShieldStrength() {return shieldStrength;}
    public void setShieldStrength(int shieldStrength) {this.shieldStrength = shieldStrength;}
    public int getEnergyLevel() {return energyLevel;}
    public void setEnergyLevel(int energyLevel) {this.energyLevel = energyLevel;}
    public int getGravityControl() {return gravityControl;}
    public void setGravityControl(int gravityControl) {this.gravityControl = gravityControl;    }
    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage = damage;}
    public String getSpecialNote() {return specialNote;}
    public void setSpecialNote(String specialNote) {this.specialNote = specialNote;}    

    public void showStats() {
        System.out.printf("Nombre: %s\n", name);
        System.out.printf("Capacidad de combustible: %d\n", fuelCapacity);
        System.out.printf("Velocidad: %d\n", speed);
        System.out.printf("Capacidad de carga: %d\n", cargoCapacity);
        System.out.printf("Resistencia estructural: %d\n", toughness);
        System.out.printf("Fortaleza del escudo: %d\n", shieldStrength);
        System.out.printf("Nivel de energía: %d\n", energyLevel);
        System.out.printf("Nota especial: %s\n", specialNote);
    }
}

public class Explorer {
    private static Planet selectedPlanet;
    private static SpaceShip selectedShip;

    public static List<Planet> getPlanets() {
        var planets = List.of(
            new Planet("Mercurio", 77, 26, 16, false),
            new Planet("Venus", 41, 15, 13, false),
            new Planet("Marte", 78, 89.6, 20, false),
            new Planet("Ceres", 413, 130, 22, false),
            new Planet("Júpiter", 628, 160.7, 45, true),
            new Planet("Saturno", 1275, 320, 56, true),
            new Planet("Urano", 2724, 450, 78, true),
            new Planet("Neptuno", 4351, 600, 85, true),
            new Planet("Haumea", 635, 800, 48, false),
            new Planet("Makemake", 1420, 1200, 65, false),
            new Planet("Plutón", 5906, 978, 98, false),
            new Planet("Eris", 9630, 1600, 90, false)
        );
        return planets; 
    }

    public static void loadResources() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        System.out.print("Iniciando secuencias de carga");
        
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
    }
    
    public static void printTime(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        
        System.out.printf("\n%s\n", message);
        System.out.println("Fecha y hora actual de la nave:");
        System.out.println(now.format(format) + "\n");
    }

    public static double calculateTravelTime(double distance, int speed) {
        return (speed <= 0) ? Double.MAX_VALUE : distance / speed;
    }
    
    private static int generateUserId() {
        return new Random().nextInt(9000) + 1000;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        loadResources();
    
        System.out.println("\nBienvenido a bordo. Por favor, ingresa tu Alias de Comandante: ");
        var userName = input.nextLine();
    
        int userCode = generateUserId();
        var userId = userName + "-" + userCode;
    
        printTime("¡Bienvenido a la base, comandante " + userId + "!");
        
        System.out.println("Los sistemas están en pleno funcionamiento, listos para la exploración.");
        System.out.print("Cargando panel de misión");
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        List<Planet> availablePlanets = getPlanets();
    
        while (true) {
            showMenu();
            var option = getValidOption(input, 5);
    
            switch (option) {
                case 1:planetSelector(input);break;
                case 2:shipSelector(input);break;
                case 3:settingsManager(input, availablePlanets);break;
                case 4:spaceTrip(input);break;
                case 5:shutDownShip(false);return;
                default:System.out.println("¡OPCIÓN INVÁLIDA! Elige una opción válida.");
            }
        }
    }

    private static int getValidOption(Scanner input, int maxOption) {
        int option = -1;
        while (option < 1 || option > maxOption) {
            System.out.print("Selecciona una opción (1 a " + maxOption + "): ");
            try {
                option = Integer.parseInt(input.nextLine().trim());
                if (option < 1 || option > maxOption) {
                    System.out.println("Opción no válida. Por favor, ingresa un número entre 1 y " + maxOption + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número.");
            }
        }
        return option;
    }

    public static void showMenu() {
        System.out.println("\n--- PANEL CENTRAL ---\n");
        System.out.println("1. Planeta de destino.");
        System.out.println("2. Selección de nave.");
        System.out.println("3. Opciones.");
        System.out.println("4. Inicio del Viaje.");
        System.out.println("5. Salir de la nave.");
        System.out.print("\nElige una opción: ");
    }

    public static void planetSelector(Scanner input) {
        List<Planet> planets = getPlanets();
        for (int i = 0; i < planets.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, planets.get(i).getName());
        }

        var choice = input.nextInt() - 1;
        input.nextLine();

        if (choice >= 0 && choice < planets.size()) {
            selectedPlanet = planets.get(choice);
            System.out.printf("\nHas seleccionado el planeta: %s\n%s", selectedPlanet.getName(), selectedPlanet);
        } else {
            System.out.println("Selección no válida.");
        }
    }

    public static void shipSelector(Scanner input) {
        List<SpaceShip> ships = List.of(
            new SpaceShip("Odyssey", 7000, 100, 300, 95, 60, 80, 0, 40, "Nave robusta y rápida, ideal para explorar planetas cercanos como Mercurio, Venus y Marte.\nResistencia y velocidad adecuadas para misiones cortas y medias."),
            new SpaceShip("LightStar", 6000, 180, 350, 80, 50, 70, 0, 30, "Nave ligera y ágil, perfecta para viajar a Ceres, Júpiter y Saturno.\nAlta velocidad y maniobrabilidad para misiones rápidas."),
            new SpaceShip("Nucleus", 8000, 150, 300, 100, 80, 100, 0, 50, "Nave resistente y de alta capacidad, diseñada para explorar Urano, Neptuno y Haumea.\nIdeal para viajes prolongados y condiciones adversas."),
            new SpaceShip("Apollo", 9000, 60, 200, 100, 90, 120, 0, 60, "Nave resistente y bien protegida, adecuada para explorar los planetas más lejanos como Makemake, Plutón y Eris.\nDiseñada para soportar largos viajes y condiciones extremas.")
        );

        for (int i = 0; i < ships.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, ships.get(i).getName());
            System.out.printf("   %s\n", ships.get(i).getSpecialNote());
        }

        var choice = input.nextInt() - 1;
        input.nextLine();

        if (choice >= 0 && choice < ships.size()) {
            selectedShip = ships.get(choice);
            System.out.printf("\nHas seleccionado la nave: %s\n", selectedShip.getName());
            selectedShip.showStats();
        } else {
            System.out.println("Selección no válida.");
        }
    }

    public static void settingsManager(Scanner input, List<Planet> availablePlanets) {
        while (true) {
            System.out.println("\n--- CONFIGURACIONES ---");
            System.out.println("1. Cambiar planeta actual.");
            System.out.println("2. Cambiar nave seleccionada.");
            System.out.println("3. Ver información del planeta actual.");
            System.out.println("4. Ver información de la nave actual.");
            System.out.println("5. Volver al menú principal.");
            System.out.print("\nElige una opción: ");

            int option = getValidOption(input, 5);

            switch (option) {
                case 1:changeSelectedPlanet(input, availablePlanets);break;
                case 2:shipSelector(input);break;
                case 3:showSelectedPlanetInfo();break;
                case 4:showSelectedShipInfo();break;
                case 5:return;
                default:System.out.println("¡Opción inválida! Por favor, selecciona una opción válida.");
            }
        }
    }

    private static void showSelectedShipInfo() {
        if (selectedShip != null) {
            selectedShip.showStats();
        } else {
            System.out.println("No has seleccionado ninguna nave.");
        }
    }

    private static void showSelectedPlanetInfo() {
        if (selectedPlanet != null) {
            System.out.println(selectedPlanet);
        } else {
            System.out.println("No has seleccionado ningún planeta.");
        }
    }

    private static void changeSelectedPlanet(Scanner input, List<Planet> availablePlanets) {
        System.out.println("\n--- CAMBIO DE PLANETA ---");
        for (int i = 0; i < availablePlanets.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, availablePlanets.get(i).getName());
        }

        System.out.print("\nSelecciona un nuevo planeta: ");
        int newPlanetChoice = getValidOption(input, availablePlanets.size()) - 1;

        if (newPlanetChoice >= 0 && newPlanetChoice < availablePlanets.size()) {
            selectedPlanet = availablePlanets.get(newPlanetChoice);
            System.out.printf("\nAhora el planeta seleccionado es: %s\n", selectedPlanet.getName());
        } else {
            System.out.println("Selección no válida.");
        }
    }

    public static void spaceTrip(Scanner input) {
        if (selectedPlanet == null || selectedShip == null) {
            System.out.println("Debes seleccionar un planeta y una nave antes de comenzar el viaje.");
            return;
        }
    
        var distance = selectedPlanet.getEarthDistance();
        var travelTime = calculateTravelTime(distance, selectedShip.getSpeed());
        System.out.printf("La distancia a %s es %.2f millones de km y el tiempo de viaje estimado es %.2f días\n",
                          selectedPlanet.getName(), distance, travelTime);
    
        if (selectedShip.getFuelCapacity() <= 0 || selectedShip.getToughness() < 50 || selectedShip.getShieldStrength() < 20) {
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
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
    
        double distanceTraveled = 0;
        double elapsedDays = 0;
    
        Set<String> eventHistory = new HashSet<>();
    
        while (distanceTraveled < distance) {
            distanceTraveled += selectedShip.getSpeed() * 0.1;
            
            if (distanceTraveled > distance) {
                distanceTraveled = distance;
            }
    
            elapsedDays += 0.1;
    
            showState(distanceTraveled, distance, elapsedDays, travelTime, null, input);
    
            eventManager(input, selectedShip, selectedPlanet, eventHistory);
    
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    
            if (selectedShip.getFuelCapacity() <= 0 || selectedShip.getToughness() < 20 || selectedShip.getDamage() > 50) {
                shutDownShip(true);
                System.out.println("¡La nave ha sido dañada en el viaje y se ha apagado!");
                return;
            }
        }
    
        printTime("El viaje se ha completado con éxito.");
    }
    
    public static void showState(double distanceTraveled, double totalDistance, double elapsedDays, double totalTravelTime, String userId, Scanner input) {
        System.out.println("\n--- PANEL DE CONTROL ---");
        System.out.println("COMANDANTE " + (userId != null ? userId : ""));
    
        double progressPercentage = (distanceTraveled / totalDistance) * 100;
        if (progressPercentage > 100) {
            progressPercentage = 100;
        }
    
        System.out.printf("- Progreso del Viaje: %.2f%%\n", progressPercentage);
        System.out.printf("- Distancia Recorrida: %.2f millones de km / %.2f millones de km\n", distanceTraveled, totalDistance);
    
        System.out.println("\n--- RECURSOS ---");
        System.out.printf("- Combustible: %d\n", selectedShip.getFuelCapacity());
        System.out.printf("- Energía: %d\n", selectedShip.getEnergyLevel());
        System.out.printf("- Daño actual: %d\n", selectedShip.getDamage());
    
        System.out.println("\n--- TIEMPO ---");
        System.out.printf("Tiempo Transcurrido: %.2f días\n", elapsedDays);
        double remainingDays = totalTravelTime - elapsedDays;
        System.out.printf("Tiempo Restante: %.2f días\n", remainingDays);
    
        System.out.println("\n--- ESTADO DE LA NAVE ---");
        String shipStatus = (selectedShip.getFuelCapacity() <= 0 || selectedShip.getToughness() < 20 || selectedShip.getDamage() > 50)
                            ? "NAVE EN PELIGRO" : "NAVE EN BUEN ESTADO";
        System.out.println("Estado de la nave: " + shipStatus);
    
        System.out.println("\n--- BARRA DE PROGRESO ---");
        printProgressBar(progressPercentage);
    
        System.out.println("\n--- MANTENTE ALERTA " + (userId != null ? userId : "") + " ---");
    }
    
    public static void printProgressBar(double percentage) {
        int barWidth = 40;
        int progress = (int) (percentage / 2);
    
        StringBuilder progressBar = new StringBuilder("[");
    
        for (int i = 0; i < barWidth; i++) {
            if (i < progress) {
                progressBar.append("=");
            } else {
                progressBar.append(" ");
            }
        }
        progressBar.append("]");
    
        System.out.print("\r" + progressBar.toString() + " " + String.format("%.2f%%", percentage));
    
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void eventManager(Scanner input, SpaceShip selectedShip, Planet selectedPlanet, Set<String> eventHistory) {
        var eventRandom = new Random();
    
        // Evento 1: Perdida de combustible
        if (eventRandom.nextInt(100) < 20 && !eventHistory.contains("fuelLeak")) {
            System.out.println("\n¡Atención! La nave ha perdido parte de su combustible debido a una fuga.\n");
            selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 10);
    
            System.out.println("¿Quieres intentar reparar la fuga? Responde correctamente para sellarla y recuperar combustible.");
            System.out.println("Pregunta: El espacio exterior está lleno de hidrógeno, el gas más común. ¿Sabes cuál es el elemento más abundante en el universo?");
            System.out.println("a) Hidrógeno\nb) Oxígeno\nc) Carbono\nd) Helio");
    
            var answer = input.nextLine().toLowerCase();
            if (answer.equals("a")) {
                System.out.println("¡Correcto! Has sellado la fuga y recuperado 8 unidades de combustible.");
                selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() + 8);
            } else {
                System.out.println("Respuesta incorrecta. La fuga no pudo ser sellada.");
            }
    
            eventHistory.add("fuelLeak");
        }
    
        // Evento 2: Falla electrónica
        if (eventRandom.nextInt(100) < 25 && !eventHistory.contains("electronicFailure")) {
            System.out.println("\n¡Interferencia electromagnética detectada! Los sistemas de navegación están inestables.\n");
            selectedShip.setGravityControl(selectedShip.getGravityControl() - 10);
    
            System.out.println("¿Quieres intentar estabilizar los sistemas? Responde correctamente para restaurar el control.");
            System.out.println("Pregunta: ¿Qué sistema es más crítico para restaurar el control de una nave espacial durante una interferencia electromagnética?");
            System.out.println("a) GPS de la nave\nb) Sistema de control de gravedad\nc) Motor de propulsión\nd) Generador de energía");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("b")) {
                System.out.println("¡Correcto! Has estabilizado los sistemas y restaurado el control de gravedad.");
                selectedShip.setGravityControl(selectedShip.getGravityControl() + 10);
            } else {
                System.out.println("Respuesta incorrecta. Los sistemas siguen inestables.");
            }
    
            eventHistory.add("electronicFailure");
        }
    
        // Evento 3: Sobrecaliento del motor
        if (eventRandom.nextInt(100) < 30 && !eventHistory.contains("engineOverheat")) {
            System.out.println("\n¡Alerta! El motor está sobrecalentado debido a las altas temperaturas espaciales.\n");
            selectedShip.setDamage(selectedShip.getDamage() + 5);
    
            System.out.println("¿Quieres intentar enfriar el motor? Responde correctamente para reducir el daño.");
            System.out.println("Pregunta: ¿Cuál es el principal método utilizado para enfriar los motores de las naves espaciales durante largos viajes?");
            System.out.println("a) Radiadores de líquido\nb) Radiación infrarroja\nc) Enfriamiento por evaporación\nd) Dispositivos de absorción de calor");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("a")) {
                System.out.println("¡Correcto! Has enfriado el motor y reducido el daño en 3 unidades.");
                selectedShip.setDamage(selectedShip.getDamage() - 3);
            } else {
                System.out.println("Respuesta incorrecta. El motor sigue sobrecalentado.");
                shutDownShip(true);
            }
    
            eventHistory.add("engineOverheat");
        }
    
        // Evento 4: Daño adicional
        if (eventRandom.nextInt(100) < 15 && !eventHistory.contains("meteorImpact")) {
            System.out.println("\n¡Un meteorito ha impactado la nave! La nave ha sufrido daño adicional.\n");
            selectedShip.setDamage(selectedShip.getDamage() + 10);
            if (selectedShip.getDamage() > 50) {
                shutDownShip(true);
            }
    
            eventHistory.add("meteorImpact");
        }
    
        // Evento 5: Advertencia
        if (eventRandom.nextInt(100) < 45 && !eventHistory.contains("spaceDebrisWarning")) {
            System.out.println("\n¡Fragmentos de roca en el espacio detectados! Ten cuidado de no perder provisiones.\n");
    
            eventHistory.add("spaceDebrisWarning");
        }
    
        // Evento 6: Colisión de micro-asteroides
        if (eventRandom.nextInt(100) < 10 && !eventHistory.contains("microAsteroidCollision")) {
            System.out.println("\n¡Colisión con micro-asteroides! El casco de la nave ha sido dañado.\n");
            selectedShip.setDamage(selectedShip.getDamage() + 8);
            selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 3);
            if (selectedShip.getDamage() > 60) {
                shutDownShip(true);
            }

            eventHistory.add("microAsteroidCollision");
        }
    
        // Evento 7: Radiación espacial
        if (eventRandom.nextInt(100) < 12 && !eventHistory.contains("spaceRadiation")) { 
            System.out.println("\n¡Tormenta de radiación espacial! Los escudos han sido debilitados.\n");
            selectedShip.setToughness(selectedShip.getToughness() - 5);
    
            eventHistory.add("spaceRadiation");
        }
        // Evento 8: Sistema de energía
        if (selectedPlanet.getEarthDistance() > 4000 && eventRandom.nextInt(100) < 20 && !eventHistory.contains("energyGenerationIssue")) {
            System.out.println("\n¡Alerta! La nave está experimentando dificultades para generar energía debido a la distancia del Sol.\n");
            selectedShip.setEnergyLevel(selectedShip.getEnergyLevel() - 5);
    
            System.out.println("¿Quieres intentar optimizar el sistema de energía? Responde correctamente para restaurar la generación.");
            System.out.println("Pregunta: El Sol es la fuente primaria de energía para la vida en la Tierra. ¿Cuál es el principal componente del Sol?");
            System.out.println("a) Helio\nb) Oxígeno\nc) Hidrógeno\nd) Carbono");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("c")) {
                System.out.println("¡Correcto! Has optimizado el sistema de energía y restaurado la generación.");
                selectedShip.setEnergyLevel(selectedShip.getEnergyLevel() + 5);
            } else {
                System.out.println("Respuesta incorrecta. La generación de energía sigue reducida.");
            }

            eventHistory.add("energyGenerationIssue");
        }
    
        // Evento 9: Peligros por anillos del planeta (solo si tiene anillos)
        if (selectedPlanet.hasRingSystem() && eventRandom.nextInt(100) < 20 && !eventHistory.contains("planetRingsDanger")) {
            System.out.println("\n¡Peligro! Estás acercándote a un planeta con anillos. Los fragmentos pueden dañar la nave.\n");
            System.out.println("Debes realizar maniobras evasivas para evitar daños. Responde correctamente para maniobrar con éxito.");
            System.out.println("Pregunta: ¿Qué acción debes tomar al acercarte a un anillo de partículas?");
            System.out.println("a) Aumentar la velocidad\nb) Disminuir la velocidad\nc) Mantener el rumbo\nd) Evadir a izquierda");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("b")) {
                System.out.println("¡Correcto! Has maniobrado con éxito y evitado el daño de los anillos.");
            } else {
                System.out.println("Respuesta incorrecta. La nave ha sufrido daños menores por los anillos.");
                selectedShip.setDamage(selectedShip.getDamage() + 5);
                if (selectedShip.getDamage() > 50) {
                    shutDownShip(true);
                }
            }
    
            eventHistory.add("planetRingsDanger");
        }
    
        // Evento 10: Nave demasiado pesada para el viaje
        if ((selectedShip.getToughness() > 90 || selectedShip.getCargoCapacity() > 350) && selectedPlanet.getEarthDistance() < 1000 && eventRandom.nextInt(100) < 15 && !eventHistory.contains("overweightShip")) {
            System.out.println("\n¡Advertencia! La nave es demasiado robusta para realizar un viaje eficiente a un planeta cercano como el tuyo.\n");
            System.out.println("La nave está perdiendo mucha velocidad debido a su tamaño y peso. Responde correctamente para optimizar la propulsión.");
            System.out.println("Pregunta: ¿Cuál es el principal factor que afecta la velocidad de una nave espacial?");
            System.out.println("a) Gravedad\nb) Combustible\nc) Resistencia del material\nd) Tamaño de la nave");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("d")) {
                System.out.println("¡Correcto! Has ajustado la nave y mejorado la eficiencia.");
            } else {
                System.out.println("Respuesta incorrecta. La nave sigue perdiendo velocidad.");
        
                int newSpeed = (int) Math.round(selectedShip.getSpeed() * 0.9);
                selectedShip.setSpeed(newSpeed);
                System.out.println("La velocidad máxima de la nave ha disminuido a " + newSpeed + " km/día.");
            }

            eventHistory.add("overweightShip");
        }
    
        // Evento 11: Nave frágil para un viaje largo
        if ((selectedShip.getToughness() < 40) && selectedPlanet.getEarthDistance() > 4000 && eventRandom.nextInt(100) < 15 && !eventHistory.contains("fragileShip")) {
            System.out.println("\n¡Alerta! La nave es demasiado frágil para afrontar las duras condiciones de este viaje largo.\n");
            System.out.println("¡Riesgo de daños mayores si no refuerzas los escudos o la estructura!");
            System.out.println("Pregunta: ¿Qué sistema debe reforzarse al viajar en condiciones extremas?");
            System.out.println("a) Motor\nb) Estructura\nc) Navegación\nd) Energía");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("b")) {
                System.out.println("¡Correcto! Has reforzado la nave y reducido el riesgo de daños.");
            } else {
                System.out.println("Respuesta incorrecta. La nave sigue siendo vulnerable.");
                selectedShip.setDamage(selectedShip.getDamage() + 10);
            }
    
            eventHistory.add("fragileShip");
        }
    }
    
    public static void shutDownShip(boolean isEmergency) {
        if (isEmergency) {
            System.out.println("\n¡ALERTA! ¡EMERGENCIA EN LA NAVE!");
            System.out.println("Los sistemas de la nave se están apagando debido a condiciones inestables.");
            System.out.print("¡Intentando activar protocolos de seguridad! Preparándose para el apagado de emergencia");
            
            for (int i = 0; i < 4; i++) {
                try { 
                    Thread.sleep(1000); 
                } catch (InterruptedException e) { 
                    e.printStackTrace(); 
                }
                System.out.print(".");
            }
    
            System.out.println("\n--- SISTEMAS FALLIDOS ---");
            System.out.println("¡La nave ha perdido comunicación con la base!");
            System.out.println("¡Haz fallado en tu misión de exploración!");
    
            printTime("\nEl viaje ha terminado abruptamente.\n--- MISIÓN FALLIDA ---\n");
    
        } else {
            System.out.println("\nIniciando apagado seguro de la nave.");
            System.out.print("Procedimiento iniciado: Desactivando sistemas de a bordo");
            
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
    
            System.out.println("\n--- SISTEMAS APAGADOS ---");
            System.out.println("La nave se ha apagado correctamente, todos los sistemas han sido desactivados.");
            printTime("\nProcedimiento completado con éxito.\n");
        }
    
        System.exit(0);
    }
}
