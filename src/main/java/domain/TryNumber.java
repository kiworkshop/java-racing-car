package domain;

import exception.trynumber.InvalidTryNumberException;

import java.util.Objects;

public class TryNumber {
    private static final int MIN_TRY_NUMBER = 0;
    public static final int DEFAULT_VALUE_FOR_REDUCTION = 1;

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
            throw new InvalidTryNumberException("시도 횟수 값은 0 이상이여야 합니다.");
        }
    }

    public boolean isLeft() {
        return tryNumber > MIN_TRY_NUMBER;
    }

    public TryNumber reduce() {
        return new TryNumber(tryNumber - DEFAULT_VALUE_FOR_REDUCTION);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNumber tryNumber1 = (TryNumber) o;
        return tryNumber == tryNumber1.tryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNumber);
    }
}
