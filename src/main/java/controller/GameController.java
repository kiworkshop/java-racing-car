package controller;

import domain.Names;
import domain.TryNumber;
import view.InputView;

public class GameController {

    public void run() {
        Names carNames = new Names(InputView.inputCarNames());
        TryNumber tryNumber = new TryNumber(InputView.inputTryNumber());
    }
}
