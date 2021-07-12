package game.domain;

import game.MoveStrategy;
import game.exception.ExceptionMessage;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    protected static final String CAR_NAME_DELIMITER = ",";

    @Getter
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public Cars(String carNamesInput) throws IllegalArgumentException {
        validate(carNamesInput);

        this.cars = Collections.unmodifiableList(generateCarList(parseCarNames(carNamesInput)));
    }

    private void validate(String carNamesInput) throws IllegalArgumentException {
        if (isNullOrEmpty(carNamesInput)) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.getMessage());
        }
    }

    private boolean isNullOrEmpty(String carNamesInput) {
        return Objects.isNull(carNamesInput) || carNamesInput.isEmpty();
    }

    private List<String> parseCarNames(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<Car> generateCarList(List<String> carNames) throws IllegalArgumentException {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.builder()
                    .name(carName)
                    .build());
        }
        return cars;
    }

    public void runOneRoundWith(MoveStrategy strategy) {
        for (Car car : cars) {
            car.moveByFlag(strategy.isMove());
        }
    }
}