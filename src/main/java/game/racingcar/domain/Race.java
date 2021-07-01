package game.racingcar.domain;

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

    public static boolean isValidGameCount(String inputCount) {
        try {
            int gameCount = Integer.parseInt(inputCount);
            return gameCount <= MAX_GAME_COUNT;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean isRunning(int tryCount) {
        return gameCount > tryCount;
    }

    public void racing() {
        this.cars.forEach(this::raceOnce);
    }

    public static boolean isForward(int randomNumber) {
        return randomNumber > STOP_POINT;
    }

    private void raceOnce(Car car) {
        int randomNumber = (int) (Math.random() * 10);
        if (isForward(randomNumber)) {
            car.addScore(FORWARD_SCORE);
        }
    }

    private int getTopScore(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .getAsInt();
    }

    public List<String> getWinners() {
        int topScore = getTopScore(cars);

        return cars.stream()
                .filter(car -> car.getScore() == topScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<Car> getCars() {
        return cars;
    }
}
