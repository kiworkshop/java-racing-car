package game.domain;

import view.View;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;
    private List<Car> winners = new ArrayList<>();
    private int maxPosition = 0;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        for (Car car : cars) {
            updateWinner(car);
        }
        return winners;
    }

    private void updateWinner(Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
            return;
        }

        if (car.getPosition() > maxPosition) {
            winners.clear();
            winners.add(car);
            maxPosition = car.getPosition();
        }
    }

    public void run(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            runOneRound();
            View.printOneRoundResult(this.cars);
        }
    }

    private void runOneRound() {
        for (Car car : cars) {
            car.moveOnRandomPick();
        }
    }
}
