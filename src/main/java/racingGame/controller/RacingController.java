package racingGame.controller;

import racingGame.service.RacingGame;
import racingGame.view.InputView;

import java.util.List;

public class RacingController {

    public void play() {
        List<String> carNames = InputView.inputCarNames();
        int trials = InputView.inputTrials();

        RacingGame racingGame = new RacingGame(carNames, trials);

        racingGame.race();
        racingGame.printWinners();

    }
}
