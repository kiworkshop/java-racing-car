package view;

import game.domain.Car;
import view.dto.ViewDto;

import java.util.List;

public class View {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static ViewDto getCarNamesAndRaceCountInput() {
        String carNamesInput = getCarNamesInput();
        String raceCountInput = getRaceCountInput();
        return new ViewDto(carNamesInput, raceCountInput);
    }

    private static String getCarNamesInput() {
        outputView.askCarNames();
        return inputView.getInput();
    }

    private static String getRaceCountInput() {
        outputView.askRaceCount();
        return inputView.getInput();
    }


    public static void printRaceStart() {
        outputView.printRaceStart();
    }

    public static void printOneRoundResult(List<Car> cars) {
        outputView.printOneRoundResult(cars);
    }

    public static void printWinners(List<Car> winners) {
        outputView.printWinners(winners);
    }
}
