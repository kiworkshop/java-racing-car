package com.mission2.racingcar.domain;

public class ThresholdFourStrategy implements MoveStrategy {

    public static final int FORWARD_THRESHOLD = 4;

    @Override
    public boolean forward(int randomNumber) {
        return randomNumber >= FORWARD_THRESHOLD;
    }
}
