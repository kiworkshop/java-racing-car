package game.racingcar.controller;

import game.racingcar.domain.RacingCar;
import game.racingcar.service.RacingCarGame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameController {

    public void play() {
        // 경주할 자동차 이름 입력 받기
        List<String> racingCarNames = Arrays.asList("red", "blue", "green");
        List<RacingCar> racingCars = createRacingCars(racingCarNames);

        // 시도 횟수 입력 받기
        int trialNumbers = 5;

        // 경기 진행
        RacingCarGame racingCarGame = new RacingCarGame(racingCars, trialNumbers);
        racingCarGame.race();

        racingCarGame.printWinner();
    }

    private List<RacingCar> createRacingCars(List<String> racingCarNames) {
        return racingCarNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

}
