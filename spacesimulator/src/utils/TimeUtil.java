package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static void printTime(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

        System.out.printf("\n%s\n", message);
        System.out.println("Fecha y hora actual de la nave:");
        System.out.println(now.format(format) + "\n");
    }
}
