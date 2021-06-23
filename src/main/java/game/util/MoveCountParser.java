package game.util;

import java.util.regex.Pattern;

public class MoveCountParser {

    private static final String NUMBER_REGEX = "\\d";

    public static int parseMoveCount(String inputLine) throws RuntimeException {
        if (!Pattern.matches(NUMBER_REGEX, inputLine) || Integer.parseInt(inputLine) < 0)
            throw new RuntimeException("[ERROR] 시도할 횟수는 양수로 입력하세요");

        return Integer.parseInt(inputLine);
    }
}
