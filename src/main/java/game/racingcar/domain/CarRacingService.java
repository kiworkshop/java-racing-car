package game.racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class CarRacingService {

    public Race initRace(List<String> carNames, int gameCount) {
        List<Car> carList = carNames.stream()
                .map(carName -> new Car(carName, Car.INIT_SCORE))
                .collect(Collectors.toList());

        return new Race(gameCount, carList);
    }

    public void racing(Race race) {
        for (int i = 0; i < race.getGameCount(); i++) {
            race.proceed();
            System.out.println();
        }
    }

    public List<String> getWinners(List<Car> cars) {
        int topScore = getTopScore(cars);

        return cars.stream()
                .filter(car -> car.getScore() == topScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getTopScore(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .getAsInt();
    }
}
