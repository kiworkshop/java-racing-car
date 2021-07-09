package com.mission2.racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

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

    public String[] getWinners() {

        int max = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(NoSuchElementException::new);

        return cars.stream().filter(car -> car.getScore() == max).map(Car::getName).toArray(String[]::new);
    }

    public void proceedGame() {
        for (int i = 0; i < gameCount; i++) {
            System.out.println();
            racing();
        }
    }

    private void racing() {
        for (Car car : cars) {
            Random random = new Random();
            car.raceByRandomNumber(random.nextInt(10));
            System.out.println(car);
        }
    }

    public static class Builder {
        private int gameCount;
        private List<Car> cars;

        public Builder() {

        }

        public Builder gameCount(int gameCount) {
            this.gameCount = gameCount;
            return this;
        }

        public Builder cars(List<Car> cars) {
            this.cars = cars;
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
