package game;

import util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int STANDARD_VALUE = 4;

    @Override
    public boolean isMove() {
        int randomNumber = RandomUtil.getRandomNumber();
        return randomNumber >= STANDARD_VALUE;
    }
}
