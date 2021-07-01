package game.view.dto;

import game.domain.Car;
import game.domain.Winner;
import lombok.Builder;

import java.util.List;

public class WinnerDto {

    private final List<Car> winners;

    @Builder
    public WinnerDto(Winner winner) {
        this.winners = winner.getWinners();
    }
}
