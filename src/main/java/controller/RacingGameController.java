package controller;

import domain.MovingStrategy;
import domain.RacingGame;
import domain.RandomMovingStrategy;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameController {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        List<String> carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        while(racingGame.isRunning()) {
            racingGame.racebyMovingStrategy(randomMovingStrategy);
            OutputView.printCars(racingGame.getCars());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
