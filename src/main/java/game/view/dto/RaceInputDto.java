package game.view.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

import static game.exception.ExceptionMessage.EMPTY_INPUT;

@Getter
public class RaceInputDto {

    private final String carNames;
    private final String roundCount;

    @Builder
    public RaceInputDto(String carNames, String roundCount) throws IllegalArgumentException {
        if (isNullOrEmpty(carNames) || isNullOrEmpty(roundCount)) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }

        this.carNames = carNames;
        this.roundCount = roundCount;
    }

    private static boolean isNullOrEmpty(String inputLine) {
        return Objects.isNull(inputLine) || inputLine.isEmpty();
    }
}
