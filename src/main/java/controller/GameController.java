package controller;

import view.InputView;

import java.util.*;

public class GameController {
    private static final int ADVANCE_DETERMINATION_RANGE = 10;
    private static final String DEFAULT_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private static final Random random = new Random();
    private static final int START_POSITION = 0;
    private static final int ADVANCE_CONDITION = 4;
    private static final int ADVANCE = 1;

    private final InputView inputView;

    public GameController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String names = inputView.inputNames();
        List<String> carNames = split(names);
        validateNameLength(carNames);
        Map<String, Integer> cars = createCars(carNames);
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

    public Map<String, Integer> createCars(List<String> carNames) {
        Map<String, Integer> cars = new HashMap<>();
        carNames.forEach(carName -> cars.put(carName, START_POSITION));
        return cars;
    }

    public int generateRandomNumber() {
        return random.nextInt(ADVANCE_DETERMINATION_RANGE);
    }

    public void advance(Map.Entry<String, Integer> car, int randomNumber) {
        if (checkAdvanceCondition(randomNumber)) {
            car.setValue(car.getValue() + ADVANCE);
        }
    }

    public boolean checkAdvanceCondition(int randomNumber) {
        return randomNumber >= ADVANCE_CONDITION;
    }
}
