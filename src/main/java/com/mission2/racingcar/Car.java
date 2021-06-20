package com.mission2.racingcar;

import java.util.Arrays;

public class Car {

    private String name;
    private int count;

    public static boolean checkCarNames(String[] cars, int maxCount) {
        boolean checker = true;
        long count = Arrays.stream(cars).filter(car -> car.length() > maxCount).count();
        if (count > 0) {
            checker = false;
        }

        return checker;
    }
}
