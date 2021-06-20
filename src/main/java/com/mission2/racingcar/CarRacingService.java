package com.mission2.racingcar;

import java.util.Arrays;

public class CarRacingService {
    public static final int MAX_NAME_COUNT = 5;
    public static final int MAX_GAME_COUNT = 10;
    public static final int FORWARD = 4;

    public static boolean checkCarNames(String[] cars, int maxCount) {
        boolean checker = true;
        long count = Arrays.stream(cars).filter(car -> car.length() > maxCount).count();
        if (count > 0) {
            checker = false;
        }

        return checker;
    }

    public boolean compareRandom() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber > FORWARD) {
            
        }

        return false;
    }
}
