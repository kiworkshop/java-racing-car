package game.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Car {
    public static final int MAX_CAR_NAME_COUNT = 5;
    public static final int INIT_SCORE = 1;

    private final String name;
    private int score;

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static List<Car> initCarNames(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name.trim(), INIT_SCORE))
                .collect(Collectors.toList());
    }

    public static boolean isValidCarName(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() == 0 || name.length() > MAX_CAR_NAME_COUNT) {
                return false;
            }
        }
        return true;
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
}
