package game.controller;

import game.domain.Race;
import game.view.View;
import game.view.dto.OneRoundResultDto;
import game.view.dto.UserInputDto;
import game.view.dto.WinnerDto;

public class GameController {

    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            View.printError(e);
        }
    }

    public static void start() throws Exception {
        UserInputDto userInputDto = View.getCarNamesAndRoundCountInput();

        Race race = Race.builder()
                .carNamesInput(userInputDto.getCarNames())
                .raceCountInput(userInputDto.getRoundCount())
                .build();

        View.printRaceStart();
        while (race.isRunning()) {
            race.run();
            View.printOneRoundResult(OneRoundResultDto.builder()
                    .cars(race.getCars().getCars())
                    .build());
        }
        View.printWinners(WinnerDto.builder()
                .winner(race.findWinners())
                .build());
    }
}
