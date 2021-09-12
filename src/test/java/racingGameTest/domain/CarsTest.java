package racingGameTest.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.service.RacingGame;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("이름을 인자로 받아서 이름만큼 자동차를 생성한다.")
    void create() {
        //given //when
        Cars cars = new Cars("Ariel", "Scott", "Pete", "Alice");

        //then
        assertThat(cars.list().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("자동차의 리스트를 반환한다.")
    void list() {
        //given
        Car car1 = new Car("Chris");
        Car car2 = new Car("Scott");
        Car car3 = new Car("Becca");
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        //when //then
        assertThat(cars.list()).containsExactly(car1, car2, car3);
    }


    @Test
    @DisplayName("자동차 경주 우승자의 이름을 추출한다.")
    void findWinners() {
        //given
        String expectedWinner1 = "car1";
        String expectedWinner2 = "car2";

        Car car1 = new Car(expectedWinner1, () -> true);
        Car car2 = new Car(expectedWinner2, () -> true);
        Car car3 = new Car("car3", () -> false);

        RacingGame racingGame = new RacingGame(new Cars(Arrays.asList(car1, car2, car3)), 8);
        racingGame.race();

        //when
        Cars cars;
        List<String> winners = cars.findWinners();

        //then

    }

}
