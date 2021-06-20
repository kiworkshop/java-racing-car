package com.mission2.racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarRacingService {
    public static final int MAX_NAME_COUNT = 5;
    public static final int MAX_GAME_COUNT = 10;
    public static final int INIT_NUMBER = 1;
    public static final int FORWARD = 4;
    public static final String DELIMITER = ",";

    private static final CarRacingService service = new CarRacingService();

    public static CarRacingService getInstance() {
        return service;
    }

    private CarRacingService() {

    }

    public boolean checkCarNames(String[] cars, int maxCount) {
        boolean checker = true;
        long count = Arrays.stream(cars).filter(car -> car.length() > maxCount).count();
        if (count > 0) {
            checker = false;
        }

        return checker;
    }

    public String[] getCarNames() {
        String message = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
        String[] carNames = getUserInput(message).split(DELIMITER);

        while (!checkCarNames(carNames, MAX_NAME_COUNT)) {
            System.out.println("자동차 이름은 " + MAX_NAME_COUNT + "글자를 넘을 수 없습니다.");
            carNames = getUserInput(message).split(DELIMITER);
        }
        return carNames;
    }

    /**
     * TODO Integer Exception 추가 필요
     *
     * @return
     */
    public int getGameCount() {
        String message = "시도할 회수는 몇회인가요?";
        int count = Integer.parseInt(getUserInput(message));

        while (count > MAX_GAME_COUNT) {
            System.out.println("게임 횟수는 " + MAX_GAME_COUNT + "회를 넘을 수 없습니다.");
            count = Integer.parseInt(getUserInput(message));
        }
        return count;
    }

    private String getUserInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int compareRandom(int randomNumber) {
        if (randomNumber >= FORWARD) {
            return 1;
        }
        return 0;
    }

    public Race initRace(String[] carNames, int gameCount) {
        Race race = new Race();
        race.setGameCount(gameCount);

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName, INIT_NUMBER));
        }
        race.setCars(carList);
        return race;
    }

    public void proceedGame(Race race) {
        for (int i = race.getGameCount(); i > 0; i--) {
            for (Car car : race.getCars()) {
                setScore(car);
            }
            race.setRestCount(i-1);
        }
    }

    public void setScore(Car car) {
        int randomNumber = (int) (Math.random() * 10);
        int score = car.getScore() + service.compareRandom(randomNumber);
        car.setScore(score);
    }
}
