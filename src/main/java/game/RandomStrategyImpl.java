package game;

import game.util.RandomUtil;

public class RandomStrategyImpl implements RandomStrategy {

    private static final int STANDARD_VALUE = 4;

    @Override
    public boolean isMove() {
        int randomNumber = RandomUtil.getRandomNumber();
        return randomNumber >= STANDARD_VALUE;
    }
}
