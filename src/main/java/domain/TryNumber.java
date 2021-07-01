package domain;

public class TryNumber {
    private static final int MIN_TRY_NUMBER = 0;

    private final int tryNumber;

    public TryNumber(String tryNumber) {
        this(Integer.parseInt(tryNumber));
    }

    public TryNumber(int tryNumber) {
        validate(tryNumber);
        this.tryNumber = tryNumber;
    }

    private void validate(int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("시도 횟수 값은 0 이상이여야 합니다.");
        }
    }

    public boolean isLeft() {
        return tryNumber > MIN_TRY_NUMBER;
    }
}
