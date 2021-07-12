package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 차_리스트를_받아서_우승자_찾기() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 5);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        int tryNo = 1;
        RacingGame racingGame = new RacingGame(carNames, tryNo);
        racingGame.setCars(cars);

        // when
        List<Car> winners = racingGame.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("car3");
        assertThat(winners.get(0).getPosition()).isEqualTo(5);
    }

    @Test
    void 차_리스트를_받아서_우승자_찾기_우승자가_2대일떄() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 5);
        Car car3 = new Car("car3", 5);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        int tryNo = 1;
        RacingGame racingGame = new RacingGame(carNames, tryNo);
        racingGame.setCars(cars);
        // when
        List<Car> winners = racingGame.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("car2");
        assertThat(winners.get(1).getName()).isEqualTo("car3");
        assertThat(winners.get(0).getPosition()).isEqualTo(5);
        assertThat(winners.get(1).getPosition()).isEqualTo(5);
    }

    @Test
    void 차가_확률만큼_전진한다() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");
        Car car1 = new Car("car1", () -> false);
        Car car2 = new Car("car2", () -> true);
        Car car3 = new Car("car3", () -> false);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        int tryNo = 1;

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        racingGame.setCars(cars);
        // when
        racingGame.racebyMovingStrategy();

        // then
        assertThat(racingGame.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(racingGame.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(racingGame.getCars().get(2).getPosition()).isEqualTo(0);
    }

    @Test
    void 차_한대로_1번_경주_하면_우승자는_본인() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("winner", ()-> true));
        int tryNo = 1;

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        racingGame.setCars(cars);
        // when
        racingGame.racebyMovingStrategy();

        // then
        assertThat(racingGame.getWinners().size()).isEqualTo(1);
        assertThat(racingGame.getWinners().get(0).getName()).isEqualTo("winner");
    }
}
