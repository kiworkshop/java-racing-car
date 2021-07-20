package view;

import utils.SplitUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DEFAULT_DELIMITER = ",";

    private InputView() {
    }

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String carNames = scanner.nextLine();
        return SplitUtils.split(carNames, DEFAULT_DELIMITER)
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int inputTrials() {
        System.out.println();
        System.out.println("시도할 회수는 몇회인가요?");
        String trials = scanner.nextLine();

        try {
            return Integer.parseInt(trials);
        } catch (NumberFormatException e) {
            System.out.println("시도 횟수는 0 이상의 숫자를 입력해주세요.");
            System.exit(0);
            throw new IllegalArgumentException();
        }
    }

}
