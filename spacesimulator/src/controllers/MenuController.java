package controllers;

import java.util.Scanner;

import managers.EventManager;
import utils.ConsoleUtil;
import utils.TimeUtil;

public class MenuController implements AutoCloseable {
    private final Scanner input = new Scanner(System.in);
    private final SimulationController simulation;

    public MenuController() { this.simulation = new SimulationController(); }

    public void run() {
        EventManager.registerEvents();
        ConsoleUtil.clearConsole();
        ConsoleUtil.loadResources();

        System.out.println("\nBienvenido a bordo. Por favor, ingresa tu Alias de Comandante: ");
        String userName = input.nextLine();
        String userId = userName + "-" + ConsoleUtil.generateUserId();

        TimeUtil.printTime("¡Bienvenido a la base, comandante " + userId + "!");

        ConsoleUtil.loadMissionPanel();
        ConsoleUtil.clearConsole();

        while (true) {
            ConsoleUtil.showMenu();
            var option = ConsoleUtil.getValidOption(input, 5);

            switch (option) {
            case 1:
                simulation.planetSelector(input);
                break;
            case 2:
                simulation.shipSelector(input);
                break;
            case 3:
                simulation.settingsManager(input);
                break;
            case 4:
                simulation.spaceTrip(input);
                break;
            case 5:
                EventManager.shutDownShip(false);
                return;
            default:
                System.out.println("¡OPCIÓN INVÁLIDA! Elige una opción válida.");
            }
        }
    }

    @Override
    public void close() {
        if (input != null) {
            input.close();
        }
    }
}