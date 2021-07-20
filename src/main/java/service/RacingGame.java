package service;

import domain.Car;
import domain.RandomAdvanceStrategy;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> racingCars;
    private int trials;
    private static final int MIN_TRIALS = 0;


    public RacingGame(List<Car> racingCars, int trials) {
        this.racingCars = racingCars;
        this.trials = trials;
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
        for (Car car : racingCars) {
            RandomAdvanceStrategy randomAdvanceStrategy = new RandomAdvanceStrategy();
            car.advance(randomAdvanceStrategy);

            OutputView.printEachRound(racingCars);
        }
    }


    public void printWinners() {
        List<Car> winners = findWinners();
        List<String> winnersNames = winners.stream()
                .map(Car::name)
                .collect(Collectors.toList());

        OutputView.printWinners(winnersNames);
    }


    private List<Car> findWinners() {
        int maxPosition = findMaxPosition();

        return this.racingCars.stream()
                .filter(Car -> Car.position() == maxPosition)
                .collect(Collectors.toList());
    }


    private int findMaxPosition() {
        return this.racingCars.stream()
                .map(Car::position)
                .max(Integer::compareTo)
                .orElse(0);
    }

}
