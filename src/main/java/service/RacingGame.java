package service;

import domain.Car;
import domain.RandomAdvanceStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int MIN_TRIALS = 0;
    private final List<Car> racingCars;
    private int trials;


    public RacingGame(List<Car> racingCars, int trials) {
        this.racingCars = racingCars;
        this.trials = trials;
    }

    public void race() {
        System.out.println("실행 결과\n");
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

            System.out.println(car);
        }
        System.out.println();
    }


    public void printWinners() {
        List<Car> winners = findWinners();
        List<String> winnersNames = winners.stream()
                .map(Car::name)
                .collect(Collectors.toList());

        String winnersNamesList = String.join(", ", winnersNames);
        System.out.printf("%s 이(가) 최종 우승했습니다.%n", winnersNamesList);
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
