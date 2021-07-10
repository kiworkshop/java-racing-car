package game.racingcar.service;

import game.racingcar.domain.RacingCar;
import game.racingcar.domain.result.RacingCarRoundResult;
import game.racingcar.domain.result.RacingGameResult;
import game.racingcar.domain.result.RacingGameRoundResult;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final List<RacingCar> racingCars;
    private final int trialNumbers;

    public RacingCarGame(List<RacingCar> racingCars, int trialNumbers) {
        this.racingCars = racingCars;
        this.trialNumbers = trialNumbers;
    }

    public RacingGameResult race() {
        RacingGameResult racingGameResult = new RacingGameResult();
        for (int trial = 0; trial < trialNumbers; trial++) {
            RacingGameRoundResult roundResult = raceOneRound();
            racingGameResult.addRoundResult(roundResult);
        }

        return racingGameResult;
    }

    private RacingGameRoundResult raceOneRound() {
        RacingGameRoundResult roundResult = new RacingGameRoundResult();
        for (RacingCar racingCar : racingCars) {
            racingCar.move();

            RacingCarRoundResult carRoundResult = new RacingCarRoundResult(racingCar);
            roundResult.addCarRoundResult(carRoundResult);
        }

        return roundResult;
    }

    public List<String> findWinnerNames() {
        List<RacingCar> winners = findWinners();

        return winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.toList());
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
