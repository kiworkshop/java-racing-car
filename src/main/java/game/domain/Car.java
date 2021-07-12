package game.domain;

import lombok.Builder;
import lombok.Getter;

import static game.exception.ExceptionMessage.CAR_NAME_LENGTH_OUT_OF_BOUND;

@Getter
public class Car {

    private static final int CAR_NAME_LENGTH_LOWER_BOUND = 1;
    private static final int CAR_NAME_LENGTH_UPPER_BOUND = 5;
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private int position;

    @Builder
    public Car(String name) throws IllegalArgumentException {
        validate(name);

        this.name = name;
        this.position = INITIAL_POSITION;
    }

    private void validate(String name) throws IllegalArgumentException {
        if (isLengthOutOfBound(name.length())) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OUT_OF_BOUND.getMessage());
        }
    }

    private boolean isLengthOutOfBound(int length) {
        return length > CAR_NAME_LENGTH_UPPER_BOUND || length < CAR_NAME_LENGTH_LOWER_BOUND;
    }

    public boolean isPositionGreaterThan(int maxPosition) {
        return this.position > maxPosition;
    }

    public boolean isPositionEqualTo(int maxPosition) {
        return this.position == maxPosition;
    }

    public void moveByFlag(boolean isMove) {
        if (isMove) {
            moveForward();
        }
    }

    public void moveForward() {
        this.position++;
    }
}
