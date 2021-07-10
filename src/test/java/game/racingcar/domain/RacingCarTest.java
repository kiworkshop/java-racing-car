package game.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarTest {

    @DisplayName("자동차 이름이 5자 이상이 되면 생성에 실패한다.")
    @Test
    void createRacingCar() {
        // given
        String name = "purple";

        // when // then
        assertThrows(IllegalArgumentException.class, () -> new RacingCar(name));
    }

    @DisplayName("움직이는 전략을 주입하면 자동차가 전진한다.")
    @Test
    void move() {
        // given
        RacingCar racingCar = new RacingCar("red", () -> true);

        // when
        racingCar.move();

        // then
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @DisplayName("움직이지 않은 전략을 주입하면 자동차가 전진하지 않는다.")
    @Test
    void move2() {
        // given
        RacingCar racingCar = new RacingCar("red", () -> false);

        // when
        racingCar.move();

        // then
        assertThat(racingCar.getPosition()).isZero();
    }

}
