package game.domain;

import game.MoveStrategy;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {

    private static final int INITIAL_ROUND_COUNT = 0;
    private static final int RACE_COUNT_LOWER_BOUND = 1;

    @Getter
    private final List<Car> cars;
    private final int targetRoundCount;

    private int currentRoundCount = INITIAL_ROUND_COUNT;

    @Builder
    public Race(List<String> carNames, int targetRoundCount) throws Exception {
        validate(targetRoundCount);

        cars = Collections.unmodifiableList(generateCarList(carNames));
        this.targetRoundCount = targetRoundCount;
    }

    private List<Car> generateCarList(List<String> carNames) throws Exception {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.builder()
                    .name(carName)
                    .build());
        }
        return cars;
    }

    private void validate(int targetRaceCount) throws Exception {
        if (isRaceCountOutOfBound(targetRaceCount)) {
            throw new RuntimeException("[ERROR] 시도할 횟수는 1회 이상으로 입력하세요");
        }
    }

    private boolean isRaceCountOutOfBound(int raceCount) throws RuntimeException {
        return raceCount < RACE_COUNT_LOWER_BOUND;
    }

    public boolean isRunning() {
        return currentRoundCount < targetRoundCount;
    }

    public void runWith(MoveStrategy strategy) {
        currentRoundCount++;
        runOneRoundWith(strategy);
    }

    private void runOneRoundWith(MoveStrategy strategy) {
        for (Car car : cars) {
            car.moveByFlag(strategy.isMove());
        }
    }

    public Winner findWinners() {
        return Winner.builder()
                .candidates(cars)
                .build();
    }
}
