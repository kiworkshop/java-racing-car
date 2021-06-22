import java.util.ArrayList;
import java.util.List;

public class Game {

    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();
    static CarNameParser carnameParser = new CarNameParser();
    static MoveCountParser moveCountParser = new MoveCountParser();

    public static void start() {
        outputView.askCarNames();
        List<String> carNames = carnameParser.splitCarNames(inputView.getInput());

        outputView.askRepeatCount();
        int repeatCount = moveCountParser.parseCount(inputView.getInput());

        outputView.printRaceStart();

        List<Car> cars = new ArrayList<>();
        for (String carname : carNames) {
            cars.add(new Car(carname));
        }
        Race race = new Race(cars);

        for (int i = 0; i < repeatCount; i++) {
            race.runOnce();
            outputView.printOneRoundResult(race.getCars());
        }
        List<Car> winners = race.getWinners();
        outputView.printWinners(winners);
    }

}
