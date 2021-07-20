package domain;

import java.util.Random;

public class RandomAdvanceStrategy implements AdvanceStrategy {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int RANDOM_NUMBER_THRESHOLD = 4;

    @Override
    public boolean canAdvance() {
        int randomNumber = createRandomNumber();
        return randomNumber >= RANDOM_NUMBER_THRESHOLD;
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

}
