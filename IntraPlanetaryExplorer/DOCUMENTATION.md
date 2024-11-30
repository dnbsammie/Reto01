# DOCUMENTACIÓN

## 1. Descripción del Proyecto

-**Nombre del proyecto**: Intra Planetary Explorer.

-**Género**: Simulación, Espacio, Cohetes, Sci-fi.

-**Objetivo del desafio**: 

Desarrollar un simulador de viaje interplanetario, donde se gestionara un viaje espacial a diferentes planetas del sistema solar. El usuario obtendra la experiencia de elegir el destino, gestionar recursos de la nave y resolver conflictos a medida de que los eventos se vuelven más complejos.

## 2. Objetivos

- **Destino interplanetario**: Permitir al usuario elegir un planeta destino entre una lista de planetas del sistema solar.
- **Calcular distancia y tiempo de viaje**: Calcular la distancia entre la tierra y el planeta destino, considerar el tiempo de viaje tomando la velocidad dada.
- **Gestionar Recursos de la nave**: Calcular la cantidad de combustible necesario para el viaje y permitir al usuario administrar los recursos (Combustible y oxigeno). Esto variara según los recursos disponibles y necesarios para cierto destino.
- **Simular eventos aleatorios durante el viaje**: Introducción de eventos aleatorios que puedan afectar el viaje tanto del entorno como del sistema. El usuario debera intervenir para resolverlos.
- **Monitoreo el estado del viaje**: El usuario podra ver el progreso del viaje, cantidad de recursos disponivles y tiempo restante para llegar al destino.

## 3. Requerimientos Funcionales

El proyecto consiste en la interacción del usuario (Astronauta) con la consola (Sistema de la nave) donde debera encontrar:

1. **Selección de destino**:  
   - Presenta la lista de planetas para escoger el destino con los caracteres numericos del teclado.
   - Solicitar la confirmación del destino por parte del usuario.
   - Devolver información basica del planeta.

2. **Cálculo de Distancia y tiempo de viaje**:
   - Calcular la distancia del planeta y el tiempo utilizando la velocidad:
    ```
    t = d / v = ?
    ```
   - Mostrar la información al usuario.

3. **Gestión de Recursos**:
   - Calcular la cantidad de combustible y oxígeno necesarios para el viaje según la distancia.
   - Permitir al usuario revisar y ajustar los recursos antes de partir (Metodo settingsManager)

## 4. **Simulación de Eventos Aleatorios**: 
   - Durante el viaje, simular eventos aleatorios que afecten el progreso como desvios, fallos en el sistema o factores externos. 
   - Solicitar al usuario tomar decisiones para resolver los problemas (Metodo eventManager)
  
### 4.1 **Evento 1 (perdidad de combustible )**:
Durante el evento 1 se genera una probabilidad del 20% de que el evento se genere si se genera la nave pierde -10 unidades de combustible. El cual, tiene la probabilidad de recuperar 8 unidades de combustible si la respuesta a la pregunta hecha en el proceso de recuperación es correcta. 

```java
    if (eventRandom.nextInt(100) < 20 && !eventHistory.contains("fuelLeak")) { // 20% de probabilidad
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
```

### 4.2 **Evento 2 (Falla electronica)**:
durante el evento 2 la nave presentara una falla electronica con un 25% de ocurrir la cual reducidara la maniobralidad en -10. El cual tiene la probabilidad de reveritr la totalidad del daño echo por el evento respondiendo una pregunta si es correcto revierte; de lo contrario no.

```java
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
```
### 4.3 **Evento 3 (Sobrecaliento del motor)**:
Durante el evento 3 se genera con un 30% de ocurrir un sobrecaliento del motor el cual aumentara el daño de la nave en 5 unidades; el cual tiene la probabilidad de revertirse con la respuesta correcta de la pregunta. De lo contrario, el aumento del daño no se revertira.

```java
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
```
### 4.4 **Evento 4 (Daño adicional)**:
En el evento 4 se genera un daño adicional con una probabilidad del 15% de aparecer, el cual no tiene una forma de revertir el daño. 

```java
    if (eventRandom.nextInt(100) < 15 && !eventHistory.contains("meteorImpact")) {
        System.out.println("\n¡Un meteorito ha impactado la nave! La nave ha sufrido daño adicional.\n");
        selectedShip.setDamage(selectedShip.getDamage() + 10);
        if (selectedShip.getDamage() > 50) {
            shutDownShip(true);
        }
    
        eventHistory.add("meteorImpact");
    }
```
### 4.5 **Evento 5 (Advertencia)**:
Se genera una advertencia de posibles daños.

```java
    if (eventRandom.nextInt(100) < 10 && !eventHistory.contains("microAsteroidCollision")) {
        System.out.println("\n¡Colisión con micro-asteroides! El casco de la nave ha sido dañado.\n");
        selectedShip.setDamage(selectedShip.getDamage() + 8);
        selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 3);
        if (selectedShip.getDamage() > 60) {
            shutDownShip(true);
        }
        eventHistory.add("microAsteroidCollision");
    }
```
### 4.6 **Evento 6 (Colisión de micro-asteroides)**:
Se genera una colisión de micro-asteroides el cual incrementa el daño y disminuye el combustible.

```java
    if (random.nextInt(100) < 10) { // 10% de probabilidad
            System.out.println("¡Colisión con micro-asteroides! El casco de la nave ha sido dañado.");
            selectedShip.setDamage(selectedShip.getDamage() + 8); // Incremento de daño
            selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 3); // Pequeña pérdida de combustible
        }
```
### 4.7 **Evento 7 (Radiación espacial)**:
Se genera una radiacion espaccial la cual disminuye la resistencia de la nave en -5 unidades.
   
```java
    if (eventRandom.nextInt(100) < 12 && !eventHistory.contains("spaceRadiation")) { 
        System.out.println("\n¡Tormenta de radiación espacial! Los escudos han sido debilitados.\n");
        selectedShip.setToughness(selectedShip.getToughness() - 5);
    
        eventHistory.add("spaceRadiation");
    }
```
### 4.8 **Evento 8 (Suministro de energia)**:
La nave se está alejando demasiado del sol y no puede tomar energia de este (-5).

```java
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
```
### 4.9 **Evento 9 (Anillos del planeta)**:
La nave cruza por un planeta con anillos y puede ser penalizada con +5 de daño.

```java
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
```
### 4.10 **Evento 10 (Nave Robusta)**:
Nave demasiado pesada y lenta para el viaje. Puede recuperar su velocidad normal.

```java
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
```
### 4.11 **Evento 11 (Nave Fragil)**:
Nave demasiado fragil para el viaje. Puede evitar sufrir daño.

```java
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
```

## 5. **Monitoreo del Estado de Viaje**:
   - Mostrar en pantalla el progreso de viaje, tiempo restante y recursos disponibles . (Clase travelState)
   - Notificar al astronauta a cargo si el viaje fue exitoso o si la nave se quedó sin recursos.

## 6. **Interacción con el Usuario**: 
- El sistema debe proporcionar un menú interactivo para que el usuario elija las opciones disponibles

```java
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
```
- Notificar al astronauta a cargo si las entradas son validas bajo el número correspondiente.

## 7. Componentes del Proyecto

- **Clases:**
- Planet

```java
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
```
- SpaceShip

```java
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
```
- Explorer

```java
    public class Explorer {
        private static Planet selectedPlanet;
        private static SpaceShip selectedShip;
        // main y demás metodos
    }
```
- **Metodos:**

- Main
```java
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
```
- **Interacciónes:**
- Menu principal

```java
    public static void showMenu() {
        System.out.println("\n--- PANEL CENTRAL ---\n");
        System.out.println("1. Planeta de destino.");
        System.out.println("2. Selección de nave.");
        System.out.println("3. Opciones.");
        System.out.println("4. Inicio del Viaje.");
        System.out.println("5. Salir de la nave.");
        System.out.print("\nElige una opción: ");
    }
```
- Opciones

```java
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
```
- Estado y Barra de Progreso

```java
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
```
- Salida final
Utilizamos System.exit(0) por practicidad.

```java
public static void shutDownShip(boolean isEmergency) {
    System.out.print("\033[H\033[2J");
    System.out.flush();
        
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
```
## 8. Resumen Final
### 8.1. Conclusión:
En particular, se ha agregado la mecánica de penalizar la nave en caso de que el jugador falle una pregunta clave sobre la optimización de la propulsión de la nave. Esta penalización afecta directamente a los atributos o estadisticas de la nave.

Además, se asegura que los eventos no se repitan durante el mismo viaje mediante un sistema de historial de eventos (eventHistory), lo que otorga un control adicional sobre la dinámica del proyecto. Estas modificaciones no solo enriquecen la jugabilidad, sino que también crean una experiencia más dinámica y desafiante para el jugador, al introducir consecuencias significativas por decisiones incorrectas.

Este enfoque no solo mejora la inmersión; sino que también brinda al jugador la oportunidad de aprender y ajustar sus decisiones en tiempo real, reflejando la importancia de la gestión eficiente de los recursos y sistemas de la nave en el contexto de un viaje espacial largo y peligroso.

### 8.2. Creditos y Agradecimientos:
- Desarrolladores a cargo:
 - Luis Miguel Triana Rueda.
 - Samuel Esteban Rivera Mosquera.
- Agradecimientos a:
 - [INSTRUCTOR]: Cesar Augusto Díaz Arriaga
 - [INSTRUCTOR]: Alfonso Lara
### 8.3. Referencias::
- Sistema Solar, Wikipedia: https://es.wikipedia.org/wiki/Sistema_solar#Planetas
- Combustible Espacial, Outerspace: https://outerspace.es/tecnologia-espacial/combustible-solido-para-cohetes-espaciales-una-innovacion-revolucionaria/
