package com.mission2.racingcar;


import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    public static void main(String[] args) {
        CarRacingService service = new CarRacingService();

        String[] carNames = service.getCarNames();

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i], service.INIT_NUMBER));
        }
    }

}
