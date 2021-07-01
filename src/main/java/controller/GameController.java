package controller;

import domain.GameSystem;
import domain.Names;
import domain.TryNumber;
import view.InputView;

import java.util.Random;

public class GameController {

    private Random random;

    public GameController(Random random) {
        this.random = random;
    }

    public void run() {
        Names carNames = new Names(InputView.inputCarNames());
        TryNumber tryNumber = new TryNumber(InputView.inputTryNumber());
        GameSystem gameSystem = new GameSystem(carNames, tryNumber);

        while (gameSystem.on()) {
            gameSystem.playEachRound(random.nextInt(10));
        }
    }
}
