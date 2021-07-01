package game.racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    public static final String CAR_NAME_DELIMITER = ",";
    public static final int MAX_CAR_NAME_COUNT = 5;
    private static final int INIT_SCORE = 1;

    private final String name;
    private int score;

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static List<String> getCarNameList(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Car> initCarNames(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name.trim(), INIT_SCORE))
                .collect(Collectors.toList());
    }

    public static boolean isValidCarName(String input) {
        List<String> carNameList = getCarNameList(input);

        return carNameList.stream()
                        .allMatch(name -> name.length() > 0 && name.length() <= MAX_CAR_NAME_COUNT);
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
