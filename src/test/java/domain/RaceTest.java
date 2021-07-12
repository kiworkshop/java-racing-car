package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    void 차_리스트를_받아서_우승자_찾기() {
        // given
        Car car1 = new Car("car1", () -> true);
        Car car2 = new Car("car2", () -> false);
        Car car3 = new Car("car3", () -> false);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        Cars cars = new Cars(carList);
        int tryNo = 1;

        Race race = new Race(cars, tryNo);

        // when
        List<Car> winners = race.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("car3");
        assertThat(winners.get(0).getPosition()).isEqualTo(5);
    }

    @Test
    void 차_리스트를_받아서_우승자_찾기_우승자가_2대일떄() {
        // given
        Car car1 = new Car("car1", ()-> false);
        Car car2 = new Car("car2", ()-> true);
        Car car3 = new Car("car3", ()-> true);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        Cars cars = new Cars(carList);
        int tryNo = 1;
        Race race = new Race(cars, tryNo);
        // when
        List<Car> winners = race.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("car2");
        assertThat(winners.get(1).getName()).isEqualTo("car3");
        assertThat(winners.get(0).getPosition()).isEqualTo(1);
        assertThat(winners.get(1).getPosition()).isEqualTo(1);
    }

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
        race.run();

        // then
        assertThat(race.getCars().getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(race.getCars().getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(race.getCars().getCars().get(2).getPosition()).isEqualTo(0);
    }

    @Test
    void 차_한대로_1번_경주_하면_우승자는_본인() {
        // given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("winner", ()-> true));
        Cars cars = new Cars(carList);
        int tryNo = 1;

        Race race = new Race(cars, tryNo);
        // when
        race.run();

        // then
        assertThat(race.getWinners().size()).isEqualTo(1);
        assertThat(race.getWinners().get(0).getName()).isEqualTo("winner");
    }
}
