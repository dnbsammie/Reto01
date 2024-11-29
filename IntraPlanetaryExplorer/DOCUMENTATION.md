# DOCUMENTACIÓN

## 1. Descripción del Proyecto

**Nombre del proyecto**: Intra Planetary Explorer.
**Género**: Simulación, Espacio, Cohetes, Sci-fi.
**Objetivo del desafio**:  
Desarrollar un simulador de viaje interplanetario, donde se gestionara un viaje espacial a diferentes planetas del sistema solar. El usuario obtendra la experiencia de elegir el destino, gestionar recursos de la nave y resolver conflictos a medida de que los eventos se vuelven más complejos.

## 2. Objetivos

- **Destino interplanetario**: Permitir al usuario elegir un planeta destino entre una lista de planetas del sistema solar.
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

4. **Simulación de Eventos Aleatorios**: 
   - Durante el viaje, simular eventos aleatorios que afecten el progreso como desvios, fallos en el sistema o factores externos. (En proceso...)
   - Solicitar al usuario tomar decisiones para resolver los problemas (Metodo eventManager)
  
   4.1 **Evento 1 (perdidad de combustible )**:
     durante el evento 1 se genera una probabilidad del 20% de que el evento se genere si se genera la nave pierde -10 unidades de combustible
   el cual tiene la probabilidad de recuperar 8 unidades de combustible si la respuesta a la pregunta echa en el proceso de recuperación es correcta 
    ```
    // evento de daño //
    if (random.nextInt(100) < 20) { // 20% de probabilidad
            System.out.println("¡Atención! La nave ha perdido parte de su combustible debido a una fuga.");
            selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 10); // Decrementamos el combustible

     
    //  tarea para solucionar el problema // 
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
    
    ```
    4.2 **Evento 2 (Falla electronica)**:
     durante el evento 2 la nave presentara una falla electronica con un 25% de ocurrir la cual reducidara la maniobralidad en -10
   el cual tiene la probabilidad de reveritr la totalidad del daño echo por el evento respondiendo una pregunta si es correcto revierte
   de lo contrario no.
    ```
    if (random.nextInt(100) < 25) { // 25% de probabilidad
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
    ```
    4.3 **Evento 3 (Sobrecaliento del motor)**:
   durante el evento 3 se genera con un 30% de ocurrir un sobrecaliento del motor el cual aumentara el daño de la nave en 5 unidades
   el cual tiene la probabilidad de revertirse con la respuesta correcta de la pregunta de lo contrario el aumento del daño no se revertira 
    ```
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
    ```
    4.4 **Evento 4 (Daño adicional)**:
   en el evento 4 se genera un daño adicional con una probabilidad del 15% de aparecer el cual no tiene una forma de revertir el daño 
    ```
     if (random.nextInt(100) < 15) { // 15% de probabilidad
            System.out.println("¡Un meteorito ha impactado la nave! La nave ha sufrido daño adicional.");
            selectedShip.setDamage(selectedShip.getDamage() + 10); // Aumentamos el daño
        }
    ```
    4.5 **Evento 5 (Advertencia)**:
   se genera una advertencia de posibles daños 
    ```
    if (random.nextInt(100) < 45) { 
            System.out.println(
                    " ¡fragementos de roca en el espacio detectados ten cuidado de no peder proviciones ");
        }

    ```
    4.6 **Evento 6 (Colisión de micro-asteroides)**:
   se genera una colisión de micro-asteroides el cual incrementa el daño y disminuye el combustible 
    ```
    if (random.nextInt(100) < 10) { // 10% de probabilidad
            System.out.println("¡Colisión con micro-asteroides! El casco de la nave ha sido dañado.");
            selectedShip.setDamage(selectedShip.getDamage() + 8); // Incremento de daño
            selectedShip.setFuelCapacity(selectedShip.getFuelCapacity() - 3); // Pequeña pérdida de combustible
        }
   ```
   4.7 **Evento 7 (Radiación espacial)**:
   se genera una radiacion espaccial la cual disminuye la resistencia de la nave en -5 unidades 
   
   ```
   if (random.nextInt(100) < 12) { // 12% de probabilidad
               System.out.println("¡Tormenta de radiación espacial! Los escudos han sido debilitados.");
               selectedShip.setToughness(selectedShip.getToughness() - 5); // Reducción en resistencia
           }
    ```
     4.7 **Evento 8 (Suministro de energia)**:
    La nave se está alejando demasiado del sol y no puede tomar energia de este (-5)

      ```

    ```
6. **Monitoreo del Estado de Viaje**: (PENDIENTE) 
   - Mostrar en pantalla el progreso de viaje, tiempo restante y recursos disponibles . (Clase travelState)
   - Notificar al astronauta a cargo si el viaje fue exitoso o si la nave se quedó sin recursos.

7. **Interacción con el Usuario**: (PENDIENTE) 
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

## 5. Componentes del Juego

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

## 6. Resumen Final
### 6.1. Conclusión:
Pendiente
### 6.2. Notas de Versión (Changelog):
Pendiente
### 6.3. Creditos y Agradecimientos:
- Desarrolladores a cargo:
 - Luis Miguel Triana Rueda.
 - Samuel Esteban Rivera Mosquera.
- Agradecimientos a:
 - [INSTRUCTOR]: Cesar Augusto Díaz Arriaga
### 6.4. Referencias::
- Sistema Solar, Wikipedia: https://es.wikipedia.org/wiki/Sistema_solar#Planetas
- Combustible Espacial, Outerspace: https://outerspace.es/tecnologia-espacial/combustible-solido-para-cohetes-espaciales-una-innovacion-revolucionaria/
