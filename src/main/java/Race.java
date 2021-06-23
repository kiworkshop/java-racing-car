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

    public List<Car> getWinners() {
        for (Car car : cars) {
            updateWinner(car);
        }
        return winners;
    }

    private void updateWinner(Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
        if (car.getPosition() > maxPosition) {
            winners.clear();
            winners.add(car);
            maxPosition = car.getPosition();
        }
    }

    public void runOnce() {
        for (Car car : cars)
            car.moveOnRandomPick();
    }

    public void runRounds(int repeatCount) {
        for(int i = 0 ; i < repeatCount; i++){
            runOnce();
        }
    }
}
