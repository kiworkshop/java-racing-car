package game.racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int STOP_POINT = 3;

    @Override
    public boolean canMove() {
        int randomNumber = new Random().nextInt(10);
        return randomNumber > STOP_POINT;
    }
}
