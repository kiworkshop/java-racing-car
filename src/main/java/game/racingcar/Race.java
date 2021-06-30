package game.racingcar;

import java.util.Collections;
import java.util.List;

public class Race {

    public static final int MAX_GAME_COUNT = 10;
    public static final int FORWARD_SCORE = 1;
    public static final int STOP_POINT = 3;
    public static final String RACE_RESULT_DELIMITER = "-";

    private int gameCount;
    private List<Car> cars;

    public Race(int gameCount, List<Car> cars) {
        this.gameCount = gameCount;
        this.cars = cars;
    }

    public void proceed() {
        for (Car car : this.cars) {
            printRace(car);
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

    public void printRace(Car car) {
        String raceResult = String.join("", Collections.nCopies(car.getScore(), RACE_RESULT_DELIMITER));
        String printFormat = String.format("%s : %s", car.getName(), raceResult);
        System.out.println(printFormat);
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
