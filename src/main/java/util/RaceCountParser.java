package util;

import java.util.regex.Pattern;

import static game.exception.ExceptionMessage.NONE_INTEGER_INPUT_FOR_ROUND_COUNT;
import static game.exception.ExceptionMessage.ROUND_COUNT_OUT_OF_BOUND;

public class RaceCountParser {

    private static final String NUMBER_REGEX = "\\d+";
    private static final int RACE_COUNT_LOWER_BOUND = 1;

    public static int parseRaceCount(String inputLine) throws IllegalArgumentException {
        if (!Pattern.matches(NUMBER_REGEX, inputLine)) {
            throw new IllegalArgumentException(NONE_INTEGER_INPUT_FOR_ROUND_COUNT.getMessage());
        }

        int targetRaceCount = Integer.parseInt(inputLine);
        if (isRaceCountOutOfBound(targetRaceCount)) {
            throw new IllegalArgumentException(ROUND_COUNT_OUT_OF_BOUND.getMessage());
        }

        return targetRaceCount;
    }

    private static boolean isRaceCountOutOfBound(int raceCount) {
        return raceCount < RACE_COUNT_LOWER_BOUND;
    }
}
