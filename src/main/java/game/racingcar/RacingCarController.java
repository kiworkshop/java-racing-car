package game.racingcar;

import game.racingcar.domain.Car;
import game.racingcar.domain.GameCount;
import game.racingcar.domain.RacingGame;
import game.racingcar.view.InputView;
import game.racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        GameCount gameCount = new GameCount(InputView.getGameCount());

        RacingGame racingGame = new RacingGame(gameCount, cars);

        System.out.println("실행결과");
        while (racingGame.isRunning()) {
            OutputView.printCars(racingGame.cars());
            racingGame.raceOnce();
        }

        List<String> winners = racingGame.winners();
        OutputView.printWinners(winners);
    }

}
