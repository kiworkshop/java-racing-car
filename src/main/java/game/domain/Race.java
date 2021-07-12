package game.domain;

import game.MoveStrategy;
import lombok.Builder;
import lombok.Getter;
import util.RaceCountParser;

public class Race {

    private static final int INITIAL_ROUND_COUNT = 0;

    @Getter
    private final Cars cars;
    private final int targetRoundCount;

    private int currentRoundCount = INITIAL_ROUND_COUNT;

    @Builder
    public Race(String carNamesInput, String raceCountInput) throws IllegalArgumentException {
        cars = new Cars(carNamesInput);
        this.targetRoundCount = RaceCountParser.parseRaceCount(raceCountInput);
    }

    public boolean isRunning() {
        return currentRoundCount < targetRoundCount;
    }

    public void runWith(MoveStrategy strategy) {
        currentRoundCount++;
        cars.runOneRoundWith(strategy);
    }

    public Winner findWinners() {
        return Winner.builder()
                .candidates(cars)
                .build();
    }
}
