package com.mission2.racingcar.view;

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

}
