package domain;

import org.apache.commons.lang3.StringUtils;

public class Car {
    public static final int START_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_NUMBER = 4;
    private static final int PER_MOVEMENT_RANGE = 1;

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, START_POSITION);
    }

    public Car(final String name, final int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(final String name) {
        validarteNullOrEmpty(name);
        validateNameLength(name);
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    private void validarteNullOrEmpty(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("한 자리 이상의 이름을 입력해주세요.");
        }
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            position += PER_MOVEMENT_RANGE;
        }
    }

    public boolean isSamePosition(final int anotherCarPosition) {
        return this.position == anotherCarPosition;
    }
}
