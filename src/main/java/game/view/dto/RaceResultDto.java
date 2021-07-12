package game.view.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class RaceResultDto {

    private final List<RoundResultDto> roundResultDtos;
    private final WinnerDto winnerDto;

    public RaceResultDto(List<RoundResultDto> roundResultDtos, WinnerDto winnerDto) {
        this.roundResultDtos = Collections.unmodifiableList(new ArrayList<>(roundResultDtos));
        this.winnerDto = winnerDto;
    }
}
