package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCurrentPosition(Map.Entry<String, Integer> car) {
        STRING_BUILDER.setLength(0);

        for (int i = 0; i < car.getValue(); i++) {
            STRING_BUILDER.append("-");
        }

        System.out.printf("%-5s : %s\n", car.getKey(), STRING_BUILDER.toString());
    }

    public void printNextRound() {
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.printf("%s가 최종 우승했습니다.", winners);
    }
}
