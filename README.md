# Reto01
Simulador de Viaje Interplanetario

RESUMEN PARTE1RETO1
Este programa simula un viaje interplanetario en el que el usuario selecciona un planeta y la cantidad de combustible para el viaje. El programa evalúa si es posible llegar al destino con el combustible proporcionado y realiza una cuenta regresiva de tiempo y consumo de combustible en paralelo utilizando hilos y sincronización.

Funciones Principales:
main:

Solicita al usuario el nombre del planeta y la cantidad de combustible.

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

Thread.sleep() para introducir retrasos de 1 segundo en los bucles de cuenta regresiva.
