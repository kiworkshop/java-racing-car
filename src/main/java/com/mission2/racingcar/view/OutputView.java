package com.mission2.racingcar.view;

import com.mission2.racingcar.domain.Car;
import com.mission2.racingcar.domain.CarRacingService;
import com.mission2.racingcar.domain.Race;
import com.mission2.racingcar.domain.ThresholdFourStrategy;

import java.util.List;

import static com.mission2.racingcar.domain.CarRacingService.INIT_SCORE;

public class OutputView {

    private final CarRacingService carRacingService = new CarRacingService();

    public void printOutput(List<String> carNames, int gameCount) {
        System.out.println("실행결과");
        carNames.stream()
                .map(name -> new Car(name, INIT_SCORE, new ThresholdFourStrategy()))
                .forEach(System.out::println);

        Race race = carRacingService.initRace(gameCount, carNames);
        race.proceedGame();
        printWinner(race.getWinners());
    }

    public void printWinner(String[] winners) {
        String winner = String.join(",", winners);
        System.out.println("\n" + winner + "가 최종 우승했습니다.");
    }
}
