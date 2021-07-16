package game.domain;

import lombok.Getter;

import java.util.regex.Pattern;

import static game.exception.ExceptionMessage.NONE_INTEGER_INPUT_FOR_ROUND_COUNT;
import static game.exception.ExceptionMessage.ROUND_COUNT_OUT_OF_BOUND;

public class RoundCount {

    private static final String NUMBER_REGEX = "\\d+";
    private static final int INITIAL_ROUND_COUNT = 0;
    private static final int LOWER_BOUND = 1;

    @Getter
    private final Integer targetRoundCount;
    private Integer currentRoundCount = INITIAL_ROUND_COUNT;

    public RoundCount(String raceCountInput) throws IllegalArgumentException {
        this.targetRoundCount = parseRaceCount(raceCountInput);
    }

    private int parseRaceCount(String inputLine) throws IllegalArgumentException {
        if (!Pattern.matches(NUMBER_REGEX, inputLine)) {
            throw new IllegalArgumentException(NONE_INTEGER_INPUT_FOR_ROUND_COUNT.getMessage());
        }

        int targetRaceCount = Integer.parseInt(inputLine);
        if (isRaceCountOutOfBound(targetRaceCount)) {
            throw new IllegalArgumentException(ROUND_COUNT_OUT_OF_BOUND.getMessage());
        }

        return targetRaceCount;
    }

    private boolean isRaceCountOutOfBound(int raceCount) {
        return raceCount < LOWER_BOUND;
    }

    public boolean isMoreRoundLeft() {
        return this.currentRoundCount < this.targetRoundCount;
    }

    public void increment() {
        this.currentRoundCount++;
    }
}
