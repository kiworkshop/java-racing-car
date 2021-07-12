package domain;

import utils.CarNameParser;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static CarNameParser carNameParser = new CarNameParser();
    private List<Car> cars = new ArrayList<>();

    public Cars(String inputName){
        List<String> carNames = carNameParser.splitCarNames(inputName);
        for (String carName: carNames) {
            cars.add(new Car(carName));
        }
    }
    public Cars(List<Car> cars){
        this.cars = cars;
    }
    public List<Car> getCars(){
        return this.cars;
    }
}
