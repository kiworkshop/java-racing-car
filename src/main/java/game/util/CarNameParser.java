package game.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarNameParser {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int CAR_NAME_LENGTH_LOWER_BOUND = 1;
    private static final int CAR_NAME_LENGTH_UPPER_BOUND = 5;

    public static List<String> parseCarNames(String inputLine) {
        if (isNullOrEmpty(inputLine))
            throw new RuntimeException("공백/null");

        return Arrays.stream(inputLine.split(CAR_NAME_DELIMITER))
                .filter(CarNameParser::isNameValid)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static boolean isNameValid(String name) {
        if (isLengthOutOfBound(name.length()))
            throw new RuntimeException("길이");
        return true;
    }

    private static boolean isLengthOutOfBound(int length) {
        return length > CAR_NAME_LENGTH_UPPER_BOUND || length < CAR_NAME_LENGTH_LOWER_BOUND;
    }

    private static boolean isNullOrEmpty(String inputLine) {
        return Objects.isNull(inputLine) || inputLine.isEmpty();
    }
}
