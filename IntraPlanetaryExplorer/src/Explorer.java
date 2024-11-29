/*
 * Dev Senior | Reto 01 - Modulo 01
 * Integrantes:
 * Luis Miguel Triana Rueda
 * Samuel Esteban Rivera Mosquera
 */
package IntraPlanetaryExplorer.src;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
        System.out.printf("Resistencia estructural (int toughness): %d\n", toughness);
        System.out.printf("Fortaleza del escudo: %d\n", shieldStrength);
        System.out.printf("Nivel de energía: %d\n", energyLevel);
        System.out.printf("Nota especial: %s\n", specialNote);
    }
}

public class Explorer {
    private static Planet selectedPlanet;
    private static SpaceShip selectedShip;

    public static List<Planet> getPlanets() {
        List<Planet> planets = List.of(
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
        System.out.print("Iniciando secuencias de carga");
        for (int i = 0; i < 4; i++) {
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.print(".");
        }
        System.out.println("\n¡Listo para el lanzamiento!\n");
    }

    public static void printTime(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        System.out.printf("%s\nFecha y hora actual: %s\n\n", message, now.format(format));
    }

    public static double calculateTravelTime(double distance, int speed) {
        return (speed <= 0) ? Double.MAX_VALUE : distance / speed;
    }
    // Clase Principal y motor del proyecto
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        loadResources();

        System.out.print("Usuario. Por favor, ingresa tu Alias: ");
        String userName = input.nextLine();
        int userId = new Random().nextInt(9000) + 1000;
        printTime("¡Bienvenido a la nave, " + userName +" "+ userId + "!");

        while (true) {
            showMenu();
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1: planetSelector(input); break;
                case 2: shipSelector(input); break;
                case 3: spaceTrip(input); break;
                case 4: settingsManager(input); break;
                case 5: shutDownShip(false); return;
                default: System.out.println("¡OPCIÓN INVALIDA! Elige una opción correcta.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n--- PANEL CENTRAL ---\n");
        System.out.println("1. Planeta de destino.");
        System.out.println("2. Selección de nave.");
        System.out.println("3. Inicio del Viaje.");
        System.out.println("4. Opciones.");
        System.out.println("5. Salir de la nave.");
        System.out.print("\nElige una opción: ");
    }

    public static void planetSelector(Scanner input) {
        List<Planet> planets = getPlanets();
        for (int i = 0; i < planets.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, planets.get(i).getName());
        }

        int choice = input.nextInt() - 1;
        input.nextLine();

        if (choice >= 0 && choice < planets.size()) {
            selectedPlanet = planets.get(choice);
            System.out.printf("Has seleccionado el planeta: %s\n%s", selectedPlanet.getName(), selectedPlanet);
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

        int choice = input.nextInt() - 1;
        input.nextLine();

        if (choice >= 0 && choice < ships.size()) {
            selectedShip = ships.get(choice);
            System.out.printf("Has seleccionado la nave: %s\n", selectedShip.getName());
            selectedShip.showStats();
        } else {
            System.out.println("Selección no válida.");
        }
    }

    public static void spaceTrip(Scanner input) {
        if (selectedPlanet == null || selectedShip == null) {
            System.out.println("Debes seleccionar un planeta y una nave antes de comenzar el viaje.");
            return;
        }

        double distance = selectedPlanet.getEarthDistance();
        double travelTime = calculateTravelTime(distance, selectedShip.getSpeed());
        System.out.printf("La distancia a %s es %.2f millones de km y el tiempo de viaje estimado es %.2f días\n",
                          selectedPlanet.getName(), distance, travelTime);

        if (selectedShip.getFuelCapacity() <= 0 || selectedShip.getToughness() < 50 || selectedShip.getShieldStrength() < 20) {
            System.out.println("¡La nave no está en condiciones óptimas de realizar el viaje!");
            return;
        }

        System.out.println("\nEl viaje ha comenzado...");
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        eventManager(input, selectedShip, selectedPlanet);

        if (selectedShip.getFuelCapacity() <= 0 || selectedShip.getToughness() < 20 || selectedShip.getDamage() > 50) {
            shutDownShip(true);
            System.out.println("¡La nave ha sido dañada en el viaje y se ha apagado!");
        } else {
            printTime("El viaje se ha completado con éxito.");
        }
    }

    public static void settingsManager(Scanner input) {
        while (true) {
            System.out.println("\n--- CONFIGURACIONES ---");
            System.out.println("1. Cambiar nave seleccionada.");
            System.out.println("2. Ver información de la nave actual.");
            System.out.println("3. Ver información del planeta actual.");
            System.out.println("4. Volver al menú principal.");
            System.out.print("\nElige una opción: ");
            
            int option = input.nextInt();
            input.nextLine();
    
            switch (option) {
                case 1: 
                    shipSelector(input); 
                    break;
                case 2:
                    if (selectedShip != null) {
                        selectedShip.showStats();
                    } else {
                        System.out.println("No has seleccionado ninguna nave aún.");
                    }
                    break;
                case 3:
                    if (selectedPlanet != null) {
                        System.out.println(selectedPlanet);
                    } else {
                        System.out.println("No has seleccionado ningún planeta aún.");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("¡Opción inválida! Por favor, selecciona una opción válida.");
            }
        }
    }    

    public static void eventManager(Scanner input, SpaceShip selectedShip, Planet selectedPlanet) {
        Random eventRandom = new Random();
    
        // Evento 1: Perdida de combustible
        if (eventRandom.nextInt(100) < 20) { // 20% de probabilidad
            System.out.println("\n¡Atención! La nave ha perdido parte de su combustible debido a una fuga.\n");
            selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 10);
    
            System.out.println("¿Quieres intentar reparar la fuga? Responde correctamente para sellarla y recuperar combustible.");
            System.out.println("Pregunta: El espacio exterior está lleno de hidrógeno, el gas más común. ¿Sabes cuál es el elemento más abundante en el universo?");
            System.out.println("a) Hidrógeno\nb) Oxígeno\nc) Carbono\nd) Helio");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("a")) {
                System.out.println("¡Correcto! Has sellado la fuga y recuperado 8 unidades de combustible.");
                selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() + 8);
            } else {
                System.out.println("Respuesta incorrecta. La fuga no pudo ser sellada.");
            }
        }
    
        // Evento 2: Falla electrónica
        if (eventRandom.nextInt(100) < 25) {
            System.out.println("\n¡Interferencia electromagnética detectada! Los sistemas de navegación están inestables.\n");
            selectedShip.setGravityControl(selectedShip.getGravityControl() - 10);
    
            System.out.println("¿Quieres intentar estabilizar los sistemas? Responde correctamente para restaurar el control.");
            System.out.println("Pregunta: Los primeros astronautas dependieron de su GPS para navegar en la órbita. ¿En qué año aterrizó el primer humano en la Luna?");
            System.out.println("a) 1965\nb) 1969\nc) 1972\nd) 1975");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("b")) {
                System.out.println("¡Correcto! Has estabilizado los sistemas y restaurado el control de gravedad.");
                selectedShip.setGravityControl(selectedShip.getGravityControl() + 10);
            } else {
                System.out.println("Respuesta incorrecta. Los sistemas siguen inestables.");
            }
        }
    
        // Evento 3: Sobrecaliento del motor
        if (eventRandom.nextInt(100) < 30) {
            System.out.println("\n¡Alerta! El motor está sobrecalentado debido a las altas temperaturas espaciales.\n");
            selectedShip.setDamage(selectedShip.getDamage() + 5);
    
            System.out.println("¿Quieres intentar enfriar el motor? Responde correctamente para reducir el daño.");
            System.out.println("Pregunta: Marte, el Planeta Rojo, ha sido nuestro objetivo para misiones. ¿Qué planeta del Sistema Solar es conocido como el 'Planeta Rojo'?");
            System.out.println("a) Marte\nb) Venus\nc) Júpiter\nd) Saturno");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("a")) {
                System.out.println("¡Correcto! Has enfriado el motor y reducido el daño en 3 unidades.");
                selectedShip.setDamage(selectedShip.getDamage() - 3);
            } else {
                System.out.println("Respuesta incorrecta. El motor sigue sobrecalentado.");
                shutDownShip(true);
            }
        }
    
        // Evento 4: Daño adicional
        if (eventRandom.nextInt(100) < 15) {
            System.out.println("\n¡Un meteorito ha impactado la nave! La nave ha sufrido daño adicional.\n");
            selectedShip.setDamage(selectedShip.getDamage() + 10);
            if (selectedShip.getDamage() > 50) {
                shutDownShip(true);
            }
        }
    
        // Evento 5: Advertencia
        if (eventRandom.nextInt(100) < 45) {
            System.out.println("\n¡Fragmentos de roca en el espacio detectados! Ten cuidado de no perder provisiones.\n");
        }
    
        // Evento 6: Colisión de micro-asteroides
        if (eventRandom.nextInt(100) < 10) {
            System.out.println("\n¡Colisión con micro-asteroides! El casco de la nave ha sido dañado.\n");
            selectedShip.setDamage(selectedShip.getDamage() + 8);
            selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 3);
            if (selectedShip.getDamage() > 60) {
                shutDownShip(true);
            }
        }
    
        // Evento 7: Radiación espacial
        if (eventRandom.nextInt(100) < 12) { 
            System.out.println("\n¡Tormenta de radiación espacial! Los escudos han sido debilitados.\n");
            selectedShip.setToughness(selectedShip.getToughness() - 5);
        }
    
        // Evento 8: Baja generación de energía en planetas alejados
        if (selectedPlanet.getEarthDistance() > 4000 && eventRandom.nextInt(100) < 20) {
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
        }
    
        // Evento 9: Peligros por anillos del planeta (solo si tiene anillos)
        if (selectedPlanet.hasRingSystem() && eventRandom.nextInt(100) < 20) {
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
        }
    
        // Evento 10: Nave demasiado pesada para el viaje
        if ((selectedShip.getToughness() > 90 || selectedShip.getCargoCapacity() > 350) && selectedPlanet.getEarthDistance() < 1000 && eventRandom.nextInt(100) < 15) {
            System.out.println("\n¡Advertencia! La nave es demasiado robusta para realizar un viaje eficiente a un planeta cercano como el tuyo.\n");
            System.out.println("La nave está perdiendo mucha velocidad debido a su tamaño y peso. Responde correctamente para optimizar la propulsión.");
            System.out.println("Pregunta: ¿Cuál es el principal factor que afecta la velocidad de una nave espacial?");
            System.out.println("a) Gravedad\nb) Combustible\nc) Resistencia del material\nd) Tamaño de la nave");
    
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("d")) {
                System.out.println("¡Correcto! Has ajustado la nave y mejorado la eficiencia.");
            } else {
                System.out.println("Respuesta incorrecta. La nave sigue perdiendo velocidad.");
            }
        }
    
        // Evento 11: Nave frágil para un viaje largo
        if ((selectedShip.getToughness() < 40) && selectedPlanet.getEarthDistance() > 4000 && eventRandom.nextInt(100) < 15) {
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
        }
    }
    
    public static void shutDownShip(boolean isEmergency) {
        if (isEmergency) {
            System.out.print("¡Emergencia! La nave se está apagando por condiciones inestables.");
            for (int i = 0; i < 4; i++) {
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.print(".");
            }
            printTime("\n¡Haz fallado en tu viaje!\n");
        } else {
            System.out.print("Apagando la nave de manera segura.");
            for (int i = 0; i < 4; i++) {
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.print(".");
            }
            printTime("\n¡Sistemas apagados con exito!\n");
        }
        System.exit(0);
    }
}
