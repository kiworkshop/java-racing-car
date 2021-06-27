package game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void Given_Name_When_newCar_Then_CarInstanceCreatedWithPositionZero() {
        // given
        String name = "car";

        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void Given_NewCar_When_moveForward_Then_PositionIsOne() {
        // given
        Car car = new Car("car");

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void Given_NewCar_When_Move_Then_PositionOfCarIsOne() {
        // given
        Car car = new Car("car");

        // when
        car.moveByFlag(true);

        // then
        assertThat(car.getPosition()).isOne();
    }

    @Test
    void Given_NewCar_When_NotMove_Then_PositionOfCarIsZero() {
        // given
        Car car = new Car("car");

        // when
        car.moveByFlag(false);

        // then
        assertThat(car.getPosition()).isZero();
    }
}
