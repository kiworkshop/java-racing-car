package view;

import domain.CarResult;
import domain.CarResults;

import java.util.List;

public class OutputView {

    public static void askCarNamesbyComma(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public static void askTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printCars(List<CarResult> carResults) {
        for (int i = 0; i < carResults.size(); i++) {
            CarResult carResult = carResults.get(i);
            String totalGo = new String(new char[carResult.getPosition()]).replace("\0", "-");
            System.out.printf("%-7s : %s\n", carResult.getCarName(), totalGo);
        }
        System.out.println();
    }

    public static void printRounds(List<CarResults> roundResult) {
        System.out.println("실행 결과");
        for (CarResults result : roundResult) {
            printCars(result.getCarResults());
        }
    }

    public static void printWinners(List<CarResult> winners) {
        StringBuilder resultNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            resultNames.append(winners.get(i).getCarName() + ", ");
        }

        System.out.println(resultNames.toString().substring(0, resultNames.length() - 2) + "(이)가 최종 우승했습니다.");
    }
}