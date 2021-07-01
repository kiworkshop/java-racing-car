package controller;

import domain.GameSystem;
import domain.Names;
import domain.TryNumber;
import strategy.MoveStrategy;
import view.InputView;
import view.OutputView;

public class GameController {
    private final MoveStrategy moveStrategy;

    public GameController(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        GameSystem gameSystem = setUp();
        playGame(gameSystem);
    }

    private GameSystem setUp() {
        Names carNames = new Names(InputView.inputCarNames());
        TryNumber tryNumber = new TryNumber(InputView.inputTryNumber());
        return new GameSystem(carNames, tryNumber);
    }

    private void playGame(GameSystem gameSystem) {
        OutputView.printGameFlow();

        while (gameSystem.on()) {
            gameSystem.playEachRound(moveStrategy);
            OutputView.printEachRound(gameSystem.cars());
        }

        OutputView.printWinners(gameSystem.winners());
    }
}
