package game.racingcar.view;

import game.racingcar.domain.Car;
import game.racingcar.domain.Race;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAMES_RETRY_MESSAGE = String.format("자동차 이름을 다시 입력해 주세요. (공백 또는 %s 자 초과)", Car.MAX_CAR_NAME_COUNT);
    private static final String GAME_COUNT_RETRY_MESSAGE = String.format("게임 횟수는 %s 회를 넘을 수 없습니다.", Race.MAX_GAME_COUNT);

    public static List<String> getCarNames(String input) {
        while (!Car.isValidCarName(input)) {
            input = getUserInput(CAR_NAMES_RETRY_MESSAGE);
        }
        return Car.getCarNameList(input);
    }

    public static int getGameCount(String input) {
        while (!Race.isValidGameCount(input)) {
            input = getUserInput(GAME_COUNT_RETRY_MESSAGE);
        }
        return Integer.parseInt(input);
    }

    public static String getUserInput(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
