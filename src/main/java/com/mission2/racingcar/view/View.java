package com.mission2.racingcar.view;

import com.mission2.racingcar.domain.CarRacingService;

import java.util.List;

public class View {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public String getUserInput(String message) {
        return inputView.getUserInput(message);
    }

    public void printOutput(List<String> carNames, int gameCount) {
        outputView.printOutput(carNames, gameCount);
    }

    public int ensureGameCountCondition(CarRacingService service, String inputGameCount) {
        return inputView.ensureGameCountCondition(service, inputGameCount);
    }

    public List<String> ensureCarNameCondition(CarRacingService service, String inputCarNames) {
        return inputView.ensureCarNameCondition(service, inputCarNames);
    }

}
