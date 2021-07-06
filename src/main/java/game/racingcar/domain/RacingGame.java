package game.racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final RandomMoveStrategy moveStrategy = new RandomMoveStrategy();

    private final GameCount gameCount;
    private final List<Car> cars;

    public RacingGame(GameCount gameCount, List<Car> cars) {
        this.gameCount = gameCount;
        this.cars = cars;
    }

    public RacingGame(GameCount gameCount, Car car) {
        this(gameCount, Arrays.asList(car));
    }

    public boolean isRunning() {
        return gameCount.value() > 0;
    }

    public List<Car> raceOnce() {
        gameCount.reduce();
        if (moveStrategy.canMove()) {
            cars.forEach(car -> car.move(moveStrategy));
        }
        return cars;
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
