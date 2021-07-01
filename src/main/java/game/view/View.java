package game.view;

import game.view.dto.OneRoundResultDto;
import game.view.dto.UserInputDto;
import game.view.dto.WinnerDto;
import util.CarNameParser;
import util.RaceCountParser;

import java.util.List;

public class View {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static UserInputDto getCarNamesAndRoundCountInput() {
        List<String> carNames = CarNameParser.parseCarNames(getCarNamesInput());
        int raceCount = RaceCountParser.parseRaceCount(getRaceCountInput());

        return UserInputDto.builder()
                .carNames(carNames)
                .roundCount(raceCount)
                .build();
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

    public static void printOneRoundResult(OneRoundResultDto oneRoundResultDto) {
        outputView.printOneRoundResult(oneRoundResultDto);
    }

    public static void printWinners(WinnerDto winnerDto) {
        outputView.printWinners(winnerDto);
    }

    public static void printError(Exception e) {
        outputView.printError(e.getMessage());
    }
}
