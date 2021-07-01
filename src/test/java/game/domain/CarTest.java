package game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void Given_CarNameWithValidLength_When_newCar_Then_CarInstanceCreatedWithPositionZero() throws Exception {
        // given
        String name = "car";

        // when
        Car car = Car.builder()
                .name(name)
                .build();

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void Given_CarNameWithLengthLongerThanLimit_When_newCar_Then_ThrowRuntimeException() {
        // given
        String name = "123456";

        // when, then
        assertThatThrownBy(() -> Car.builder().name(name).build())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void Given_CarNameWithLengthZero_When_newCar_Then_ThrowRuntimeException() {
        // given
        String name = "";

        // when, then
        assertThatThrownBy(() -> Car.builder().name(name).build())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void Given_NewCar_When_moveForward_Then_PositionIsOne() throws Exception {
        // given
        Car car = Car.builder()
                .name("car")
                .build();

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void Given_NewCar_When_Move_Then_PositionOfCarIsOne() throws Exception {
        // given
        Car car = Car.builder()
                .name("car")
                .build();

        // when
        car.moveByFlag(true);

        // then
        assertThat(car.getPosition()).isOne();
    }

    @Test
    void Given_NewCar_When_NotMove_Then_PositionOfCarIsZero() throws Exception {
        // given
        Car car = Car.builder()
                .name("car")
                .build();

        // when
        car.moveByFlag(false);

        // then
        assertThat(car.getPosition()).isZero();
    }
}
