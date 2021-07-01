package controller;

import domain.GameSystem;
import domain.Names;
import domain.TryNumber;
import view.InputView;

public class GameController {

    public void run() {
        Names carNames = new Names(InputView.inputCarNames());
        TryNumber tryNumber = new TryNumber(InputView.inputTryNumber());
        GameSystem gameSystem = new GameSystem(carNames, tryNumber);

        while (gameSystem.on()) {
            gameSystem.playEachRound();
        }
    }
}
