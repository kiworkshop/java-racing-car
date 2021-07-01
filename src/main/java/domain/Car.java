package domain;

import static domain.Position.START_POSITION;

public class Car {
    private static final int MOVE_NUMBER = 4;
    private static final int PER_MOVEMENT_RANGE = 1;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this(new Name(name), new Position(START_POSITION));
    }

    public Car(final String name, final int position) {
        this(new Name(name), new Position(position));
    }

    public Car(final String name, final Position position) {
        this(new Name(name), position);
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public int position() {
        return position.value();
    }

    public String name() {
        return name.value();
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            this.position = new Position(position.value() + PER_MOVEMENT_RANGE);
        }
    }

    public boolean isSamePosition(final int position) {
        return isSamePosition(new Position(position));
    }

    public boolean isSamePosition(final Position position) {
        return this.position.equals(position);
    }
}
