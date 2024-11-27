# DOCUMENTACIÓN

## 1. Descripción del Proyecto

**Nombre del proyecto**: Intra Planetary Explorer.
**Género**: Simulación, Espacio, Cohetes, Sci-fi.
**Objetivo del desafio**:  
Desarrollar un simulador de viaje interplanetario, donde se gestionara un viaje espacial a diferentes planetas del sistema solar. El usuario obtendra la experiencia de elegir el destino, gestionar recursos de la nave y resolver conflictos a medida de que los eventos se vuelven más complejos.

## 2. Objetivos

- **Destino interplanetario*: Permitir al usuario elegir un planeta destino entre una lista de planetas del sistema solar.
- **Calcular distancia y tiempo de viaje**: Calcular la distancia entre la tierra y el planeta destino, considerar el tiempo de viaje tomando la velocidad dada (PENDIENTE)
- **Gestionar Recursos de la nave**: Calcular la cantidad de combustible necesario para el viaje y permitir al usuario administrar los recursos (Combustible y oxigeno). Esto variara según los recursos disponibles y necesarios para cierto destino. (PENDIENTE)
- **Simular eventos aleatorios durante el viaje**: Introducción de eventos aleatorios que puedan afectar el viaje tanto del entorno como del sistema. El usuario debera intervenir para resolverlos. (En proceso)
- **Monitoreo el estado del viaje**: El usuario podra ver el progreso del viaje, cantidad de recursos disponivles y tiempo restante para llegar al destino.

## 3. Requerimientos Funcionales

El proyecto consiste en la interacción del usuario (Astronauta) con la consola (Sistema de la nave) donde debera encontrar:

1. **Selección de destino**:  
   - Presenta la lista de planetas para escoger el destino con los caracteres numericos del teclado.
   - Solicitar la confirmación del destino por parte del usuario.
   - Devolver información basica del planeta.

2. **Cálculo de Distancia y tiempo de viaje**: (PENDIENTE)
   - Calcular la distancia del planeta y el tiempo utilizando la velocidad:
    ```
    t = d / v = ?
    ```
   - Mostrar la información al usuario.

3. **Gestión de Recursos**: (PENDIENTE) 
   - Calcular la cantidad de combustible y oxígeno necesarios para el viaje según la distancia. (En proceso...)
   - Permitir al usuario revisar y ajustar los recursos antes de partir (Metodo settingsManager)

4. **Simulación de Eventos Aleatorios**: (PENDIENTE) 
   - Durante el viaje, simular eventos aleatorios que afecten el progreso como desvios, fallos en el sistema o factores externos. (En proceso...)
   - Solicitar al usuario tomar decisiones para resolver los problemas (Metodo eventManager)
    ```
    Evento 1. (nombre del evento)
    Descripción:
    Tarea a realizar:
    ```
    ```
    Evento 2. (nombre del evento)
    Descripción:
    Tarea a realizar:
    ```
    ```
    Evento 3. (nombre del evento)
    Descripción:
    Tarea a realizar:
    ```
    ```
    Evento 4. (nombre del evento)
    Descripción:
    Tarea a realizar:
    ```
    ```
    Evento 5. (nombre del evento)
    Descripción:
    Tarea a realizar:
    ```

5. **Monitoreo del Estado de Viaje**: (PENDIENTE) 
   - Mostrar en pantalla el progreso de viaje, tiempo restante y recursos disponibles . (Clase travelState)
   - Notificar al astronauta a cargo si el viaje fue exitoso o si la nave se quedó sin recursos.

6. **Interacción con el Usuario**: (PENDIENTE) 
   - El sistema debe proporcionar un menú interactivo para que el usuario elija las opciones disponibles
    ```
    -PANEL DE VIAJE-
    - Progreso de viaje: ?%
    - Recursos:
        - Combustible: ?%
        - Oxígeno: ?%
    - Opciones:
        - Velocidad: (Minima || Normal || Máxima) (Desgaste de commbustible)
        - Opción 2:
        - Opción 3:
    ```
   - Notificar al astronauta a cargo si las entradas son validas bajo el número correspondiente.

## 4. Flujo del Juego

1. El jugador presiona una tecla para comenzar desde la pantalla de inicio.
2. El juego inicia con las paletas y la pelota en sus posiciones iniciales.
3. Los jugadores controlan las paletas con las teclas (arriba/abajo para un jugador, o W/S y las teclas de flecha para el otro).
4. La pelota se mueve y rebota en las paredes y las paletas. Si la pelota pasa una paleta, el jugador contrario marca un punto.
5. El juego termina cuando uno de los jugadores alcanza una cantidad predefinida de puntos, por ejemplo, 5 puntos.

## 5. Requisitos Funcionales

- **Movimiento de las paletas**: Las paletas deben moverse arriba y abajo, pero no deben salirse de los bordes de la pantalla.
- **Pelota**: La pelota debe moverse en una dirección diagonal y debe rebotar cuando colisiona con una paleta o las paredes superior e inferior de la pantalla.
- **Marcador**: El marcador debe actualizarse cada vez que un jugador marque un punto.
- **Colisiones**: La pelota debe detectar colisiones con las paletas y las paredes correctamente.
- **Sonido**: Al rebotar la pelota y al marcar un punto, debe sonar un efecto de sonido.

## 6. Componentes del Juego

### 6.1. Codigo

- **Clases:**


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
**Clase SpaceShip:**
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
**Clase Explorer:**
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
- **Metodos:**

- **Interacciónes:**

## 7. Resumen Final
### 7.1. Conclusión:
Pendiente
### 7.2. Notas de Versión (Changelog):
Pendiente
### 7.3. Creditos y Agradecimientos:
- Desarrolladores a cargo:
 - Luis Miguel Triana Rueda.
 - Samuel Esteban Rivera Mosquera.
- Agradecimientos a:
 - [INSTRUCTOR]: Cesar Augusto Díaz Arriaga
### 7.4. Referencias::
- Sistema Solar, Wikipedia: https://es.wikipedia.org/wiki/Sistema_solar#Planetas
