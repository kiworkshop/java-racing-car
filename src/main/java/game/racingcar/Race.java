package game.racingcar;

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

    public int getGameCount() {
        return this.gameCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
