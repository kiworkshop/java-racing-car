package game.parser;

import java.util.regex.Pattern;

public class MoveCountParser {

    private static final String NUMBER_REGEX = "\\d";

    public int parseCount(String inputLine) {
        if (!Pattern.matches(NUMBER_REGEX, inputLine) || Integer.parseInt(inputLine) < 0)
            throw new RuntimeException("이동횟수 음수, 글자");
        return Integer.parseInt(inputLine);
    }

}
