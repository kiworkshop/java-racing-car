package racingGame.service;

import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.domain.RandomAdvanceStrategy;
import racingGame.view.OutputView;

import java.util.List;

public class RacingGame {
    private static final int MIN_TRIALS = 0;

    private Cars cars;
    private int trials;

    public RacingGame(final Cars cars, int trials) {
        this.cars = cars;
        this.trials = trials;
    }

    public RacingGame(List<String> carNames, int trials) {
        this(new Cars(carNames), trials);
    }

    public void race() {
        OutputView.printGameStatus();
        while (isNotOver()) {
            raceEachRound();
            trials--;
        }
    }

    private boolean isNotOver() {
        return trials > MIN_TRIALS;
    }

    private void raceEachRound() {
        for (Car car : cars.list()) {
            RandomAdvanceStrategy randomAdvanceStrategy = new RandomAdvanceStrategy();
            car.advance(randomAdvanceStrategy);

            OutputView.printEachRound(cars.list());
        }
    }

    public void printWinners() {
        OutputView.printWinners(winnerNames());
    }

    private List<String> winnerNames() {
        return cars.findWinners();
    }
}
