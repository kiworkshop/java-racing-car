package game.racingcar.controller;

import game.racingcar.domain.MoveStrategy;
import game.racingcar.domain.RacingCar;
import game.racingcar.domain.RandomMoveStrategy;
import game.racingcar.domain.result.RacingGameResult;
import game.racingcar.service.RacingCarGame;
import game.racingcar.view.InputView;
import game.racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameController {

    public void play() {
        List<String> racingCarNames = InputView.inputCarNames();

        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        List<RacingCar> racingCars = createRacingCars(racingCarNames, randomMoveStrategy);

        int trialNumbers = InputView.inputTrialNumbers();

        RacingCarGame racingCarGame = new RacingCarGame(racingCars, trialNumbers);

        OutputView.printRaceResultMessage();
        RacingGameResult racingGameResult = racingCarGame.race();
        OutputView.printRacingGameResult(racingGameResult);

        List<String> winnerNames = racingCarGame.findWinnerNames();
        OutputView.printWinners(winnerNames);
    }

    private List<RacingCar> createRacingCars(List<String> racingCarNames, MoveStrategy moveStrategy) {
        return racingCarNames.stream()
                .map(carName -> new RacingCar(carName, moveStrategy))
                .collect(Collectors.toList());
    }

}
