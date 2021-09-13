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
        Cars cars = new Cars(Arrays.asList("Ariel", "Scott", "Pete", "Alice"));

        //then
        assertThat(cars.list().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("자동차의 리스트를 반환한다.")
    void list() {
        //given
        List<String> carNames = Arrays.asList("Chris", "Scott", "Becca");
        Cars cars = new Cars(carNames);

        Car car1 = new Car("Chris");
        Car car2 = new Car("Becca");
        Car car3 = new Car("Becca");

        //when //then
        assertThat(cars.list()).containsExactly(car1, car2, car3);
    }


    @Test
    @DisplayName("자동차 경주 우승자의 이름을 추출한다.")
    void findWinners() {
        //given
        String expectedWinner1 = "car1";
        String expectedWinner2 = "car2";

        List<String> carNames = Arrays.asList(expectedWinner1, expectedWinner2, "car3");
        Cars cars = new Cars(carNames);

        RacingGame racingGame = new RacingGame(carNames, 8);
        racingGame.race();

        //when
        List<String> winners = cars.findWinners();

        //then
        assertThat(winners).contains("car1", "car2");
    }

}
