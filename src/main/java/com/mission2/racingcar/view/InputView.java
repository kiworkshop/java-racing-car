package com.mission2.racingcar.view;

import com.mission2.racingcar.domain.CarRacingService;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String getUserInput(String message) {
        System.out.println(message);

        return scanner.nextLine();
    }

    public int ensureGameCountCondition(CarRacingService service, String inputGameCount) {
        int gameCount = service.getGameCount(inputGameCount);
        while (!service.checkGameCountNotOverMaxGameCount(gameCount)) {
            String message = "게임 횟수는 " + CarRacingService.MAX_GAME_COUNT + "회를 넘을 수 없습니다.";
            gameCount = service.getGameCount(getUserInput(message));
        }
        return gameCount;
    }

    @org.jetbrains.annotations.NotNull
    public List<String> ensureCarNameCondition(CarRacingService service, String inputCarNames) {
        List<String> carNames = service.splitCarNamesByComma(inputCarNames);
        while (!service.checkCarNamesNotOverMaxCarCount(carNames)) {
            String message = "자동차 이름은 " + CarRacingService.MAX_CAR_NAME_COUNT + "글자를 넘을 수 없습니다.";
            carNames = service.splitCarNamesByComma(getUserInput(message));
        }
        return carNames;
    }

}
