package view;

import utils.CarNameParser;
import utils.MoveCountParser;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static Scanner scanner = new Scanner(System.in);
    private static CarNameParser carNameParser = new CarNameParser();
    private static MoveCountParser moveCountParser = new MoveCountParser();

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine();
    }

    public static int getTryNo() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return moveCountParser.parseCount(scanner.nextLine());
    }

}
