package view;

import domain.Car;
import domain.Cars;
import utils.CarNameParser;
import utils.MoveCountParser;

import java.util.List;

public class OutputView {

    public void printRaceStart() {
        System.out.println("실행 결과");
    }
    public static void printCars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String totalGo = new String(new char[car.getPosition()]).replace("\0", "-");
            System.out.printf("%-7s : %s\n", car.getName(), totalGo);
        }
        System.out.println();
    }
    public static void printRounds(List<Cars> roundResult){
        for (Cars cars: roundResult) {
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