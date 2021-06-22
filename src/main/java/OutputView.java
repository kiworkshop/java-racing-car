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

    public void printRaceResult (List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.printf("%5s : ", car.getName());

            for(int j = 0; j < car.getPosition(); j++){
                System.out.printf("-");
            }
            System.out.println();
        }
    }

}