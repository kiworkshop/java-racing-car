package domain;

import utils.MoveCountParser;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public RaceResult run( int tryNo) {
        MoveCountParser.checkTryNo(tryNo);
        List<CarResults> carResults = new ArrayList<>();
        for (int i = 0; i < tryNo; i++) {
            CarResults carResult = raceOneRound();
            carResults.add(carResult);
        }
        return new RaceResult(carResults);
    }

    private CarResults raceOneRound() {
        CarResults carResult = new CarResults();
        for (Car car : this.cars.getCars()) {
            car.move();
            carResult.getCarResults().add(new CarResult(car.getName(), car.getPosition()));
        }
        return carResult;
    }

}
