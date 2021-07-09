package game.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final RandomMoveStrategy moveStrategy = new RandomMoveStrategy();

    private final GameCount gameCount;
    private final List<Car> cars;

    public RacingGame(GameCount gameCount, List<Car> cars) {
        this.gameCount = gameCount;
        this.cars = cars;
    }

    public boolean isRunning() {
        return gameCount.value() > 0;
    }

    public void raceOnce() {
        gameCount.reduce();
        if (moveStrategy.canMove()) {
            cars.forEach(car -> car.move(moveStrategy));
        }
    }

    private int topScore(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .getAsInt();
    }

    public List<String> winners() {
        return cars.stream()
                .filter(car -> car.position() == topScore(cars))
                .map(Car::name)
                .collect(Collectors.toList());
    }

    public List<Car> cars() {
        return cars;
    }
}
