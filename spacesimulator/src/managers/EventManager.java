package managers;

import java.util.*;

import models.Event;
import models.EventContext;
import models.Planet;
import models.SpaceShip;
import utils.TimeUtil;

public class EventManager {

    private static final List<Event> events = new ArrayList<>();

    public static void triggerEvents(Scanner input, SpaceShip ship, Planet planet, Set<String> eventHistory) {
        EventContext context = new EventContext(eventHistory);
        Object[] args = new Object[] { input, ship, planet };

        Random random = new Random();

        for (Event event : events) {
            if (random.nextInt(100) < event.getProbability() && !context.hasOccurred(event.getName())) {
                event.trigger(args, context);
            }
        }
    }

    public static void registerEvents() {
        // Evento 1: Fuga de combustible
        events.add(new Event("fuelLeak", 20, (args, context) -> {
            Scanner input = (Scanner) args[0];
            SpaceShip ship = (SpaceShip) args[1];

            System.out.println("\n¡Atención! La nave ha perdido parte de su combustible debido a una fuga.\n");
            ship.setFuelCapacity(ship.getFuelCapacity() - 10);

            System.out.println(
                    "¿Quieres intentar reparar la fuga? Responde correctamente para sellarla y recuperar combustible.");
            System.out.println(
                    "Pregunta: El espacio exterior está lleno de hidrógeno. ¿Cuál es el elemento más abundante en el universo?");
            System.out.println("a) Hidrógeno\nb) Oxígeno\nc) Carbono\nd) Helio");

            var answer = input.nextLine().toLowerCase();
            if (answer.equals("a")) {
                System.out.println("¡Correcto! Has sellado la fuga y recuperado 8 unidades de combustible.");
                ship.setFuelCapacity(ship.getFuelCapacity() + 8);
            } else {
                System.out.println("Respuesta incorrecta. La fuga no pudo ser sellada.");
            }

            context.markAsOccurred("fuelLeak");
        }));

        // Evento 2: Falla electrónica
        events.add(new Event("electronicFailure", 25, (args, context) -> {
            Scanner input = (Scanner) args[0];
            SpaceShip ship = (SpaceShip) args[1];

            System.out.println(
                    "\n¡Interferencia electromagnética detectada! Los sistemas de navegación están inestables.\n");
            ship.setGravityControl(ship.getGravityControl() - 10);

            System.out.println("¿Quieres intentar estabilizar los sistemas? Responde correctamente.");
            System.out.println(
                    "Pregunta: ¿Qué sistema es más crítico para restaurar el control durante una interferencia electromagnética?");
            System.out.println(
                    "a) GPS de la nave\nb) Sistema de control de gravedad\nc) Motor de propulsión\nd) Generador de energía");

            var answer = input.nextLine().toLowerCase();
            if (answer.equals("b")) {
                System.out.println("¡Correcto! Has restaurado el control de gravedad.");
                ship.setGravityControl(ship.getGravityControl() + 10);
            } else {
                System.out.println("Respuesta incorrecta. Los sistemas siguen inestables.");
            }

            context.markAsOccurred("electronicFailure");
        }));

        // Evento 3: Sobrecalentamiento del motor
        events.add(new Event("engineOverheat", 30, (args, context) -> {
            Scanner input = (Scanner) args[0];
            SpaceShip ship = (SpaceShip) args[1];

            System.out.println("\n¡Alerta! El motor está sobrecalentado.\n");
            ship.setDamage(ship.getDamage() + 5);

            System.out.println("¿Quieres intentar enfriar el motor?");
            System.out.println("Pregunta: ¿Cuál es el principal método para enfriar motores espaciales?");
            System.out.println(
                    "a) Radiadores de líquido\nb) Radiación infrarroja\nc) Evaporación\nd) Absorción de calor");

            var answer = input.nextLine().toLowerCase();
            if (answer.equals("a")) {
                System.out.println("¡Correcto! Has reducido el daño en 3 unidades.");
                ship.setDamage(ship.getDamage() - 3);
            } else {
                System.out.println("Respuesta incorrecta. El motor sigue sobrecalentado.");
                shutDownShip(true);
            }

            context.markAsOccurred("engineOverheat");
        }));
        // Evento 4: Daño adicional por impacto de meteorito
        events.add(new Event("meteorImpact", 15, (args, context) -> {
            SpaceShip ship = (SpaceShip) args[1];
            System.out.println("\n¡Un meteorito ha impactado la nave! Daño adicional sufrido.");
            ship.setDamage(ship.getDamage() + 10);
            if (ship.getDamage() > 50) {
                shutDownShip(true);
            }
            context.markAsOccurred("meteorImpact");
        }));

        // Evento 5: Advertencia por escombros espaciales
        events.add(new Event("spaceDebrisWarning", 45, (args, context) -> {
            System.out.println("\n¡Advertencia! Fragmentos espaciales detectados. Precaución al navegar.");
            context.markAsOccurred("spaceDebrisWarning");
        }));

        // Evento 6: Colisión con micro-asteroides
        events.add(new Event("microAsteroidCollision", 10, (args, context) -> {
            SpaceShip ship = (SpaceShip) args[1];
            System.out.println("\n¡Colisión con micro-asteroides! Daño y pérdida de combustible.");
            ship.setDamage(ship.getDamage() + 8);
            ship.setFuelCapacity(ship.getFuelCapacity() - 3);
            if (ship.getDamage() > 60) {
                shutDownShip(true);
            }
            context.markAsOccurred("microAsteroidCollision");
        }));

        // Evento 7: Radiación espacial
        events.add(new Event("spaceRadiation", 12, (args, context) -> {
            SpaceShip ship = (SpaceShip) args[1];
            System.out.println("\n¡Tormenta de radiación espacial! Escudos debilitados.");
            ship.setToughness(ship.getToughness() - 5);
            context.markAsOccurred("spaceRadiation");
        }));

        // Evento 8: Problemas de generación de energía
        events.add(new Event("energyGenerationIssue", 20, (args, context) -> {
            Scanner input = (Scanner) args[0];
            SpaceShip ship = (SpaceShip) args[1];
            Planet planet = (Planet) args[2];

            if (planet.getEarthDistance() <= 4000)
                return;

            System.out.println("\n¡Dificultades para generar energía por la lejanía del Sol!");
            ship.setEnergyLevel(ship.getEnergyLevel() - 5);

            System.out.println("¿Intentar optimizar el sistema de energía?");
            System.out.println("Pregunta: ¿Cuál es el principal componente del Sol?");
            System.out.println("a) Helio\nb) Oxígeno\nc) Hidrógeno\nd) Carbono");

            var answer = input.nextLine().toLowerCase();
            if (answer.equals("c")) {
                System.out.println("¡Correcto! Generación de energía restaurada.");
                ship.setEnergyLevel(ship.getEnergyLevel() + 5);
            } else {
                System.out.println("Incorrecto. El sistema sigue ineficiente.");
            }

            context.markAsOccurred("energyGenerationIssue");
        }));

        // Evento 9: Riesgo por anillos del planeta
        events.add(new Event("planetRingsDanger", 20, (args, context) -> {
            Scanner input = (Scanner) args[0];
            SpaceShip ship = (SpaceShip) args[1];
            Planet planet = (Planet) args[2];

            if (!planet.hasRingSystem())
                return;

            System.out.println("\n¡Cuidado! Anillos planetarios detectados.");
            System.out.println("Pregunta: ¿Qué acción tomar al acercarse a un anillo de partículas?");
            System.out
                    .println("a) Aumentar velocidad\nb) Disminuir velocidad\nc) Mantener rumbo\nd) Evadir a izquierda");

            var answer = input.nextLine().toLowerCase();
            if (answer.equals("b")) {
                System.out.println("¡Correcto! Maniobra exitosa.");
            } else {
                System.out.println("Incorrecto. Daño menor recibido.");
                ship.setDamage(ship.getDamage() + 5);
                if (ship.getDamage() > 50) {
                    shutDownShip(true);
                }
            }

            context.markAsOccurred("planetRingsDanger");
        }));

        // Evento 10: Nave demasiado pesada para planetas cercanos
        events.add(new Event("overweightShip", 15, (args, context) -> {
            Scanner input = (Scanner) args[0];
            SpaceShip ship = (SpaceShip) args[1];
            Planet planet = (Planet) args[2];

            if ((ship.getToughness() <= 90 && ship.getCargoCapacity() <= 350) || planet.getEarthDistance() >= 1000)
                return;

            System.out.println("\n¡Advertencia! La nave es demasiado robusta para el trayecto.");
            System.out.println("Pregunta: ¿Qué factor afecta más la velocidad de una nave?");
            System.out.println("a) Gravedad\nb) Combustible\nc) Resistencia del material\nd) Tamaño de la nave");

            var answer = input.nextLine().toLowerCase();
            if (answer.equals("d")) {
                System.out.println("¡Correcto! Se ha mejorado la eficiencia.");
            } else {
                System.out.println("Incorrecto. Velocidad reducida.");
                int newSpeed = (int) Math.round(ship.getSpeed() * 0.9);
                ship.setSpeed(newSpeed);
                System.out.println("Nueva velocidad máxima: " + newSpeed + " km/día.");
            }

            context.markAsOccurred("overweightShip");
        }));

        // Evento 11: Nave frágil para viajes largos
        events.add(new Event("fragileShip", 15, (args, context) -> {
            Scanner input = (Scanner) args[0];
            SpaceShip ship = (SpaceShip) args[1];
            Planet planet = (Planet) args[2];

            if (ship.getToughness() >= 40 || planet.getEarthDistance() <= 4000)
                return;

            System.out.println("\n¡Alerta! La nave es muy frágil para este viaje.");
            System.out.println("Pregunta: ¿Qué sistema debe reforzarse en condiciones extremas?");
            System.out.println("a) Motor\nb) Estructura\nc) Navegación\nd) Energía");

            var answer = input.nextLine().toLowerCase();
            if (answer.equals("b")) {
                System.out.println("¡Correcto! Has reforzado la nave.");
            } else {
                System.out.println("Incorrecto. Riesgo incrementado.");
                ship.setDamage(ship.getDamage() + 10);
            }

            context.markAsOccurred("fragileShip");
        }));
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

            TimeUtil.printTime("\nEl viaje ha terminado abruptamente.\n--- MISIÓN FALLIDA ---\n");

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
            TimeUtil.printTime("\nProcedimiento completado con éxito.\n");
        }

        System.exit(0);
    }
}