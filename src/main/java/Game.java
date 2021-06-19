import java.util.ArrayList;
import java.util.List;

public class Game {

    private static InputView inputView = new InputView();
    private static CarNameParser carNameParser = new CarNameParser();
    private static MoveCountParser moveCountParser = new MoveCountParser();

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        List<String> carNames = carNameParser.splitCarNames(inputView.getInput());
        int repeatCount = moveCountParser.parseCount(inputView.getInput());

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
