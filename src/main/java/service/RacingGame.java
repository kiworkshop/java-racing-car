package service;

import domain.Car;
import domain.RandomAdvanceStrategy;

import java.util.List;

public class RacingGame {

    private static final int MIN_TRIALS = 0;
    private final List<Car> racingCars;
    private final int trials;


    public RacingGame(List<Car> racingCars, int trials) {
        this.racingCars = racingCars;
        this.trials = trials;
    }

    public void race() {
        System.out.println("실행 결과\n");
        while (isNotOver()) {
            raceEachRound();
        }
    }

    private boolean isNotOver() {
        return trials > MIN_TRIALS;
    }

    private void raceEachRound() {
        for (Car car : racingCars) {
            RandomAdvanceStrategy randomAdvanceStrategy = new RandomAdvanceStrategy();
            car.advance(randomAdvanceStrategy);

            System.out.println(car);
        }
        System.out.println();
    }


}
