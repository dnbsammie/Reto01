<h1 align="center">RETO 1 - Simulador de Viaje Interplanetario</h1>
<img src="./assets/banner.png" width="100%"></img>
<h3>Introducción</h3>
<p align="center">
  <a href="https://github.com/dnbsammie/Reto01/issues">
    <img src="https://img.shields.io/github/issues/dnbsammie/Reto01" alt="Issues">
  </a>
  <a href="https://github.com/dnbsammie/Reto01/stargazers">
    <img src="https://img.shields.io/github/stars/dnbsammie/Reto01" alt="Stars">
  </a>
</p>
<p>Desarrollar un simulador de viaje interplanetario, donde se gestionará un viaje espacial a diferentes planetas del sistema solar. El usuario obtendrá la experiencia de elegir el destino, gestionar recursos de la nave y resolver conflictos a medida que los eventos se vuelven más complejos.</p>

<p>Puedes encontrar el link de la presentación <a href="https://youtu.be/VV7WT9pXnbc">acá mismo 🎥</a></p>

<h3 align="left">Lenguajes y herramientas:</h3>

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=git,github,md,java,vscode&theme=dark" />
  </a>
</p>

<details>
  <summary>Índice:</summary>
  <ol>
    <li><a href="#objectives">🎯 Objetivos</a></li>
    <li><a href="#requirements">🚀 Requerimientos</a></li>
    <li><a href="#methodology">⚙️ Metodología</a></li>
    <li><a href="#credits">🎬 Creditos</a></li>
  </ol>
</details>

<h2 id="objectives">🎯 Objetivos</h2>
<ol>
    <li><strong>Seleccionar Destino interplanetario</strong></li>
      <ul>
        <li>Permitir al usuario elegir un planeta destino entre una lista de planetas del sistema solar.</li>
      </ul>
    <li><strong>Calcular distancia y tiempo de viaje</strong></li>
      <ul>
        <li>Calcular la distancia entre la tierra y el planeta destino, considerar el tiempo de viaje tomando la velocidad dada.</li>
      </ul>
    <li><strong>Gestionar Recursos de la nave</strong></li>
      <ul>
        <li>Calcular la cantidad de combustible necesario para el viaje y permitir al usuario administrar los recursos (Combustible y oxigeno). Esto variara según los recursos disponibles y necesarios para cierto destino.</li>
      </ul>
    <li><strong>Simular eventos aleatorios durante el viaje</strong></li>
      <ul>
        <li>Introducción de eventos aleatorios que puedan afectar el viaje tanto del entorno como del sistema. El usuario deberá intervenir para resolverlos.</li>
      </ul>
    <li><strong>Monitoreo el estado del viaje</strong></li>
      <ul>
        <li>El usuario podrá ver el progreso del viaje, cantidad de recursos disponibles y tiempo restante para llegar al destino.</li>
      </ul>
</ol>

<h2 id="requirements">🚀 Requerimientos</h2>
<ol>
    <li><strong>Selección de Planeta de Destino</strong></li>
      <ul>
        <li>Presentar al usuario una lista de planetas del sistema solar para elegir el destino del viaje.</li>
        <li>Solicitar la confirmación del usuario y mostrar información básica del planeta.</li>
      </ul>
    <li><strong>Gestión de la Nave Espacial</strong></li>
      <ul>
        <li>El sistema ofrecerá al usuario una lista de naves espaciales, cada una con características básicas, como la velocidad máxima y la capacidad de pasajeros.</li>
        <li>El usuario deberá especificar la cantidad de pasajeros que viajarán. El sistema solo verificará que se ingrese un valor positivo, pero no limitará la cantidad máxima.</li>
        <li>Basado en la velocidad de la nave y la distancia del planeta seleccionado, el sistema calculará la duración estimada del viaje en días.</li>
      </ul>
    <li><strong>Simulación del Viaje</strong></li>
      <ul>
        <li>El sistema mostrará el avance del viaje mediante una serie de mensajes en la consola, indicando el porcentaje completado del trayecto.</li>
        <li>El progreso se calculará utilizando bucles básicos y se presentaran mensajes condicionales para indicar las etapas clave del viaje, como: "Inicio del viaje", "Mitad del camino", y "Llegada al destino".</li>
      </ul>
    <li><strong>Interacción con el Usuario</strong></li>
      <ul>
        <li>El sistema debe proporcionar un menú interactivo en consola que permita al usuario elegir entre las siguientes opciones:</li>
          <ul>
            <li>Seleccionar un Planeta de Destino.</li>
            <li>Seleccionar una Nave Espacial.</li>
            <li>Iniciar la simulación del viaje.</li>
            <li>Salir del programa.</li>
          </ul>
        <li>El sistema debe verificar que el usuario elija una opción válida en el menú. Si el usuario ingresa una opción no válida, se mostrará un mensaje y se volverá a presentar el menú.</li>
      </ul>
    <li><strong>Manipulación de Datos</strong></li>
      <ul>
        <li>Los datos como la distancia al planeta, la velocidad de la nave, y la cantidad de pasajeros se manejarán utilizando tipos de datos básicos como int, double, y String.</li>
        <li>Los planetas y las naves espaciales se almacenarán en arrays para facilitar su selección e información. Por ejemplo, un array de strings para los nombres de los planetas y otro array para las distancias correspondientes.</li>
      </ul>
    <li><strong>Modularidad y Métodos</strong></li>
      <ul>
        <li>El sistema debe utilizar métodos para separar la lógica de selección del planeta, cálculo de la duración del viaje, y simulación del trayecto. Cada funcionalidad principal se implementará en un método separado.</li>
        <li>Los métodos aceptarán parámetros para recibir datos del usuario.</li>
      </ul>
</ol>

<h2 id="methodology">⚙️ Metodología</h2>
<h4>Descripción General del Flujo de Sistema:</h4>

<ol>
    <li><strong>Inicio del Programa:</strong></li>
      <ul>
        <li>El programa se inicia y muestra al usuario un menú interactivo. El usuario puede elegir la acción que desea realizar.</li>
      </ul>
    <li><strong>Selección del Planeta y la Nave</strong></li>
      <ul>
        <li>El usuario elige un planeta de destino de una lista proporcionada por el sistema. El sistema muestra la distancia y una breve descripción del planeta.</li>
        <li>A continuación, el usuario selecciona una nave para el viaje y específica la cantidad de pasajeros.</li>
      </ul>
    <li><strong>Simulación del Viaje</strong></li>
      <ul>
        <li>Al iniciar la simulación, el sistema muestra el progreso del viaje en intervalos, indicando etapas clave y calculando la duración total del trayecto en función de la velocidad de la nave y la distancia al planeta.</li>
      </ul>
    <li><strong>Finalización del Viaje</strong></li>
      <ul>
        <li>Una vez que el viaje alcanza el 100% de progreso, el sistema muestra un mensaje indicando la llegada exitosa al planeta de destino.</li>
      </ul>
    <li><strong>Salir del Programa</strong></li>
      <ul>
        <li>Si el usuario selecciona la opción para salir, el sistema cierra el programa de manera correcta.</li>
      </ul>
</ol>

<h4>📦 Estructura de Paquetes:</h4>

```
spacesimulator/
└── src/
    ├── controllers/
    │   ├── MenuController.java
    │   ├── ResourceController.java
    │   └── SimulationController.java
    │
    ├── models/
    │   ├── Event.java
    │   ├── EventContext.java
    │   ├── Planet.java
    │   ├── Spaceship.java
    │   └── TravelState.java
    │
    ├── managers/
    │   └── EventManager.java
    │
    ├── utils/
    │   ├── ConsoleUtil.java
    │   ├── RandomUtil.java
    │   └── TimeUtil.java
    │
    └── App.java
```

<h2 id="credits">🎬 Creditos</h2>

<p>
  <strong>Author:</strong> Luis Triana<br>
  <strong>GitHub:</strong> <a href="https://github.com/luistriana032006">https://github.com/luistriana032006</a>
</p>
<p>
  <strong>Author:</strong> Samuel Rivera<br>
  <strong>GitHub:</strong> <a href="https://github.com/dnbsammie">https://github.com/dnbsammie</a>
</p>

---