package view;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputNames() {
        String inputNames = scanner.next();
        StringUtils.isBlank(inputNames);
        return inputNames.trim();
    }

    public int inputRounds() {
        int inputRounds = scanner.nextInt();
        return inputRounds;
    }
}
