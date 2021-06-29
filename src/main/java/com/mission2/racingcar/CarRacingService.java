package com.mission2.racingcar;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarRacingService {
    public static final int MAX_CAR_COUNT = 5;
    public static final int MAX_GAME_COUNT = 10;
    public static final int INIT_SCORE = 1;
    public static final int FORWARD = 4;
    public static final String CAR_NAME_DELIMITER = ",";

    public void game(List<String> carNames, int gameCount) {
        System.out.println("실행결과");
        Race race = initRace(gameCount, carNames);
        proceedGame(race);
        printWinner(getWinners(race.getCars()));
    }

    public boolean checkCarNamesNotOverMaxCarCount(List<String> carNames) {
        long count = carNames.stream().filter(car -> car.length() > MAX_CAR_COUNT).count();

        return count <= 0;
    }

    public List<String> splitCarNamesByCommaToArrayList(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean checkGameCountNotOverMaxGameCount(int input) {
        return input <= MAX_GAME_COUNT;
    }

    public int getGameCount(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        return Integer.parseInt(input);
    }

    public Race initRace(int gameCount, List<String> carNames) {
        return new Race
                .Builder(gameCount, carNames.stream()
                                    .map(carName -> new Car(carName, INIT_SCORE))
                                    .collect(Collectors.toList()))
                .build();
    }

    public void proceedGame(Race race) {
        for (int i = 0; i < race.getGameCount(); i++) {
            System.out.println();
            racing(race);
        }
    }

    /**
     * 랜덤 값으로 점수를 매기고, 결과를 출력한다.
     */
    private void racing(Race race) {
        for (Car car : race.getCars()) {
            int randomNumber = (int) (Math.random() * 10);
            car.addScore(compareRandom(randomNumber));
            System.out.println(car);
        }
    }

    /**
     * Random 값을 비교한다.
     * - (0,1,2,3) 이면 정지, (4,5,6,7,7,8,9) 이면 전진
     */
    public int compareRandom(int randomNumber) {
        return (randomNumber < FORWARD) ? 0 : 1;
    }

    /**
     * 우승한 자동차 이름을 조회한다.
     */
    public String[] getWinners(List<Car> cars) {
        int max = cars.stream()
                .max(Comparator.comparing(Car::getScore))
                .get()
                .getScore();

        return cars.stream().filter(car -> car.getScore() == max).map(Car::getName).toArray(String[]::new);
    }

    public void printWinner(String[] winners) {
        String winner = String.join(",", winners);
        System.out.println("\n" + winner + "가 최종 우승했습니다.");
    }
}
