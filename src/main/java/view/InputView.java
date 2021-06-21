package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputNames() {
        String inputNames = scanner.next();
        return inputNames.trim();
    }
}
