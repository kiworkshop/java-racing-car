import java.util.List;

public class OutputView {
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public void askRepeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceStart() {
        System.out.println("실행 결과");
    }

    public void printOneRoundResult(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.printf("%-5s : ", car.getName());

            for (int j = 0; j < car.getPosition(); j++) {
                System.out.printf("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        StringBuilder resultNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            resultNames.append(winners.get(i).getName() + ", ");
        }

        System.out.println(resultNames.toString().substring(0, resultNames.length() - 2) + "(이)가 최종 우승했습니다.");
    }
}