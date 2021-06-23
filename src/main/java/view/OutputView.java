package view;

import game.domain.Car;

import java.util.List;

public class OutputView {

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public void askRaceCount() {
        System.out.println("\n시도할 횟수는 몇 회인가요?");
    }

    public void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    public void printOneRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%-5s : ", car.getName());
            System.out.println(car.getPositionString());
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (Car winner : winners) {
            winnerNames.append(winner.getName()).append(", ");
        }

        System.out.print(winnerNames.substring(0, winnerNames.length() - 2));
        System.out.println("(이)가 최종 우승했습니다.");
    }
}