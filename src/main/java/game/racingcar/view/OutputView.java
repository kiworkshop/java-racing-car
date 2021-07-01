package game.racingcar.view;

import java.util.List;

public class OutputView {

    public static void printWinners(List<String> winners) {
        String winner = String.join(",", winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
