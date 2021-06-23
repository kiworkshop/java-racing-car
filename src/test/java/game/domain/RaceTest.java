package game.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    private static final int LOSER_POSITION = 1;
    private static final int WINNER_POSITION = 5;

    @Test
    void Given_NewCarList_When_runOneRound_Then_PositionOfEveryCarIsOneOrZero() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        Race race = new Race(cars);

        // when
        race.runOnce();

        // then
        List<Car> result = race.getCars();
        assertThat(result.get(0).getPosition()).isLessThanOrEqualTo(1);
        assertThat(result.get(1).getPosition()).isLessThanOrEqualTo(1);
    }

    @Test
    void Given_CarListWithOneCar_When_getWinners_Then_ReturnOneWinner() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("winner"));
        Race race = new Race(cars);

        // when
        List<Car> winners = race.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("winner");
    }

    @Test
    void Given_CarListWithOneWinner_When_getWinners_Then_ReturnOneWinner() {
        // given
        Car car1 = new Car("car1", LOSER_POSITION);
        Car car2 = new Car("car2", LOSER_POSITION);
        Car car3 = new Car("winner", WINNER_POSITION);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        Race race = new Race(cars);

        // when
        List<Car> winners = race.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("winner");
        assertThat(winners.get(0).getPosition()).isEqualTo(WINNER_POSITION);
    }

    @Test
    void Given_CarListWithTwoWinners_When_getWinners_Then_ReturnTwoWinners() {
        // given
        Car car1 = new Car("car1", LOSER_POSITION);
        Car car2 = new Car("winner1", WINNER_POSITION);
        Car car3 = new Car("winner2", WINNER_POSITION);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        Race race = new Race(cars);

        // when
        List<Car> winners = race.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("winner1");
        assertThat(winners.get(1).getName()).isEqualTo("winner2");
        assertThat(winners.get(0).getPosition()).isEqualTo(WINNER_POSITION);
        assertThat(winners.get(1).getPosition()).isEqualTo(WINNER_POSITION);
    }

}
