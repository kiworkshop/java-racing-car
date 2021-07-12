package game.view;

import game.view.dto.OneRoundResultDto;
import game.view.dto.UserInputDto;
import game.view.dto.WinnerDto;

import java.util.Objects;

import static game.exception.ExceptionMessage.EMPTY_INPUT;

public class View {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static UserInputDto getCarNamesAndRoundCountInput() {
        String carNamesInput = getCarNamesInput();
        String raceCountInput = getRaceCountInput();

        if (isNullOrEmpty(carNamesInput) || isNullOrEmpty(raceCountInput)) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }

        return UserInputDto.builder()
                .carNames(carNamesInput)
                .roundCount(raceCountInput)
                .build();
    }

    private static boolean isNullOrEmpty(String inputLine) {
        return Objects.isNull(inputLine) || inputLine.isEmpty();
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
