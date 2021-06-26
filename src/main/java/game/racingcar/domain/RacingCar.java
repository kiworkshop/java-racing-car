package game.racingcar.domain;

import java.util.Collections;

public class RacingCar {

    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    // 메서드 시그니처
    public void moveBy(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position++;
        }
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
        return String.format("%s : %s", name, positionPath);
    }

}
