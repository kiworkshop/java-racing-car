package domain;

public class Car {

    private String name;
    private int position;
    private MovingStrategy movingStrategy = new RandomMovingStrategy();

    public Car(String name) {
        this.name = name;
    }

    public Car(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
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
