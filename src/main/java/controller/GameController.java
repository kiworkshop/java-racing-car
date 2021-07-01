package controller;

import domain.GameSystem;
import domain.Names;
import domain.TryNumber;
import view.InputView;
import view.OutputView;

public class GameController {

    public void run() {
        GameSystem gameSystem = setUp();
        playGame(gameSystem);
    }

    private GameSystem setUp() {
        Names carNames = new Names(InputView.inputCarNames());
        TryNumber tryNumber = new TryNumber(InputView.inputTryNumber());
        GameSystem gameSystem = new GameSystem(carNames, tryNumber);
        return gameSystem;
    }

    private void playGame(GameSystem gameSystem) {
        OutputView.printGameFlow();

        while (gameSystem.on()) {
            gameSystem.playEachRound();
            OutputView.printEachRound(gameSystem.cars());
        }

        OutputView.printWinners(gameSystem.winners());
    }
}
