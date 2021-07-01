package game.racingcar.domain;

import game.racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    public static final int MAX_GAME_COUNT = 10;
    private static final int FORWARD_SCORE = 1;
    private static final int STOP_POINT = 3;

    private final int gameCount;
    private final List<Car> cars;

    public Race(int gameCount, List<Car> cars) {
        this.gameCount = gameCount;
        this.cars = cars;
    }

    public void racing(Race race) {
        for (int i = 0; i < gameCount; i++) {
            race.proceed();
            System.out.println();
        }
    }

    public void proceed() {
        for (Car car : this.cars) {
            OutputView.printRace(car);
            raceOnce(car);
        }
    }

    private void raceOnce(Car car) {
        int randomNumber = (int) (Math.random() * 10);
        if (isForward(randomNumber)) {
            car.addScore(FORWARD_SCORE);
        }
    }

    public static boolean isForward(int randomNumber) {
        return randomNumber > STOP_POINT;
    }

    public List<String> getWinners() {
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

    public int getGameCount() {
        return gameCount;
    }
}
