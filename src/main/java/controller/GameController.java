package controller;

import view.InputView;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private static final String DEFAULT_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    private final InputView inputView;

    public GameController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String names = inputView.inputNames();
        List<String> splitNames = split(names);
    }

    public List<String> split(String names) {
        validateDelimiter(names);
        return Arrays.asList(names.split(DEFAULT_DELIMITER));
    }

    private void validateDelimiter(String names) {
        if (!names.contains(DEFAULT_DELIMITER)) {
            throw new RuntimeException("\",\"가 포함되어야 합니다.");
        }
    }

    public void validateNameLength(List<String> names) {
        boolean isOverLength = names.stream()
                .anyMatch(name -> name.length() > MAX_NAME_LENGTH);

        if (isOverLength) {
            throw new RuntimeException("이름은 5자 이하여야 합니다.");
        }
    }
}
