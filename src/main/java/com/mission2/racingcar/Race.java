package com.mission2.racingcar;

import java.util.List;
import java.util.NoSuchElementException;

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

    public String[] getWinners() {

        int max = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(NoSuchElementException::new);

        return cars.stream().filter(car -> car.getScore() == max).map(Car::getName).toArray(String[]::new);
    }

    public static class Builder {
        private int gameCount;
        private final List<Car> cars;

        public Builder(List<Car> cars) {
            this.cars = cars;
        }

        public Builder gameCount(int gameCount) {
            this.gameCount = gameCount;
            return this;
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
