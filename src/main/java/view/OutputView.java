package view;

import domain.Car;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printGameFlow() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printEachRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%-5s: %s", car.name(), StringUtils.repeat("-", car.position()));
            System.out.println();
        }

        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", winners));
    }
}
