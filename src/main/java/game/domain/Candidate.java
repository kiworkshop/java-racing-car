package game.domain;

import game.RandomStrategy;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Candidate {

    @Getter
    private final List<Car> cars;

    @Builder
    public Candidate(List<String> carNames) {
        this.cars = Collections.unmodifiableList(generateCarList(carNames));
    }

    private List<Car> generateCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void runOneRoundWith(RandomStrategy randomStrategy) {
        for (Car car : cars) {
            car.moveByFlag(randomStrategy.isMove());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car).append("\n");
        }
        return sb.toString();
    }
}
