package game.domain;

import util.StringUtil;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Car {

    private static final int CAR_NAME_LENGTH_LOWER_BOUND = 1;
    private static final int CAR_NAME_LENGTH_UPPER_BOUND = 5;
    private static final int INITIAL_POSITION = 0;
    private static final int NAME_ALIGN_STANDARD = 5;
    private static final String POSITION_MARK = "-";
    private static final String COLON = " : ";

    private final String name;
    private int position;

    @Builder
    public Car(String name) throws Exception {
        validate(name);

        this.name = name;
        this.position = INITIAL_POSITION;
    }

    private void validate(String name) throws Exception {
        if (isLengthOutOfBound(name.length())) {
            throw new RuntimeException("[ERROR] 이름은 1글자 이상 5글자 이하로 입력하세요");
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(StringUtil.alignLeft(name, NAME_ALIGN_STANDARD))
                .append(COLON)
                .append(StringUtil.repeat(POSITION_MARK, position))
                .toString();
    }
}
