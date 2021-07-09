package com.mission2.racingcar.controller;

import com.mission2.racingcar.domain.CarRacingService;
import com.mission2.racingcar.view.View;

import java.util.List;

public class RacingController {

    static CarRacingService service = new CarRacingService();
    static View view = new View();

    public static void main(String[] args) {

        String inputCarNames = view.getUserInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        List<String> carNames = ensureCarNameCondition(service, inputCarNames);

        String inputGameCount = view.getUserInput("시도할 회수는 몇회인가요?");
        int gameCount = ensureGameCountCondition(service, inputGameCount);

        view.printOutput(carNames, gameCount);
    }

    private static int ensureGameCountCondition(CarRacingService service, String inputGameCount) {
        int gameCount = service.getGameCount(inputGameCount);
        while (!service.checkGameCountNotOverMaxGameCount(gameCount)) {
            String message = "게임 횟수는 " + CarRacingService.MAX_GAME_COUNT + "회를 넘을 수 없습니다.";
            gameCount = service.getGameCount(view.getUserInput(message));
        }
        return gameCount;
    }

    @org.jetbrains.annotations.NotNull
    private static List<String> ensureCarNameCondition(CarRacingService service, String inputCarNames) {
        List<String> carNames = service.splitCarNamesByComma(inputCarNames);
        while (!service.checkCarNamesNotOverMaxCarCount(carNames)) {
            String message = "자동차 이름은 " + CarRacingService.MAX_CAR_NAME_COUNT + "글자를 넘을 수 없습니다.";
            carNames = service.splitCarNamesByComma(view.getUserInput(message));
        }
        return carNames;
    }

}
