package domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private Cars cars;
    private int tryNo;
    private RaceResult raceResult = new RaceResult();

    public Race(Cars cars, int tryNo) {
        this.tryNo = tryNo;
        this.cars = cars;
    }

    public RaceResult run() {
        for (int i=0; i<this.tryNo; i++){
            raceOneRound();
        }
        return raceResult;
    }

    private void raceOneRound() {
        List<Car> cars = new ArrayList<>();
        for (Car car : this.cars.getCars()){
            car.move();
            cars.add(new Car(car.getName(), car.getPosition()));
        }
        raceResult.setRoundResult(new Cars(cars));
    }

}
