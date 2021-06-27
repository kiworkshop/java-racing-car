package game;

import game.domain.Race;
import game.validator.Validator;
import view.View;
import view.dto.ViewDto;

public class Game {

    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void start() throws Exception {
        ViewDto viewDto = View.getCarNamesAndRaceCountInput();
        Validator.validate(viewDto);

        Race race = Race.builder()
                .carNames(viewDto.getCarNames())
                .raceCount(viewDto.getRaceCount())
                .build();

        View.printRaceStart();
        race.runWith(new RandomStrategyImpl());
        View.printWinners(race.findWinners());
    }
}
