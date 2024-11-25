<h1 align="center">RETO01 - Simulador de Viaje Interplanetario 🚀</h1>

<h3>Introducción</h3>
<p text-align="justify">Este programa simula un viaje interplanetario en el que el usuario selecciona un planeta y la cantidad de combustible para el viaje. El programa evalúa si es posible llegar al destino con el combustible proporcionado y realiza una cuenta regresiva de tiempo y consumo de combustible en paralelo utilizando hilos y sincronización.</p>

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,git,github" />
  </a>
</p>

<h3>Funciones Principales:</h3>
<h4>Objetivos 🐱‍🚀</h4>
<ul>
<li href="planets">Seleccionar destino interplanetario</li>
<li>Calcular distancia y tiempo de viaje</li>
<li>Gestionar recursos de la nave</li>
<li>Simular eventos aleatorios durante el viaje</li>
<li>Monitorear el estado de viaje</li>
</ul>

<section id="planets">
<ul>
<li class="planet">Mercurio</li>
<li class="planet">Venus</li>
<li class="planet">Tierra</li>
<li class="planet">Marte</li>
<li class="smallplanet">Ceres</li>
<li class="planet">Jupiter</li>
<li class="planet">Saturno</li>
<li class="planet">Urano</li>
<li class="planet">Neptuno</li>
<li class="planet">Plutón</li>
<li class="splanet">Ceres</li>
</ul>
</section>
<!-- Solicita al usuario el nombre del planeta y la cantidad de combustible.

Verifica si el combustible es suficiente para el viaje.

Inicia hilos separados para la cuenta regresiva del combustible y el tiempo de viaje si el destino es Mercurio.

combustible:

Ejecutado en un hilo separado.

Muestra la cantidad de combustible restante en decrementos del 1%, con un retraso de 1 segundo entre cada decremento.

Utiliza sincronización con un objeto monitor para coordinar la ejecución con el hilo de tiempo.

time:

Ejecutado en un hilo separado.

Calcula el tiempo necesario para llegar al destino basado en la distancia a Mercurio y la velocidad promedio de la nave.

Muestra el tiempo restante en decrementos de 1 hora, con un retraso de 1 segundo entre cada decremento.

Utiliza sincronización con un objeto monitor para coordinar la ejecución con el hilo de combustible.

Lógica Clave y Tecnologías Utilizadas:
Uso de Hilos (Threads):

Dos hilos (combustibleThread y timeThread) para ejecutar las tareas de combustible y tiempo en paralelo.

Sincronización:

Objeto monitor (monitor) para coordinar la comunicación y sincronización entre los hilos.

Entrada del Usuario:

Scanner para recibir las entradas del usuario.

Retrasos Temporales:

Thread.sleep() para introducir retrasos de 1 segundo en los bucles de cuenta regresiva. -->


