package domain;

public class Car {

    private final String name;
    private final int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String name() {
        return name;
    }

    public int postion() {
        return position;
    }

}
