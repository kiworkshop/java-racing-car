package game.validator;

import java.util.List;

public class CarNameValidator {

    private static final int CAR_NAME_LENGTH_LOWER_BOUND = 1;
    private static final int CAR_NAME_LENGTH_UPPER_BOUND = 5;

    public static boolean isValid(List<String> carNames) throws RuntimeException {
        return carNames.stream()
                .noneMatch(carName -> isLengthOutOfBound(carName.length()));
    }

    private static boolean isLengthOutOfBound(int length) {
        return length > CAR_NAME_LENGTH_UPPER_BOUND || length < CAR_NAME_LENGTH_LOWER_BOUND;
    }
}
