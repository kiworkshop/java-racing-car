package game.racingcar;

public class Car {
    public static final int MAX_CAR_NAME_COUNT = 5;
    public static final int INIT_SCORE = 1;

    private String name;
    private int score;

    public Car(String name, int score) {
        if (isNotValidCarName(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.score = score;
    }

    private boolean isNotValidCarName(String carName) {
        return carName.length() == 0 || carName.length() > MAX_CAR_NAME_COUNT;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(int score) {
        this.score += score;
    }


}
