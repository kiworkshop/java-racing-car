package util;

import java.util.regex.Pattern;

import static game.exception.ExceptionMessage.NONE_INTEGER_INPUT_FOR_ROUND_COUNT;

public class RaceCountParser {

    private static final String NUMBER_REGEX = "\\d+";

    public static int parseRaceCount(String inputLine) throws RuntimeException {
        if (!Pattern.matches(NUMBER_REGEX, inputLine)) {
            throw new RuntimeException(NONE_INTEGER_INPUT_FOR_ROUND_COUNT.getMessage());
        }

        return Integer.parseInt(inputLine);
    }
}
