package racingGameTest.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingGame.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("입력받은 자동차 이름을 인자로, 위치가 0인 자동차 객체를 생성한다.")
    void create() {
        //given
        String name = "name";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.position()).isZero();
        assertThat(car.name()).isEqualTo(name);
    }


    @ParameterizedTest
    @CsvSource(value = {"true, 1", "false, 0"})
    @DisplayName("전진하는 전략이 채택되면 자동차의 위치가 1씩 증가한다.")
    void advance(boolean canAdvance, int expected) {
        //given
        Car car = new Car("name");

        //when
        car.advance(() -> canAdvance);

        //then
        assertThat(car.position()).isEqualTo(expected);
    }
}

