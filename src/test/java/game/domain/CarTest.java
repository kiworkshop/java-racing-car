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
    void Given_NameAndPosition_When_newCar_Then_CarInstanceCreated() {
        // given
        String name = "car";
        int position = 3;

        // when
        Car car = new Car(name, position);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    void Given_NewCar_When_moveOnRandomPick_Then_PositionIsOneOrZero() {
        // given
        Car car = new Car("car");

        // when
        car.moveOnRandomPick();

        // then
        assertThat(car.getPosition()).isLessThanOrEqualTo(1);
    }
}
