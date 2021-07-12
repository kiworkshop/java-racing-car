package game.view;

import game.view.dto.RaceInputDto;
import game.view.dto.RaceResultDto;

public class View {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static RaceInputDto getCarNamesAndRoundCountInput() throws IllegalArgumentException {
        String carNamesInput = getCarNamesInput();
        String raceCountInput = getRaceCountInput();

        return RaceInputDto.builder()
                .carNames(carNamesInput)
                .roundCount(raceCountInput)
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

    public static void printRaceResult(RaceResultDto raceResultDto) {
        outputView.printRaceResult(raceResultDto);
    }

    public static void printError(Exception e) {
        outputView.printError(e.getMessage());
    }
}
