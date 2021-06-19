import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {

    private static final String DELIMITER = ",";
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public String inputCarNames() {
        final Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }

    public List<String> splitCarNames(String inputLine) {
        if (isNullEmpty(inputLine))
            throw new RuntimeException("공백/null");

        return Arrays.stream(inputLine.split(DELIMITER))
                .filter(this::isLengthBelowLimit)
                .collect(Collectors.toList());
    }

    private boolean isLengthBelowLimit(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT)
            throw new RuntimeException("길이");
        return true;
    }

    private boolean isNullEmpty(String inputLine) {
        return inputLine == null || inputLine.isEmpty();
    }
}
