package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 차_객체_초기화_이름만_넣을경우_넣은이름_포지션은_0으로_초기화된다() {
        // given
        String car1Name = "car1";
        String car2Name = "car2";
        List<String> carNames = new ArrayList<>();
        carNames.add(car1Name);
        carNames.add(car2Name);

        // when
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        // then
        assertThat(cars.get(0).getName()).isEqualTo(car1Name);
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
        assertThat(cars.get(1).getName()).isEqualTo(car2Name);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
    }

}
