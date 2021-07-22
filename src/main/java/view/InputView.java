package view;

import utils.MoveCountParser;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static MoveCountParser moveCountParser = new MoveCountParser();

    public static String getCarNames() {
        OutputView.askCarNamesbyComma();
        return SCANNER.nextLine();
    }

    public static int getTryNo() {
        OutputView.askTryNumber();
        return Integer.parseInt(SCANNER.nextLine());
    }

}
