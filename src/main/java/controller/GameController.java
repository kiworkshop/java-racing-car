package controller;

import view.InputView;

public class GameController {
    private static final String DEFAULT_DELIMITER = ",";

    private final InputView inputView;

    public GameController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String names = inputView.inputNames();
        validateDelimiter(names);
    }

    public void validateDelimiter(String names) {
        if (!names.contains(DEFAULT_DELIMITER)) {
            throw new RuntimeException("\",\"가 포함되어야 합니다.");
        }
    }
}
