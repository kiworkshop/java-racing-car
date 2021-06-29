package utils;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    private RandomUtils() {
    }

    public static int generateRandomNumber(int maxBound) {
        return random.nextInt(maxBound);
    }
}
