package game.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private static final int INITIAL_MAX_POSITION = 0;
    private static final String COMMA = ", ";

    @Getter
    private final List<Car> winners = new ArrayList<>();
    private int maxPosition = INITIAL_MAX_POSITION;

    @Builder
    public Winner(List<Car> candidates) {
        findWinners(candidates);
    }

    private void findWinners(List<Car> candidates) {
        for (Car candidate : candidates) {
            updateWinner(candidate);
        }
    }

    private void updateWinner(Car candidate) {
        if (candidate.isPositionEqualTo(maxPosition)) {
            winners.add(candidate);
            return;
        }

        if (candidate.isPositionGreaterThan(maxPosition)) {
            winners.clear();
            winners.add(candidate);
            maxPosition = candidate.getPosition();
        }
    }

    @Override
    public String toString() {
        StringBuilder winnerNames = new StringBuilder();
        for (Car winner : winners) {
            winnerNames.append(winner.getName()).append(COMMA);
        }
        return removeCommaAtTheEnd(winnerNames);
    }

    private String removeCommaAtTheEnd(StringBuilder winnerNames) {
        return winnerNames.substring(0, winnerNames.length() - COMMA.length());
    }
}
