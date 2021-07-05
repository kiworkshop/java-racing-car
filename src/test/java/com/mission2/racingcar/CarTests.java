package com.mission2.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTests {

    Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("TestCar", 0);
    }

    @Test
    @DisplayName("Random 숫자의 값이 0~3 이면 전진하지 않는다")
    void Random_값_정지() {
        //given
        int stopValues = 3;

        //when
        int stop = car.stopOrGoByRandomNumber(stopValues);

        //then
        assertThat(stop).isZero();
    }

    @Test
    @DisplayName("Random 숫자의 값이 4~9 이면 전진한다")
    void Random_값_전진() {
        //given
        int forwardValues = 4;

        //when
        int forward = car.stopOrGoByRandomNumber(forwardValues);

        //then
        assertThat(forward).isEqualTo(1);
    }

}
