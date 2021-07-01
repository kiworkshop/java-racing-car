import controller.GameController;
import strategy.MoveStrategy;
import strategy.RandomMoveStrategy;

public class RacingGame {

    public static void main(String[] args) {
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        GameController gameController = new GameController(moveStrategy);
        gameController.run();
    }
}
