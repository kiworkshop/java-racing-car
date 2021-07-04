package strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Random RANDOM = new Random();
    private static final int FORWARD_NUMBER = 4;
    private static final int MAX_RANDOM_BOUND = 10;

    @Override
    public boolean movable() {
        return generateRandomNumber() >= FORWARD_NUMBER;
    }

    protected int generateRandomNumber() {
        return RANDOM.nextInt(MAX_RANDOM_BOUND);
    }
}
