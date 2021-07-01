package game.racingcar;

import game.racingcar.domain.Car;
import game.racingcar.domain.Race;
import game.racingcar.view.InputView;
import game.racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private static final String INIT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INIT_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {
        String inputCarNames = InputView.getUserInput(INIT_CAR_NAMES_MESSAGE);
        List<String> carNames = InputView.getCarNames(inputCarNames);

        String inputGameCount = InputView.getUserInput(INIT_GAME_COUNT_MESSAGE);
        int gameCount = InputView.getGameCount(inputGameCount);

        Race race = new Race(gameCount, Car.initCarNames(carNames));

        int tryCount = 0;
        while(race.isRunning(tryCount)) {
            OutputView.printCars(race.getCars());
            race.racing();
            tryCount++;
        }
        OutputView.printWinners(race.getWinners());
    }

}
