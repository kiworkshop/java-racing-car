package game.racingcar;

public class Car {

    private String name;
    private int score;

    public Car() {

    }

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.score; i++) {
            sb.append("-");
        }
        return this.name + " : " + sb.toString();
    }
}
