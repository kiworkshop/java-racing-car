package domain;

public class Car {
    public static final int START_POSITION = 0;
    private static final int MOVE_NUMBER = 4;
    private static final int PER_MOVEMENT_RANGE = 1;

    private final Name name;
    private int position;

    public Car(final String name) {
        this(name, START_POSITION);
    }

    public Car(final String name, final int position) {
        this(new Name(name), position);
    }

    public Car(final Name name, final int position) {
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    private void validatePosition(final int position) {
        if (position < START_POSITION) {
            throw new IllegalArgumentException("위치 값은 0 이상이여야 합니다.");
        }
    }

    public int position() {
        return position;
    }

    public String name() {
        return name.value();
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
