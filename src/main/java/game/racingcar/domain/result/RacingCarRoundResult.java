package game.racingcar.domain.result;

import game.racingcar.domain.RacingCar;

import java.util.Collections;

public class RacingCarRoundResult {

    private final String name;
    private final int position;

    public RacingCarRoundResult(RacingCar racingCar) {
        this.name = racingCar.getName();
        this.position = racingCar.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        String positionPath = String.join("", Collections.nCopies(position, "-"));
        return String.format("%s : %s%n", name, positionPath);
    }

}
