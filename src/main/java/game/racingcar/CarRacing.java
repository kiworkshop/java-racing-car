package game.racingcar;

import java.util.List;
import java.util.Scanner;

public class CarRacing {

    public static void main(String[] args) {
        CarRacingService service = new CarRacingService();

        String inputCarName = getUserInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        List<String> carNames = service.getCarNames(inputCarName);
        boolean checkCarNames = false;

        while (!checkCarNames) try {
            carNames.forEach(carName -> new Car(carName, Car.INIT_SCORE));
            checkCarNames = true;

        } catch (IllegalArgumentException e) {
            String message = String.format("자동차 이름을 다시 입력해 주세요. (공백 또는 %s 자 초과)", Car.MAX_CAR_NAME_COUNT);
            carNames = service.getCarNames(getUserInput(message));
        }

        String inputGameCount = getUserInput("시도할 회수는 몇회인가요?");
        while (!service.isValidGameCount(inputGameCount)) {
            String message = String.format("게임 횟수는 %s 회를 넘을 수 없습니다.", Race.MAX_GAME_COUNT);
            inputGameCount = getUserInput(message);
        }
        int gameCount = Integer.parseInt(inputGameCount);

        service.racingGame(carNames, gameCount);
    }

    /**
     * Scanner 통해 사용자에게 입력 받는다.
     */
    public static String getUserInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine().trim();
    }

}
