package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {

    public static final String SPACE = " ";
    public static final String REPLACEMENT = "";
    private static final String DELIMITER = ",";
    public static final int CAR_NAME_LENGTH_MIN_LIMIT = 0;
    private static final int CAR_NAME_LENGTH_NAX_LIMIT = 5;

    public static List<String> splitCarNames(String inputLine) {
        if (isNullEmpty(inputLine))
            throw new RuntimeException("자동차이름에 공백이나 null이 올 수 없습니다.");
        return Arrays.stream(inputLine.replace(SPACE, REPLACEMENT).split(DELIMITER))
                .filter(CarNameParser::isNameValid)
                .collect(Collectors.toList());
    }

    private static boolean isNameValid(String name) {
        if (isLengthOutOfBound(name.length()))
            throw new RuntimeException("자동차 이름의 길이는 1이상 5이하값을 입력해야 합니다.");
        return true;
    }

    private static boolean isLengthOutOfBound(int length) {
        return length > CAR_NAME_LENGTH_NAX_LIMIT || length == CAR_NAME_LENGTH_MIN_LIMIT;
    }

    private static boolean isNullEmpty(String inputLine) {
        return inputLine == null || inputLine.isEmpty();
    }
}
