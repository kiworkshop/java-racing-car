package game.racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car {
    public static final int MAX_CAR_NAME_COUNT = 5;
    private static final int INIT_SCORE = 1;

    private final String name;
    private int score;

    public Car(String name, int score) {
        if (validateCarName(name)) {
            throw new IllegalArgumentException("자동차 이름은 1 ~ 5자 사이입니다.");
        }
        this.name = name;
        this.score = score;
    }

    public Car(String name) {
        this(name, INIT_SCORE);
    }

    public static boolean validateCarName(String name) {
        return name.length() == 0 || name.length() > MAX_CAR_NAME_COUNT;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return score == car.score && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
