package view;

import domain.Car;
import domain.Cars;

import java.util.List;

public class OutputView {

    public static void askCarNamesbyComma(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public static void askTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printCars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String totalGo = new String(new char[car.getPosition()]).replace("\0", "-");
            System.out.printf("%-7s : %s\n", car.getName(), totalGo);
        }
        System.out.println();
    }

    public static void printRounds(List<Cars> roundResult) {
        System.out.println("실행 결과");
        for (Cars cars : roundResult) {
            printCars(cars.getCars());
        }
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder resultNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            resultNames.append(winners.get(i).getName() + ", ");
        }

        System.out.println(resultNames.toString().substring(0, resultNames.length() - 2) + "(이)가 최종 우승했습니다.");
    }
}