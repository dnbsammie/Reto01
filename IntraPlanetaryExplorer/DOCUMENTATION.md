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

### 5. Interacción en el viaje
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
