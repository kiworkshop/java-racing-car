package com.mission2.racingcar.controller;

import com.mission2.racingcar.domain.CarRacingService;
import com.mission2.racingcar.view.View;

import java.util.List;

public class RacingController {

    private static final CarRacingService service = new CarRacingService();
    private static final View view = new View();

    public static void main(String[] args) {

        String inputCarNames = view.getUserInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        List<String> carNames = view.ensureCarNameCondition(service, inputCarNames);

        String inputGameCount = view.getUserInput("시도할 회수는 몇회인가요?");
        int gameCount = view.ensureGameCountCondition(service, inputGameCount);

        view.printOutput(carNames, gameCount);
    }

}
