package game.controller;

import game.domain.Race;
import game.view.View;
import game.view.dto.RaceInputDto;
import game.view.dto.RaceResultDto;

public class GameController {

    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            View.printError(e);
        }
    }

    public static void start() throws IllegalArgumentException {
        RaceInputDto raceInputDto = View.getCarNamesAndRoundCountInput();
        Race race = new Race(raceInputDto);
        RaceResultDto raceResultDto = race.run();
        View.printRaceResult(raceResultDto);
    }
}
