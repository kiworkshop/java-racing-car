package game.domain;

import game.domain.Car;
import game.domain.Race;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    void 차_리스트를_받아서_우승자_찾기() {
        // given
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 5);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        Race race = new Race(cars);

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
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 5);
        Car car3 = new Car("car3", 5);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        Race race = new Race(cars);

        // when
        List<Car> winners = race.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("car2");
        assertThat(winners.get(1).getName()).isEqualTo("car3");
        assertThat(winners.get(0).getPosition()).isEqualTo(5);
        assertThat(winners.get(1).getPosition()).isEqualTo(5);
    }
    @Test
    void 레이스_한라운드_실행하면_차가_랜덤하게_전진한다() {
        // given
        Car car1 = new Car("car1", 0);
        Car car2 = new Car("car2", 0);
        Car car3 = new Car("car3", 0);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        Race race = new Race(cars);

        // when
        race.runOnce();

        // then
        List<Car> result = race.getCars();
        assertThat(result.get(0).getPosition()).isLessThanOrEqualTo(1);
        assertThat(result.get(1).getPosition()).isLessThanOrEqualTo(1);
        assertThat(result.get(2).getPosition()).isLessThanOrEqualTo(1);
    }


    @Test
    void 차_한대로_1번_경주_하면_우승자는_본인() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("winner"));
        Race race = new Race(cars);

        // when
        race.runOnce();

        // then
        assertThat(race.getWinners().size()).isEqualTo(1);
        assertThat(race.getWinners().get(0).getName()).isEqualTo("winner");
    }
}
