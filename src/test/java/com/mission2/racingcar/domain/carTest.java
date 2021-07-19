package com.mission2.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class carTest {

    private final MoveStrategy moveStrategy = new ThresholdFourStrategy();

    @Test
    @DisplayName("Random 숫자의 값이 0~3 이면 전진하지 않는다")
    void Random_값_정지() {
        //given
        Car car = new Car("TestCar", 0, moveStrategy);
        int stopValues = 3;

        //when
        int stopIsZero = car.stopOrGoByRandomNumber(stopValues);

        //then
        assertThat(stopIsZero).isZero();
    }

    @Test
    @DisplayName("Random 숫자의 값이 4~9 이면 전진한다")
    void Random_값_전진() {
        //given
        Car car = new Car("TestCar", 0, moveStrategy);
        int forwardValues = 4;

        //when
        int goForwardIsOne = car.stopOrGoByRandomNumber(forwardValues);

        //then
        assertThat(goForwardIsOne).isEqualTo(1);
    }

}
