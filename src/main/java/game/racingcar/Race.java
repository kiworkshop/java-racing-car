package game.racingcar;

import java.util.List;

public class Race {

    public static final int MAX_GAME_COUNT = 10;

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

}
