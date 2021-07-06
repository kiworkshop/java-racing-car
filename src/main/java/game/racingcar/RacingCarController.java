package game.racingcar;

import game.racingcar.domain.Car;
import game.racingcar.domain.GameCount;
import game.racingcar.domain.Race;
import game.racingcar.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        GameCount gameCount = new GameCount(InputView.getGameCount());

        Race race = new Race(gameCount, cars);

    }

}
