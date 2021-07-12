package game.domain;

import game.MoveStrategy;
import lombok.Builder;
import lombok.Getter;

public class Race {

    @Getter
    private final Cars cars;
    private final RoundCount roundCount;

    @Builder
    public Race(String carNamesInput, String raceCountInput) throws IllegalArgumentException {
        this.cars = new Cars(carNamesInput);
        this.roundCount = new RoundCount(raceCountInput);
    }

    public boolean isRunning() {
        return roundCount.isMoreRoundLeft();
    }

    public void runWith(MoveStrategy strategy) {
        roundCount.increment();
        cars.runOneRoundWith(strategy);
    }

    public Winner findWinners() {
        return Winner.builder()
                .candidates(cars)
                .build();
    }
}
