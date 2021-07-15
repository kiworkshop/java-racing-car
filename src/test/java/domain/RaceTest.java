package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    void 차가_확률만큼_전진한다() {
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
        Race race = new Race(cars, tryNo);

        // when
        RaceResult result = race.run();

        // then
        assertThat(result.roundResult.get(0).getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(result.roundResult.get(0).getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(result.roundResult.get(0).getCars().get(2).getPosition()).isEqualTo(0);
    }
}
