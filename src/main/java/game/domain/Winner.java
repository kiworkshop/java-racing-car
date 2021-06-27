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
    private int maxPosition;

    @Builder
    public Winner(Candidate candidate) {
        this.maxPosition = INITIAL_MAX_POSITION;
        findWinners(candidate);
    }

    private void findWinners(Candidate candidate) {
        for (Car car : candidate.getCars()) {
            updateWinner(car);
        }
    }

    private void updateWinner(Car car) {
        if (car.isAdditionalWinner(maxPosition)) {
            winners.add(car);
            return;
        }

        if (car.isNewWinner(maxPosition)) {
            winners.clear();
            winners.add(car);
            maxPosition = car.getPosition();
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
