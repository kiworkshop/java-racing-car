package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("이름을 인자로 받아, 위치가 0인 자동차 객체를 생성한다.")
    void create() {
        //given
        String name = "name";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.position()).isEqualTo(0);
        assertThat(car.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,1", "3, 0"})
    @DisplayName("4 이상의 값을 인자로 받을 경우, 전진한다.")
    void move(int randomNumber, int expected) {
        //given
        Car car = new Car("name");

        //when
        car.move(randomNumber);

        //then
        assertThat(car.position()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, true", "1, false"})
    @DisplayName("위치 값을 인자로 받아 자신의 위치와 값이 같을 경우, 참을 반환한다.")
    void isSamePosition(int position, boolean expected) {
        //given
        Car car = new Car("name");

        //when //then
        assertThat(car.isSamePosition(position)).isEqualTo(expected);
    }
}
