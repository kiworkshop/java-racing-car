package com.mission2.racingcar.domain;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarRacingService {
    public static final int MAX_CAR_NAME_COUNT = 5;
    public static final int MAX_GAME_COUNT = 10;
    public static final int INIT_SCORE = 1;
    public static final String CAR_NAME_DELIMITER = ",";

    public boolean checkCarNamesNotOverMaxCarCount(List<String> carNames) {
        long count = carNames.stream().filter(car -> car.length() > MAX_CAR_NAME_COUNT).count();

        return count <= 0;
    }

    public List<String> splitCarNamesByComma(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean checkGameCountNotOverMaxGameCount(int input) {
        return input <= MAX_GAME_COUNT;
    }

    public int getGameCount(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        return Integer.parseInt(input);
    }

    public Race initRace(int gameCount, List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(carName -> new Car(carName, INIT_SCORE, new ThresholdFourStrategy()))
                .collect(Collectors.toList());

        return new Race
                .Builder()
                .cars(carList)
                .gameCount(gameCount)
                .build();
    }

}
