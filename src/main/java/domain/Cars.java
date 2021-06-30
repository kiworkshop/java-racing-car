package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_CARS_SIZE = 2;

    private final List<Car> cars;

    public Cars(String... carNames) {
        this(Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        validateSize(cars);
        this.cars = cars;
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException("자동차의 대수는 최소 1대 이상이여야 합니다.");
        }
    }

    public int size() {
        return cars.size();
    }
}
