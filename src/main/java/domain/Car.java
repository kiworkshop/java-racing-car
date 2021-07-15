package domain;

public class Car {

    private String name;
    private int position;
    private MovingStrategy movingStrategy = new RandomMovingStrategy();

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (this.movingStrategy.strategy())
            this.position++;
    }
}
