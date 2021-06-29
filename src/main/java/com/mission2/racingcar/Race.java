package com.mission2.racingcar;

import java.util.List;

public class Race {
    private int gameCount;
    private List<Car> cars;

    public Race(int gameCount, List<Car> cars) {
        this.gameCount = gameCount;
        this.cars = cars;
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public static class Builder {
        private final int gameCount;
        private final List<Car> cars;

        public Builder(int gameCount, List<Car> cars) {
            this.gameCount = gameCount;
            this.cars = cars;
        }

        public Race build() {
            return new Race(this);
        }
    }

    private Race(Builder builder) {
        gameCount = builder.gameCount;
        cars = builder.cars;
    }

}
