package controller;

import domain.Car;
import view.InputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    public void setUp() {
        // 사용자에게 자동차 이름, 시도횟수 입력받음
        String carNames = InputView.inputCarNames();
        int trials = InputView.inputTrials();

        // 입력받은 이름으로 자동차 생성(위치 0)
        List<Car> racingCars = createCars(Collections.singletonList(carNames));

        // 시도 횟수만큼 게임 판을 실행

        // 실행한 게임판마다 진행상황 출력

        // 가장 멀리 위치한 자동차를 우승자로 반환

    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
