package racingGame.domain;

import org.apache.commons.lang3.StringUtils;

public class Car {

    private final String name;
    private int position;
    private final AdvanceStrategy advanceStrategy;


    private static final int START_POSITION = 0;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    public Car(String name) {
        this(name, new RandomAdvanceStrategy());
    }

    public Car(String name, AdvanceStrategy advanceStrategy) {
        if (validateNullOrEmpty(name) || validateNameLength(name)) {
            throw new IllegalArgumentException(String.format("이름은 %s자 이하까지 입력할 수 있습니다.", MAXIMUM_NAME_LENGTH));
        }

        this.name = name;
        this.position = START_POSITION;
        this.advanceStrategy = advanceStrategy;
    }

    private boolean validateNullOrEmpty(String name) {
        return StringUtils.isBlank(name);
    }

    private boolean validateNameLength(String name) {
        return name.length() > MAXIMUM_NAME_LENGTH;
    }

    public void advance(AdvanceStrategy advanceStrategy) {
        if (advanceStrategy.canAdvance()) {
            position++;
        }
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }
}
