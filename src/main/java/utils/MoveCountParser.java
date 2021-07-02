package utils;

import java.util.regex.Pattern;

public class MoveCountParser {

    private static final String NUMBER_REGEX = "\\d*";

    public int parseCount(String inputLine) {
        if (!Pattern.matches(NUMBER_REGEX, inputLine) || Integer.parseInt(inputLine) < 0)
            throw new RuntimeException("이동횟수는 문자열이나 음수를 입력할 수 없습니다.");
        return Integer.parseInt(inputLine);
    }

}
