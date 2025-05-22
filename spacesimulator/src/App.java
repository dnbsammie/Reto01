/*
 * Dev Senior | Reto 01 - Modulo 01
 * Integrantes:
 * Luis Miguel Triana Rueda
 * Samuel Esteban Rivera Mosquera
 */

import controllers.MenuController;

public class App {
    public static void main(String[] args) {
        try (MenuController menu = new MenuController()) {
            menu.run();
        } catch (Exception e) {
            System.err.println("Error durante la ejecución del programa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}