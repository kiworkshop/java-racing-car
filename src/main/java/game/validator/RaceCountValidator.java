package game.validator;

public class RaceCountValidator {

    private static final int RACE_COUNT_LOWER_BOUND = 1;

    public static boolean isValid(int raceCount) throws RuntimeException {
        return raceCount >= RACE_COUNT_LOWER_BOUND;
    }
}
