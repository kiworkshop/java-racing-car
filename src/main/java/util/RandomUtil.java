package util;

public class RandomUtil {

    private static final int NUMBER_RANGE = 10;

    public static int getRandomNumber() {
        return (int) (Math.random() * NUMBER_RANGE);
    }
}
