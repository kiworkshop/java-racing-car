package game.racingcar;

import game.racingcar.domain.Car;
import game.racingcar.domain.RandomMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyTest {
    @Test
    @DisplayName("자동차가 움직이는 전략에 따라 자동차 위치가 1 증가한다")
    void move_strategy_forward() {
        //given
        Car car = new Car("RED", 1);

        //when
        car.move(new RandomMoveStrategy() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        //then
        assertThat(car.position()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차가 움직이는 전략에 따라 자동차 위치가 멈춘다")
    void move_strategy_stop() {
        //given
        Car car = new Car("RED", 1);

        //when
        car.move(new RandomMoveStrategy() {
            @Override
            public boolean canMove() {
                return false;
            }
        });

        //then
        assertThat(car.position()).isEqualTo(1);
    }
}
