package game.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("움직이는 전략을 주입하면 자동차가 전진한다.")
    @Test
    void move() {
        // given
        RacingCar racingCar = new RacingCar("red");

        // when
        racingCar.moveBy(() -> true);

        // then
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @DisplayName("움직이지 않은 전략을 주입하면 자동차가 전진하지 않는다.")
    @Test
    void move2() {
        // given
        RacingCar racingCar = new RacingCar("red");

        // when
        racingCar.moveBy(() -> false);

        // then
        assertThat(racingCar.getPosition()).isZero();
    }

}
