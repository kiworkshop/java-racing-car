package view;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getCarNames() {
        OutputView.askCarNamesbyComma();
        return SCANNER.nextLine();
    }

    public static int getTryNo() {
        OutputView.askTryNumber();
        return Integer.parseInt(SCANNER.nextLine());
    }

}
