import controller.GameController;

import java.util.Random;

public class RacingGame {

    public static void main(String[] args) {
        Random random = new Random();
        GameController gameController = new GameController(random);
        gameController.run();
    }
}
