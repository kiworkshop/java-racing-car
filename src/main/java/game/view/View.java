package game.view;

import game.domain.Candidate;
import game.domain.Winner;
import util.CarNameParser;
import util.RaceCountParser;
import game.view.dto.ViewDto;

import java.util.List;

public class View {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static ViewDto getCarNamesAndRaceCountInput() {
        List<String> carNames = CarNameParser.parseCarNames(getCarNamesInput());
        int raceCount = RaceCountParser.parseRaceCount(getRaceCountInput());

        return ViewDto.builder()
                .carNames(carNames)
                .raceCount(raceCount)
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

    public static void printOneRoundResult(Candidate candidate) {
        outputView.printOneRoundResult(candidate);
    }

    public static void printWinners(Winner winner) {
        outputView.printWinners(winner);
    }
}
