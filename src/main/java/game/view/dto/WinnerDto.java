package game.view.dto;

import game.domain.Car;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerDto {

    @Getter
    private final List<Car> cars;

    public WinnerDto(List<Car> cars) {
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
    }
}
