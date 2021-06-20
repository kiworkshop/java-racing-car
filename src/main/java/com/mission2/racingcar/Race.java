package com.mission2.racingcar;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Race {
    private int gameCount;
    private int restCount;
    private List<Car> cars;

    public Race() {
        this.gameCount = 0;
        this.restCount = 0;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public void setRestCount(int restCount) {
        this.restCount = restCount;
    }

    public void setCars(List<Car> carList) {
        this.cars = carList;
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public int getRestCount() {
        return this.restCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
