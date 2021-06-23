package view;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String inputNames = scanner.nextLine();
        StringUtils.isBlank(inputNames);
        return inputNames.trim();
    }

    public int inputRounds() {
        System.out.println();
        System.out.println("시도할 회수는 몇회인가요?");
        int inputRounds = scanner.nextInt();
        return inputRounds;
    }
}
