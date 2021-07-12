package domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int maxPosition = 0;
    private Cars cars;
    private List<Car> winners = new ArrayList<>();
    private int tryNo;

    public Race(Cars cars, int tryNo) {
        this.tryNo = tryNo;
        this.cars = cars;
    }

    public Cars getCars() {
        return this.cars;
    }

    public void run() {
        for (int i=0; i<this.tryNo; i++){
            raceOneRound();
        }
    }
    private void raceOneRound() {

        for (Car car : this.cars.getCars()){
            car.move();
        }
    }

    public List<Car> getWinners() {
        setWinners();
        return this.winners;
    }

    private void setWinners() {
        for (Car car : this.cars.getCars()) {
            updateWinner(car, winners);
        }
    }

    private void updateWinner(Car car, List<Car> winners) {
        if (car.getPosition() == maxPosition) {
            this.winners.add(car);
        }
        if (car.getPosition() > maxPosition) {
            this.winners.clear();
            this.winners.add(car);
            maxPosition = car.getPosition();
        }
    }



    public boolean isRunning() {
        tryNo--;
        return tryNo>=0;
    }
}
