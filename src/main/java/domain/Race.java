package domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int maxPosition = 0;

    public List<Car> getWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            winners = updateWinner(car, winners);
        }
        return winners;
    }

    private List<Car> updateWinner(Car car, List<Car> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
        if (car.getPosition() > maxPosition) {
            winners.clear();
            winners.add(car);
            maxPosition = car.getPosition();
        }
        return winners;
    }

    public List<Car> runOnce(List<Car> cars, MovingStrategy strategy) {
        for (Car car : cars){
            car.moveByStrategy(strategy);
        }
        return cars;
    }

//    public void runRounds(List<Car> cars, int repeatCount, MovingStrategy strategy) {
//        for(int i = 0 ; i < repeatCount; i++){
//            runOnce(cars, strategy);
//        }
//    }
}
