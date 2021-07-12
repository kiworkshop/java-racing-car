package game.domain;

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

    public void run() {
        roundCount.increment();
        cars.runOneRound();
    }

    public Winner findWinners() {
        return Winner.builder()
                .candidates(cars)
                .build();
    }
}
