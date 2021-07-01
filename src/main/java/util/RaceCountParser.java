package util;

import java.util.regex.Pattern;

public class RaceCountParser {

    private static final String NUMBER_REGEX = "\\d+";

    public static int parseRaceCount(String inputLine) throws RuntimeException {
        if (!Pattern.matches(NUMBER_REGEX, inputLine)) {
            throw new RuntimeException("[ERROR] 시도할 횟수는 숫자로 입력하세요");
        }

        return Integer.parseInt(inputLine);
    }
}
