package controller;

import domain.AdvanceStrategy;
import domain.Car;
import service.RacingGame;
import view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    private AdvanceStrategy advanceStrategy;

    public void play() {
        // 사용자에게 자동차 이름, 시도횟수 입력받음
        List<String> carNames = InputView.inputCarNames();
        int trials = InputView.inputTrials();

        // 입력받은 이름으로 자동차 생성(위치 0)
        List<Car> racingCars = createCars(carNames, advanceStrategy);

        // 시도 횟수만큼 게임 판을 실행
        RacingGame racingGame = new RacingGame(racingCars, trials);

        // 실행한 게임판마다 진행상황 출력
        racingGame.race();

        // 가장 멀리 위치한 자동차를 우승자로 반환
        racingGame.printWinners();

    }

    private List<Car> createCars(List<String> carNames, AdvanceStrategy advanceStrategy) {
        return carNames.stream()
                .map(carName -> new Car(carName, advanceStrategy))
                .collect(Collectors.toList());
    }

}
