package util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static game.exception.ExceptionMessage.EMPTY_INPUT_FOR_CAR_NAME;

public class CarNameParser {

    private static final String CAR_NAME_DELIMITER = ",";

    public static List<String> parseCarNames(String inputLine) throws RuntimeException {
        if (isNullOrEmpty(inputLine)) {
            throw new RuntimeException(EMPTY_INPUT_FOR_CAR_NAME.getMessage());
        }

        return Arrays.stream(inputLine.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static boolean isNullOrEmpty(String inputLine) {
        return Objects.isNull(inputLine) || inputLine.isEmpty();
    }
}
