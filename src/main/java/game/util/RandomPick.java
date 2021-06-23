package game.util;

public class RandomPick {

    private static final int STANDARD_VALUE = 4;

    public static boolean isMove() {
        return (int) (Math.random() * 10) >= STANDARD_VALUE;
    }
}
