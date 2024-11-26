# DOCUMENTACIÓN

## Requerimientos:

### 1. Selección de planeta de destino
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
Capacidad de pasajeros: (crewCapacity)
2-4-6-8-etc
```
```
Control de gravedad: (gravityControl)
?%
```
```
Cabacidad de combustible: (fuelCapacity)
?%
```
```
Sistema de daño: (damage)
?%
```
```
Probabilidad de actividad: (eventProbability)
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
