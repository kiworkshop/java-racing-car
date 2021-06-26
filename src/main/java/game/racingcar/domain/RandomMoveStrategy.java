package game.racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean canMove() {
        int randomNumber = createRandomNumber();
        return randomNumber >= 4;
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
