package racingGame.domain;

import java.util.Random;

public class RandomAdvanceStrategy implements AdvanceStrategy {

    private static final Random random = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int RANDOM_NUMBER_THRESHOLD = 4;

    @Override
    public boolean canAdvance() {
        int randomNumber = createRandomNumber();
        return randomNumber >= RANDOM_NUMBER_THRESHOLD;
    }

    // protected: 동일 패키지 내 클래스 또는 해당 클래스를 상속받은 외부 클래스의 패키지에서 접근 가능
    protected int createRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
