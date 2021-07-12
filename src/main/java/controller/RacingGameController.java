package controller;

import domain.Cars;
import domain.MovingStrategy;
import domain.Race;
import domain.RandomMovingStrategy;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameController {

    public void run() {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();
        Cars cars = new Cars(carNames);

        Race race = new Race(cars, tryNo);
        race.run();
        //OutputView.printCars(race.getCars());
        OutputView.printWinners(race.getWinners());
    }
}
