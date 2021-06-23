package game.domain;

import game.util.RandomPick;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public void moveOnRandomPick() {
        if (RandomPick.isMove())
            this.position++;
    }

    public String getPositionString() {
        return "-".repeat(Math.max(0, this.position));
    }
}
