package game.domain;

import game.AlwaysMoveStrategy;
import game.AlwaysNotMoveStrategy;
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
    void Given_CarNameWithLengthLongerThanLimit_When_newCar_Then_ThrowIllegalArgumentException() {
        // given
        String name = "123456";

        // when, then
        assertThatThrownBy(() -> Car.builder().name(name).build())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Given_CarNameWithLengthZero_When_newCar_Then_ThrowIllegalArgumentException() {
        // given
        String name = "";

        // when, then
        assertThatThrownBy(() -> Car.builder().name(name).build())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Given_AlwaysMoveCar_When_move_Then_PositionOfCarIsMoveCount() throws Exception {
        // given
        Car car = new Car("car", new AlwaysMoveStrategy());
        int moveCount = 1000;

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        // then
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }

    @Test
    void Given_AlwaysNotMoveCar_When_move_Then_PositionOfCarIsZero() throws Exception {
        // given
        Car car = new Car("car", new AlwaysNotMoveStrategy());
        int moveCount = 1000;

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
