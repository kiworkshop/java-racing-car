package domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private int maxPosition = 0;

    List<Cars> roundResult = new ArrayList<>();
    List<Car> winners = new ArrayList<>();

    public List<Cars> getRoundResult() {
        return roundResult;
    }

    public void setRoundResult(Cars cars) {
        this.roundResult.add(cars);
    }

    public List<Car> getWinners() {
        if(this.winners.size()>0){
            return this.winners;
        }
        for (Car car : roundResult.get(roundResult.size()-1).getCars()) {
            updateWinner(car, winners);
        }
        return this.winners;
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
}
