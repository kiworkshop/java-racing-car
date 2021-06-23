package game.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarNameParser {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int CAR_NAME_LENGTH_LOWER_BOUND = 1;
    private static final int CAR_NAME_LENGTH_UPPER_BOUND = 5;

    public static List<String> parseCarNames(String inputLine) throws RuntimeException {
        if (isNullOrEmpty(inputLine))
            throw new RuntimeException("[ERROR] 이름을 입력하세요");

        return Arrays.stream(inputLine.split(CAR_NAME_DELIMITER))
                .filter(CarNameParser::isNameValid)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static boolean isNameValid(String name) throws RuntimeException {
        if (isLengthOutOfBound(name.length()))
            throw new RuntimeException("[ERROR] 이름은 1글자 이상 5글자 이하로 입력하세요");
        return true;
    }

    private static boolean isLengthOutOfBound(int length) {
        return length > CAR_NAME_LENGTH_UPPER_BOUND || length < CAR_NAME_LENGTH_LOWER_BOUND;
    }

    private static boolean isNullOrEmpty(String inputLine) {
        return Objects.isNull(inputLine) || inputLine.isEmpty();
    }
}
