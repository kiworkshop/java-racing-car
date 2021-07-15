package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameController {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();
        Cars cars = new Cars(carNames);

        Race race = new Race(cars, tryNo);
        RaceResult result = race.run();
        OutputView.printRounds(result.getRoundResult());
        OutputView.printWinners(result.getWinners());
    }
}
