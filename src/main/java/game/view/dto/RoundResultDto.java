package game.view.dto;

import game.domain.Car;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundResultDto {

    @Getter
    private final List<Car> cars;

    @Builder
    public RoundResultDto(List<Car> cars) {
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
    }
}
