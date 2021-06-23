package game;

import game.domain.Car;
import game.domain.Race;
import game.util.CarNameParser;
import game.util.MoveCountParser;
import view.View;
import view.dto.ViewDto;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        ViewDto viewDto = View.getCarNamesAndRaceCountInput();
        List<String> carNames = CarNameParser.parseCarNames(viewDto.getCarNamesInput());
        int raceCount = MoveCountParser.parseMoveCount(viewDto.getRaceCountInput());

        Race race = new Race(buildCarList(carNames));
        race.run(raceCount);
        View.printWinners(race.findWinners());
    }

    private static List<Car> buildCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

}
