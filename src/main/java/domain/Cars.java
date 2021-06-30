package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Car.START_POSITION;

public class Cars {
    private static final int MIN_CARS_SIZE = 2;

    private final List<Car> cars;

    public Cars(final String... carNames) {
        this(Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(final List<Car> cars) {
        validateSize(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateSize(final List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException("자동차의 대수는 최소 1대 이상이여야 합니다.");
        }
    }

    public int size() {
        return cars.size();
    }

    public int maxPosition() {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(START_POSITION);
    }

    public List<String> winnerNames(final int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::name)
                .collect(Collectors.toList());
    }
}
