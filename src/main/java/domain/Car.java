package domain;

import org.apache.commons.lang3.StringUtils;

public class Car {
    private static final int START_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = START_POSITION;
    }

    private void validateName(String name) {
        validarteNullOrEmpty(name);
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    private void validarteNullOrEmpty(String name) {
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
}
