/*
 * Dev Senior | Reto 01 - Modulo 01
 * Integrantes:
 * Luis Miguel Triana Rueda
 * Samuel Esteban Rivera Mosquera
 */
package IntraPlanetaryExplorer.src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Explorer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        loadResources();

        System.out.println("Bienvenido usuario...\nPor favor, ingresa tu nombre: ");
        String userName = input.nextLine();

        printTime("¡Bienvenido a la nave, " + userName + "!");

        showMenu();

        input.close();
    }

    public static void loadResources() {
        System.out.println("Iniciando secuencias de carga...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sistemas de nave activados....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Revisando componentes...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n¡Listo para el lanzamiento!\n");
    }

    public static void showMenu() {
        System.out.println("\n¿Que desea realizar?\n");
    }

    public static void printTime(String message) {
        LocalDateTime timeAndHour = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

        System.out.println(message);
        System.out.println("Fecha y hora actual: " + timeAndHour.format(format));
        System.out.println();
    }
}