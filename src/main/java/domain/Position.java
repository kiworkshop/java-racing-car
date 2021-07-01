package domain;

import java.util.Objects;

public class Position {
    public static final int START_POSITION = 0;

    private final int position;

    public Position(final int position) {
        validate(position);
        this.position = position;
    }

    private void validate(final int position) {
        if (position < START_POSITION) {
            throw new IllegalArgumentException("위치 값은 0 이상이여야 합니다.");
        }
    }

    public int value() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
