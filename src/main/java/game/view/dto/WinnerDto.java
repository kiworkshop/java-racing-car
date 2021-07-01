package game.view.dto;

import game.domain.Car;
import game.domain.Winner;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class WinnerDto {

    @Getter
    private final List<Car> winners;

    @Builder
    public WinnerDto(Winner winner) {
        this.winners = winner.getWinners();
    }
}
