package game;

import game.domain.Car;
import game.domain.Race;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        start();
    }

    public static void start() {

        List<String> carNames = outputView.askCarNames();
        int repeatCount = outputView.askRepeatCount();
        outputView.printRaceStart();

        List<Car> cars = new ArrayList<>();
        for (String carname : carNames) {
            cars.add(new Car(carname));
        }

        Race race = new Race(cars);
        for (int i = 0; i < repeatCount; i++) {
            race.runOnce();
            outputView.printOneRoundResult(race.getCars());
        }

        List<Car> winners = race.getWinners();
        outputView.printWinners(winners);
    }

}
