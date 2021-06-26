package game.racingcar.domain;

import java.util.Collections;
import java.util.Random;

public class RacingCar {

    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        String positionPath = String.join("", Collections.nCopies(position, "-"));
        return String.format("%s : %s", name, positionPath);
    }

}
