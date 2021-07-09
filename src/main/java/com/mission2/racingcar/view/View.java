package com.mission2.racingcar.view;

public class View {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public String getUserInput(String message) {
        return inputView.getUserInput(message);
    }


}
