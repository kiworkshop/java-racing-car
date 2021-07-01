package game;

import game.domain.Race;
import game.view.View;
import game.view.dto.OneRoundResultDto;
import game.view.dto.UserInputDto;
import game.view.dto.WinnerDto;

public class Game {

    private static final MoveStrategy strategy = new RandomMoveStrategy();

    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void start() throws Exception {
        UserInputDto userInputDto = View.getCarNamesAndRoundCountInput();

        Race race = Race.builder()
                .carNames(userInputDto.getCarNames())
                .targetRoundCount(userInputDto.getRoundCount())
                .build();

        View.printRaceStart();
        while (race.isRunning()) {
            race.runWith(strategy);
            View.printOneRoundResult(OneRoundResultDto.builder()
                    .cars(race.getCars())
                    .build());
        }
        View.printWinners(WinnerDto.builder()
                .winner(race.findWinners())
                .build());
    }
}
