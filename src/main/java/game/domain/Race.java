package game.domain;

import game.view.dto.RaceInputDto;
import game.view.dto.RaceResultDto;
import game.view.dto.RoundResultDto;
import game.view.dto.WinnerDto;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final Cars cars;
    private final RoundCount roundCount;

    public Race(RaceInputDto raceInputDto) throws IllegalArgumentException {
        this.cars = new Cars(raceInputDto.getCarNames());
        this.roundCount = new RoundCount(raceInputDto.getRoundCount());
    }

    public RaceResultDto run() {
        List<RoundResultDto> roundResultDtos = runRounds();
        WinnerDto winnerDto = findWinners();
        return new RaceResultDto(roundResultDtos, winnerDto);
    }

    private List<RoundResultDto> runRounds() {
        List<RoundResultDto> roundResultDtos = new ArrayList<>();
        while (roundCount.isMoreRoundLeft()) {
            runOneRound();
            roundResultDtos.add(new RoundResultDto(cars.getCars()));
        }
        return roundResultDtos;
    }

    private void runOneRound() {
        cars.move();
        roundCount.increment();
    }

    private WinnerDto findWinners() {
        Winner winner = new Winner(cars);
        return new WinnerDto(winner.getWinners());
    }
}
