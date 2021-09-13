package racingGame.domain;

import java.util.Random;

public class RandomAdvanceStrategy implements AdvanceStrategy {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int RANDOM_NUMBER_THRESHOLD = 4;

    @Override
    public boolean canAdvance() {
        int randomNumber = createRandomNumber();
        return randomNumber >= RANDOM_NUMBER_THRESHOLD;
    }

    protected int createRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }
}
