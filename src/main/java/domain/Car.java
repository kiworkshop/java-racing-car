package domain;

import org.apache.commons.lang3.StringUtils;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validarteNullOrEmpty(name);

        this.name = name;
        this.position = 0;
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
