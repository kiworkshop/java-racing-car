package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String carNames = SCANNER.nextLine();
        return carNames.trim();
    }

    public static String inputTryNumber() {
        System.out.println();
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumber = SCANNER.nextLine();
        return tryNumber.trim();
    }
}
