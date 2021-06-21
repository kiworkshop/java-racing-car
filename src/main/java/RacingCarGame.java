import controller.GameController;
import view.InputView;

public class RacingCarGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameController gameController = new GameController(inputView);
        gameController.start();
    }
}
