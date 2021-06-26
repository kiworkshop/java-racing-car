package game.racingcar.service;

import game.racingcar.domain.RacingCar;
import game.racingcar.domain.RandomMoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final List<RacingCar> racingCars;
    private final int trialNumbers;

    public RacingCarGame(List<RacingCar> racingCars, int trialNumbers) {
        this.racingCars = racingCars;
        this.trialNumbers = trialNumbers;
    }

    public void race() {
        System.out.println("실행 결과\n");
        for (int trial = 0; trial < trialNumbers; trial++) {
            raceOneRound();
        }
    }

    private void raceOneRound() {
        for (RacingCar racingCar : racingCars) {
            RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
            racingCar.moveBy(randomMoveStrategy);

            System.out.println(racingCar);
        }
        System.out.println();
    }

    public void printWinner() {
        List<RacingCar> winners = findWinners();
        List<String> winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.toList());

        String joinedWinnerNames = String.join(", ", winnerNames);
        System.out.printf("%s 이(가) 최종 우승했습니다.%n", joinedWinnerNames);
    }

    public List<RacingCar> findWinners() {
        int maxPosition = findMaxPosition();

        return this.racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return this.racingCars.stream()
                .map(RacingCar::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

}
