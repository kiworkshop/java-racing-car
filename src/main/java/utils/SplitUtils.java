package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtils {

    private SplitUtils() {
    }

    public static List<String> split(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
