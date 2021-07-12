package util;

import java.util.regex.Pattern;

import static game.exception.ExceptionMessage.NONE_INTEGER_INPUT_FOR_ROUND_COUNT;

public class RaceCountParser {

    private static final String NUMBER_REGEX = "\\d+";

    public static int parseRaceCount(String inputLine) throws IllegalArgumentException {
        if (!Pattern.matches(NUMBER_REGEX, inputLine)) {
            throw new IllegalArgumentException(NONE_INTEGER_INPUT_FOR_ROUND_COUNT.getMessage());
        }

        return Integer.parseInt(inputLine);
    }
}
