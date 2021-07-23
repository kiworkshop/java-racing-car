package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @Test
    void 레이스가_1회_실행되면_레이스_결과값을_리턴한다() {
        // given
        Car car1 = new Car("car1", () -> false);
        Car car2 = new Car("car2", () -> true);
        Car car3 = new Car("car3", () -> false);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        Cars cars = new Cars(carList);
        int tryNo = 1;
        Race race = new Race(cars);

        // when
        RaceResult result = race.run(tryNo);

        // then
        assertThat(result.getRoundResult().get(0).getCarResults().get(0).getPosition()).isZero();
        assertThat(result.getRoundResult().get(0).getCarResults().get(1).getPosition()).isEqualTo(1);
        assertThat(result.getRoundResult().get(0).getCarResults().get(2).getPosition()).isZero();
    }
}
