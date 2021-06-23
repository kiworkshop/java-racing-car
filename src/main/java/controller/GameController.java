package controller;

import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class GameController {
    private static final int ADVANCE_DETERMINATION_RANGE = 10;
    private static final String DEFAULT_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private static final Random random = new Random();
    private static final int START_POSITION = 0;
    private static final int ADVANCE_CONDITION = 4;
    private static final int ADVANCE = 1;
    private static final int GAME_OVER = 0;

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        String names = inputView.inputNames();
        int rounds = inputView.inputRounds();
        List<String> carNames = split(names);
        validateNameLength(carNames);
        Map<String, Integer> cars = createCars(carNames);
        outputView.printResult();
        int race = race(rounds, cars);
        int winningPosition = findWinningPosition(cars.values());
    }

    public List<String> split(String names) {
        validateDelimiter(names);
        return Arrays.stream(names.split(DEFAULT_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
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
        Map<String, Integer> cars = new LinkedHashMap<>();
        carNames.forEach(carName -> cars.put(carName, START_POSITION));
        return cars;
    }

    public int race(int rounds, Map<String, Integer> cars) {
        while (rounds > GAME_OVER) {
            cars.entrySet()
                    .forEach(car -> {
                        advance(car, generateRandomNumber());
                        outputView.printCurrentPosition(car);
                    });
            outputView.printNextRound();
            rounds--;
        }

        return rounds;
    }

    public void advance(Map.Entry<String, Integer> car, int randomNumber) {
        if (checkAdvanceCondition(randomNumber)) {
            car.setValue(car.getValue() + ADVANCE);
        }
    }

    public int generateRandomNumber() {
        return random.nextInt(ADVANCE_DETERMINATION_RANGE);
    }

    public boolean checkAdvanceCondition(int randomNumber) {
        return randomNumber >= ADVANCE_CONDITION;
    }

    public List<String> announceWinners(Map<String, Integer> cars) {
        int winningPosition = findWinningPosition(cars.values());

        return cars.entrySet()
                .stream()
                .filter(car -> car.getValue() == winningPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public int findWinningPosition(Collection<Integer> carPositions) {
        int winningPosition = START_POSITION;

        for (Integer carPosition : carPositions) {
            winningPosition = Math.max(winningPosition, carPosition);
        }

        return winningPosition;
    }
}
