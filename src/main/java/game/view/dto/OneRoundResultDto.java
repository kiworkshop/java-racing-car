package game.view.dto;

import game.domain.Car;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

public class OneRoundResultDto {

    private final List<Car> cars;

    @Builder
    public OneRoundResultDto(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }
}
