package game.racingcar.view;

import game.racingcar.domain.result.RacingCarRoundResult;
import game.racingcar.domain.result.RacingGameResult;
import game.racingcar.domain.result.RacingGameRoundResult;

import java.util.List;

public class OutputView {

    private static final String WINNER_CAR_NAME_DELIMITER = ", ";

    private OutputView() {
    }

    public static void printRaceResultMessage() {
        System.out.println("실행 결과\n");
    }

    public static void printRacingGameResult(RacingGameResult racingGameResult) {
        List<RacingGameRoundResult> roundResults = racingGameResult.getRoundResults();
        for (RacingGameRoundResult roundResult : roundResults) {
            List<RacingCarRoundResult> carRoundResults = roundResult.getCarRoundResults();

            for (RacingCarRoundResult carRoundResult : carRoundResults) {
                System.out.println(carRoundResult);
            }
            System.out.println();
        }
    }

    public static void printWinners(List<String> winnerNames) {
        String joinedWinnerNames = String.join(WINNER_CAR_NAME_DELIMITER, winnerNames);
        System.out.printf("%s 이(가) 최종 우승했습니다.%n", joinedWinnerNames);
    }

}
