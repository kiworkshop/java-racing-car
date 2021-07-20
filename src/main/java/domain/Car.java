package domain;

import org.apache.commons.lang3.StringUtils;

public class Car {

    private final String name;
    private int position;

    private static final int START_POSITION = 0;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String ALERT_NULL_OR_EMPTY = "이름을 1자 이상 입력해주세요.";
    private static final String ALERT_NAME_LENGTH = String.format("이름은 %d자 이하까지 입력할 수 있습니다.", MAXIMUM_NAME_LENGTH);
    private static final int NUMBER_TO_ADVANCE = 4;
    private static final int DISTANCE_TO_ADVANCE = 1;

    public Car(String name) {
        validateNullOrEmpty(name);
        validateNameLength(name);

        this.name = name;
        this.position = START_POSITION;
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

    public void advance(int advanceDistance) {
        this.position += advanceDistance;
    }

    public void advanceOrStop(int randomNumber) {
        advance(advanceDistance(randomNumber));
    }

    public int advanceDistance(int randomNumber) {
        if (randomNumber > NUMBER_TO_ADVANCE) {
            return DISTANCE_TO_ADVANCE;
        }
        return 0;
    }
}
