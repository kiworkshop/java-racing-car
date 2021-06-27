package game.domain;

import game.util.StringUtil;
import lombok.Getter;

@Getter
public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int NAME_ALIGN_STANDARD = 5;
    private static final String POSITION_MARK = "-";
    private static final String COLON = " : ";

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public boolean isNewWinner(int maxPosition) {
        return this.position > maxPosition;
    }

    public boolean isAdditionalWinner(int maxPosition) {
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
