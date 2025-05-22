package utils;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static int getRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("El valor máximo debe ser mayor que el mínimo");
        }
        return random.nextInt(max - min + 1) + min;
    }

    public static boolean probabilityCheck(int probability) {
        if (probability < 0 || probability > 100) {
            throw new IllegalArgumentException("La probabilidad debe estar entre 0 y 100");
        }
        return random.nextInt(100) < probability;
    }

    public static double getRandomDouble(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("El valor máximo debe ser mayor que el mínimo");
        }
        return min + (max - min) * random.nextDouble();
    }
}
