package game.racingcar;

import game.racingcar.controller.RacingCarGameController;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        RacingCarGameController controller = new RacingCarGameController();
        controller.play();
    }

}
