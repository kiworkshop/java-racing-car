package domain;

import exception.name.InvalidNameException;
import org.apache.commons.lang3.StringUtils;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validarteNullOrEmpty(name);
        validateLength(name);
    }

    private void validarteNullOrEmpty(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new InvalidNameException("한 자리 이상의 이름을 입력해주세요.");
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameException("이름은 5자 이하여야 합니다.");
        }
    }

    public String value() {
        return name;
    }
}
