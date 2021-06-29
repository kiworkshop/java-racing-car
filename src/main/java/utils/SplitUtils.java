package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class SplitUtils {

    private SplitUtils() {
    }

    public static List<String> split(String input, String delimiter) {
        if (!input.contains(delimiter)) {
            throw new IllegalArgumentException(format("\"%s\" 구분자가 존재하는 지 확인해주세요.", delimiter));
        }

        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
