package game.racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String CAR_NAME_DELIMITER = ",";
    private static final String INIT_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String INIT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";

    private InputView() {
    }

    public static List<String> getCarNames() {
        String input = getUserInput(INIT_GAME_COUNT_MESSAGE);
        return inputCarNamesToList(input);
    }

    public static String getGameCount() {
        return getUserInput(INIT_CAR_NAMES_MESSAGE);
    }

    public static List<String> inputCarNamesToList(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static String getUserInput(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
