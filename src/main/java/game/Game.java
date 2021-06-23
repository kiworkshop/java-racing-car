package game;

import game.domain.Car;
import game.domain.Race;
import game.util.CarNameParser;
import game.util.RaceCountParser;
import view.View;
import view.dto.ViewDto;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void start() throws Exception {
        ViewDto viewDto = View.getCarNamesAndRaceCountInput();
        List<String> carNames = CarNameParser.parseCarNames(viewDto.getCarNamesInput());
        int raceCount = RaceCountParser.parseRaceCount(viewDto.getRaceCountInput());

        Race race = new Race(buildCarList(carNames));
        View.printRaceStart();
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
