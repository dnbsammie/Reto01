# DOCUMENTACIÓN

## Requerimientos:
### 1. clase planet 
en la clase planet vamos a declarar los variables  como el nombre del planeta, la distancia en comparacion a la tierra, el tiempo del viaje, el combustible recomendado para el viaje, y si el planeta contiene anillos o no y le asiganamos esas variables al metodo construtor 
```
class Planet {
    private String planetName; // Nombre del planeta
    private double earthDistance; // Distancia desde la tierra
    private double timeTravel; // Tiempo de viaje
    private double recFuel; // Combustible recomendado por planeta
    private boolean ringSystem; // El planeta tiene Anillos / Discos?
    public String planet;
// METODO CONSTRUCTOR
  public Planet(String planetName, double earthDistance, double timeTravel, double recFuel, boolean ringSystem) {
        this.planetName = planetName;
        this.earthDistance = earthDistance;
        this.timeTravel = timeTravel;
        this.recFuel = recFuel;
        this.ringSystem = ringSystem;
    }
```
### 2. datos antes de empezar el viaje
en la clase SpaceShip se declaran las variables que contienen los datos del viaje, y de la nave y con su metodo para dichos parametros.
```
class SpaceShip {
    private String shipName; // Nombre de la nave
    private int maxSpeed; // Velocidad Máxima de la nave
    private int crewCapacity; // Capacidad de tripulantes
    private int gravityControl; // Control de gravedad (Maniobrilidad)
    private int fuelCapacity; // Capacidad máxima de combustible
    private int damage; // % de daño actual de la nave
    private int toughness; // Resistencia de la nave
// METODO DATOS NAVE

public SpaceShip(String shipName, int maxSpeed, int crewCapacity, int gravityControl, int fuelCapacity, int damage,
            int toughness)
```


### 3. Clase explorer 
la Clase explorer la cual contiene los datos del planeta nombre distancia el tiempo de viaje el combustible restante para ir al planeta y si tiene anillos o no 
```
public class Explorer {
    // private static final Object monitor = new Object();

    public static List<Planet> getPlanets() {
        List<Planet> planets = new ArrayList<>();
        // Nombre del planeta | Distancia en relacioón a la tierra | Tiempo en días | %
        // de combustible necesario por viaje | Tiene (o no) anillos
 planets.add(new Planet("Mercurio", 77, 26, 16, false));
// asi con todos los planetas 
}
```
### 3. Selección de planeta de destino
#### o Elegir planeta de viaje
El metodo "planetSelector" se encargara de seleccionar el destino del viaje, recargar combustible y desplegara la información del planeta seleccionado.
#### o Mostrar detalles del planeta:
El metodo "planetData" debe proporcionar la información del planeta seleccionado, datos, satelites naturales y planetas enanos al rededor.

### 2. Gestión de la nave espacial
#### o Seleccionar una nave para el viaje:
"shipSelector" desplegara un menu con diferentes naves, cada una con diferentes caracteristicas como:

```
Velocidad Máxima: (maxSpeed)
162,000 km/h.
```
```
Capacidad de tripulantes: (crewCapacity)
2-4-6-8-etc
```
```
Control de gravedad: (gravityControl)
?%
```
```
Capacidad de combustible: (fuelCapacity)
?%
```
```
Daño actual: (damage)
?%
```
```
Dureza / Resistencia de la nave: (toughness)
?%
```
#### o Cálculo:
"travelCalculator" sera el metodo que se encargara de determinar si el viaje es posible o no, presentara la duración estimada en día, advertencias, recomendaciones y  y peligros 


### 3. Simulación del viaje
#### o Simulación básica del progreso del viaje:
La consola devolvera mensajes constantemente con el metodo "travelProgress" donde el usuario tomara decisiones y podra leer estadisticas como:

- % recorrido
- Tiempo estimado / duración del viaje (Desde la hora en que empezo el trayecto)
- % de combustible
- % de daños
- Estado actual

### 4. Interacción con el Usuario
#### o Ingreso:
El usuario vera una pantalla de carga donde obtendra la posibilidad de escoger su nombre, traje y sera asignado con un ID aleatorio.
#### o Menu de opciones:
Una vez ingresado, el usuario encontrara un menú interactivo que le permitira escoger alguno de estos metodos:
- Planeta de destino
- Selección de nave (o creación de una propia)
- Inicio de viaje
- Opciones
- Salir de la nave (salir del programa)

Uso de metodos try-catch para evitar una opción invalida por parte del usuario

 ### 5. Contadores
 creacion de metodos que contiene los contadores que van a poner el avanze del viaje y la disminuscion de combustible para la nave
```
 private static void combustible(double recFuel)
```
```
 private static void time(double timeTravel)
```
### 6. Seleción de planetas 
selecion de los planetas dado en la clase explorer 
```
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
```
### 7. Comparación del planeta 
después de seleccionar el planeta entra al switch a comprar y ejecutar los datos para cada planeta 
```
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
```
#### creacion y inicializacion de los hilos 
los hilos se utilizaran para poder mostrar el simultaneo la disminucion del combustible y el progreso del viaje 
```
  // creacion de los hilos para mercurio
 Thread combustibleThread = new Thread(() -> combustible(16));
                    Thread timeThread = new Thread(() -> time(26));
                    // Iniciar hilos
                    combustibleThread.start();
                    timeThread.start();
```
#### creacion de hilos para diferentes planetas 
para cada planeta se va a crear un hilo por lo tanto cada variable del hilo tiene que tener un nombre diferente 
```
case "venus":
                    // se agrego la variable (combustibleThreadVenus)  para venus asi con todos los planetas 
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
```
### 8. Interacción en el viaje
#### o Eventos:
En el metodo "eventManager" se utilizara numeros aleatorios para generar un evento donde el astronauta (usuario) debera completar una tarea para poder salvar su trayecto efectivamente. Esto dependera de las caracteristicas de la nave y de la variable "eventProbability"

```
Evento 1. (nombre del evento)
Descripción:
Tarea a realizar:
```
```
Evento 1. (nombre del evento)
Descripción:
Tarea a realizar:
```
```
Evento 1. (nombre del evento)
Descripción:
Tarea a realizar:
```
```
Evento 1. (nombre del evento)
Descripción:
Tarea a realizar:
```
```
Evento 1. (nombre del evento)
Descripción:
Tarea a realizar:
```
```
Evento 1. (nombre del evento)
Descripción:
Tarea a realizar:
