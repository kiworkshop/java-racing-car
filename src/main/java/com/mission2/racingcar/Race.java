package com.mission2.racingcar;

import java.util.List;

public class Race {
    private int gameCount;
    private List<Car> cars;

    public Race() {
        this.gameCount = 0;
    }

    public Race(int gameCount, List<Car> cars) {
        this.gameCount = gameCount;
        this.cars = cars;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public void setCars(List<Car> carList) {
        this.cars = carList;
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
