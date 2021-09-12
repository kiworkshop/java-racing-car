package racingGame.service;

import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.domain.RandomAdvanceStrategy;
import racingGame.view.OutputView;

import java.util.List;

public class RacingGame {

    private Cars cars;
    private int trials;
    private static final int MIN_TRIALS = 0;

    public RacingGame(final Cars cars, int trials) {
        this.cars = cars;
        this.trials = trials;
    }

    public RacingGame(final String carNames, int trials) {
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
        for (Car car : cars) {
            RandomAdvanceStrategy randomAdvanceStrategy = new RandomAdvanceStrategy();
            car.advance(randomAdvanceStrategy);

            OutputView.printEachRound(cars);
        }
    }

    public void printWinners() {
        OutputView.printWinners(winnerNames());
    }

    private List<String> winnerNames() {
        return cars.findWinners();
    }
}
