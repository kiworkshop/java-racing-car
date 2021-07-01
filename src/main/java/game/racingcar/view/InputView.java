package game.racingcar.view;

import game.racingcar.domain.Car;
import game.racingcar.domain.Race;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static String CAR_NAME_DELIMITER = ",";
    private static String CAR_NAMES_RETRY_MESSAGE = String.format("자동차 이름을 다시 입력해 주세요. (공백 또는 %s 자 초과)", Car.MAX_CAR_NAME_COUNT);
    private static String GAME_COUNT_RETRY_MESSAGE = String.format("게임 횟수는 %s 회를 넘을 수 없습니다.", Race.MAX_GAME_COUNT);

    public static List<String> getCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(CAR_NAME_DELIMITER))
                                    .map(String::trim)
                                    .collect(Collectors.toList());

        while (!isValidCarNames(carNames)) try {
            carNames.forEach(carName -> new Car(carName, Car.INIT_SCORE));

        } catch (IllegalArgumentException e) {
            getCarNames(getUserInput(CAR_NAMES_RETRY_MESSAGE));
        }

        return carNames;
    }

    public static int getGameCount(String input) {
        int gameCount = 0;
        while (!isValidGameCount(input)) try {
            gameCount = Integer.parseInt(input);

        } catch (IllegalArgumentException e) {
            getGameCount(getUserInput(GAME_COUNT_RETRY_MESSAGE));
        }
        return gameCount;
    }

    public static boolean isValidCarNames(List<String> carNames) {
        try {
            carNames.forEach(carName -> new Car(carName, Car.INIT_SCORE));
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isValidGameCount(String input) {
        try {
            Integer.parseInt(input);
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static String getUserInput(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
