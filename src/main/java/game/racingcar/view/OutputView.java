package game.racingcar.view;

import game.racingcar.domain.Car;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final String RACE_RESULT_DELIMITER = "-";

    public static void printRace(Car car) {
        String raceResult = String.join("", Collections.nCopies(car.getScore(), RACE_RESULT_DELIMITER));
        String printFormat = String.format("%s : %s", car.getName(), raceResult);
        System.out.println(printFormat);
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(",", winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
