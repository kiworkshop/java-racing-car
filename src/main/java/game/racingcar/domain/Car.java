package game.racingcar.domain;

import java.util.Objects;

public class Car {
    public static final int MAX_CAR_NAME_COUNT = 5;
    private static final int INIT_SCORE = 1;

    private final String name;
    private int position;

    public Car(String name, int position) {
        if (validateCarName(name)) {
            throw new IllegalArgumentException("자동차 이름은 1 ~ 5자 사이입니다.");
        }
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, INIT_SCORE);
    }

    public static boolean validateCarName(String name) {
        return name.length() == 0 || name.length() > MAX_CAR_NAME_COUNT;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position += 1;
        }
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
