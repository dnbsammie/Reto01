package utils;

import java.util.Scanner;
import java.util.Random;

public class ConsoleUtil {
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void loadResources() {
        System.out.print("Iniciando secuencias de carga");

        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
    }

    public static int getValidOption(Scanner scanner, int maxOption) {
        if (maxOption <= 0) {
            throw new IllegalArgumentException("maxOption debe ser mayor que 0");
        }

        while (true) {
            try {
                String inputStr = scanner.nextLine().trim();
                if (inputStr.isEmpty()) {
                    System.out.println("Por favor, ingresa un número.");
                    continue;
                }

                int input = Integer.parseInt(inputStr);
                if (input > 0 && input <= maxOption) {
                    return input;
                } else {
                    System.out.printf("Por favor, ingresa un número entre 1 y %d.\n", maxOption);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa solo números.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n--- PANEL CENTRAL ---\n");
        System.out.println("1. Planeta de destino.");
        System.out.println("2. Selección de nave.");
        System.out.println("3. Opciones.");
        System.out.println("4. Inicio del Viaje.");
        System.out.println("5. Salir de la nave.");
        System.out.print("\nElige una opción: ");
    }

    public static void showSettingsMenu() {
        System.out.println("\n--- CONFIGURACIONES ---");
        System.out.println("1. Cambiar planeta actual.");
        System.out.println("2. Cambiar nave seleccionada.");
        System.out.println("3. Ver información del planeta actual.");
        System.out.println("4. Ver información de la nave actual.");
        System.out.println("5. Volver al menú principal.");
        System.out.print("\nElige una opción: ");
    }

    public static int generateUserId() { return new Random().nextInt(9000) + 1000; }

    public static void loadMissionPanel() {
        System.out.print("Cargando panel de misión");
        for (int i = 0; i < 4; i++) {
            sleep(1000);
            System.out.print(".");
        }
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("La operación de espera fue interrumpida: " + e.getMessage());
        }
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
}