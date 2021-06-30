package game.racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class CarRacingService {
    public static final String CAR_NAME_DELIMITER = ",";

    public void racingGame(List<String> carNames, int gameCount) {
        System.out.println("실행결과");
        Race race = initRace(carNames, gameCount);
        racing(race);
        printWinners(getWinners(race.getCars()));
    }

    public List<String> getCarNames(String input) {
        return Arrays.asList(input.split(CAR_NAME_DELIMITER));
    }

    public boolean isValidGameCount(String input) {
        try {
            Integer.parseInt(input);
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

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
        int max = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getScore() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void printWinners(List<String> winners) {
        String winner = String.join(",", winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
