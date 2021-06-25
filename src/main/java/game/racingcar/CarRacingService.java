package game.racingcar;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarRacingService {
    public static final int MAX_CAR_COUNT = 5;
    public static final int MAX_GAME_COUNT = 10;
    public static final int INIT_SCORE = 1;
    public static final int FORWARD = 4;
    public static final String CAR_NAME_DELIMITER = ",";

    public void game(String[] carNames, int gameCount) {
        System.out.println("실행결과");
        Race race = initRace(carNames, gameCount);
        proceedGame(race);
        printWinner(getWinners(race.getCars()));
    }

    public boolean checkCarNames(String[] carNames) {
        long count = Arrays.stream(carNames).filter(car -> car.length() > MAX_CAR_COUNT).count();

        return (count > 0) ? false : true;
    }

    public String[] getCarNames(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER)).map(String::trim).toArray(String[]::new);
    }

    public boolean checkGameCount(int input) {
        return (input > MAX_GAME_COUNT) ? false : true;
    }

    public int getGameCount(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        return Integer.parseInt(input);
    }

    public Race initRace(String[] carNames, int gameCount) {
        Race race = new Race();
        race.setGameCount(gameCount);
        race.setCars(Arrays.stream(carNames)
                .map(carName -> new Car(carName, INIT_SCORE))
                .collect(Collectors.toList()));
        return race;
    }

    public void proceedGame(Race race) {
        for (int i = 0; i < race.getGameCount(); i++) {
            System.out.println();
            racing(race);
        }
    }

    private void racing(Race race) {
        for (Car car : race.getCars()) {
            int randomNumber = (int) (Math.random() * 10);
            car.setScore(compareRandom(randomNumber));
            System.out.println(car);
        }
    }

    public int compareRandom(int randomNumber) {
        return (randomNumber < FORWARD) ? 0 : 1;
    }

    public String[] getWinners(List<Car> cars) {
        int max = cars.stream().max(Comparator.comparing(Car::getScore)).get().getScore();

        return cars.stream().filter(car -> car.getScore() == max).map(Car::getName).toArray(String[]::new);
    }

    public void printWinner(String[] winners) {
        String winner = String.join(",", winners);
        System.out.println("\n" + winner + "가 최종 우승했습니다.");
    }
}
