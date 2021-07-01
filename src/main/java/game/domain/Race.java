package game.domain;

import game.RandomStrategy;
import lombok.Builder;
import game.view.View;

import java.util.List;

public class Race {

    private static final int RACE_COUNT_LOWER_BOUND = 1;

    private final Candidate candidate;
    private final int raceCount;

    @Builder
    public Race(List<String> carNames, int raceCount) throws Exception {
        validate(raceCount);

        candidate = Candidate.builder()
                .carNames(carNames)
                .build();
        this.raceCount = raceCount;
    }

    private void validate(int raceCount) throws Exception {
        if (isRaceCountOutOfBound(raceCount)) {
            throw new RuntimeException("[ERROR] 시도할 횟수는 1회 이상으로 입력하세요");
        }
    }

    private boolean isRaceCountOutOfBound(int raceCount) throws RuntimeException {
        return raceCount < RACE_COUNT_LOWER_BOUND;
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
