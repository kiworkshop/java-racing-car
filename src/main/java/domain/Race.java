package domain;

import utils.MoveCountParser;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private Cars cars;
    private static MoveCountParser moveCountParser = new MoveCountParser();
    private RaceResult raceResult = new RaceResult();

    public Race(Cars cars) {
        this.cars = cars;
    }

    public RaceResult run( int tryNo) {
        moveCountParser.checkTryNo(tryNo);
        for (int i = 0; i < tryNo; i++) {
            raceOneRound();
        }
        return raceResult;
    }

    private void raceOneRound() {
        List<Car> cars = new ArrayList<>();
        for (Car car : this.cars.getCars()) {
            car.move();
            cars.add(new Car(car));
        }
        raceResult.setRoundResult(new Cars(cars));
    }

}
