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

    public void game(String[] carNames, int gameCount) {
        System.out.println("실행결과");
        Race race = initRace(carNames, gameCount);
        proceedGame(race);
        printWinner(getWinners(race.getCars()));
    }

    /**
     * 자동차 이름 문자열 길이를 확인한다.
     */
    public boolean checkCarNames(String[] carNames) {
        long count = Arrays.stream(carNames).filter(car -> car.length() > MAX_CAR_COUNT).count();

        return count <= 0;
    }

    /**
     * 자동차 이름의 배열을 만든다.
     */
    public String[] getCarNames(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER)).map(String::trim).toArray(String[]::new);
    }

    /**
     * 게임 횟수를 확인한다.
     */
    public boolean checkGameCount(int input) {
        return input <= MAX_GAME_COUNT;
    }

    /**
     * 게임 횟수의 입력값을 확인한다.
     */
    public int getGameCount(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자 입력 값(자동차 이름, 게임 횟수)을 초기화 한다.
     */
    public Race initRace(String[] carNames, int gameCount) {
        Race race = new Race();
        race.setGameCount(gameCount);
        race.setCars(Arrays.stream(carNames)
                .map(carName -> new Car(carName, INIT_SCORE))
                .collect(Collectors.toList()));
        return race;
    }

    /**
     * 게임 횟수 만큼 레이스를 진행한다.
     */
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

    /**
     * 레이스 우승 자동차를 출력한다.
     */
    public void printWinner(String[] winners) {
        String winner = String.join(",", winners);
        System.out.println("\n" + winner + "가 최종 우승했습니다.");
    }
}
