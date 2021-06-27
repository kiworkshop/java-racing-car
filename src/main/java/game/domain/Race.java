package game.domain;

import game.RandomStrategy;
import lombok.Builder;
import view.View;

import java.util.List;

public class Race {

    private final Candidate candidate;
    private final int raceCount;

    @Builder
    public Race(List<String> carNames, int raceCount) {
        candidate = Candidate.builder()
                .carNames(carNames)
                .build();
        this.raceCount = raceCount;
    }

    public void runWith(RandomStrategy randomStrategy) {
        for (int i = 0; i < raceCount; i++) {
            candidate.runOneRoundWith(randomStrategy);
            View.printOneRoundResult(candidate);
        }
    }

    public Winner findWinners() {
        return Winner.builder()
                .candidate(candidate)
                .build();
    }
}
