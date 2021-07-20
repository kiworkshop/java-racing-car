package domain;

import org.apache.commons.lang3.StringUtils;

public class Car {

    private final String name;
    private int position;
    private final AdvanceStrategy advanceStrategy;


    private static final int START_POSITION = 0;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String ALERT_NULL_OR_EMPTY = "이름을 1자 이상 입력해주세요.";
    private static final String ALERT_NAME_LENGTH = String.format("이름은 %d자 이하까지 입력할 수 있습니다.", MAXIMUM_NAME_LENGTH);

    public Car(String name) {
        this(name, new RandomAdvanceStrategy());
    }

    public Car(String name, AdvanceStrategy advanceStrategy) {
        validateNullOrEmpty(name);
        validateNameLength(name);

        this.name = name;
        this.position = START_POSITION;
        this.advanceStrategy = advanceStrategy;
    }

    private void validateNullOrEmpty(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(ALERT_NULL_OR_EMPTY);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ALERT_NAME_LENGTH);
        }
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public void advance() {
        if (advanceStrategy.canAdvance()) {
            position++;
        }
    }
}
