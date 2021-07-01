package domain;

import strategy.MoveStrategy;

public class Car {
    private static final int PER_MOVEMENT_RANGE = 1;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this(new Name(name), new Position());
    }

    public Car(final Name name) {
        this(name, new Position());
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

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position = position.plus(PER_MOVEMENT_RANGE);
        }
    }

    public boolean isSamePosition(final int position) {
        return isSamePosition(new Position(position));
    }

    public boolean isSamePosition(final Position position) {
        return this.position.equals(position);
    }
}
