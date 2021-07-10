package game.racingcar.domain;

import java.util.Collections;

public class RacingCar {

    static final int CAR_NAME_MAX_LENGTH = 5;

    private String name;
    private int position;
    private MoveStrategy moveStrategy;

    public RacingCar(String name) {
        this(name, new RandomMoveStrategy());
    }

    public RacingCar(String name, MoveStrategy moveStrategy) {
        if (name == null || invalidateNameLength(name)) {
            throw new IllegalArgumentException(String.format("이름의 길이는 %s 이하여야만 합니다.", CAR_NAME_MAX_LENGTH));
        }

        this.name = name;
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
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

    // TODO: 2021/07/10 toString() 메서드의 존재 이유?
    @Override
    public String toString() {
        String positionPath = String.join("", Collections.nCopies(position, "-"));
        return String.format("%s : %s", name, positionPath);
    }

    private boolean invalidateNameLength(String name) {
        return name.length() > CAR_NAME_MAX_LENGTH;
    }

}
