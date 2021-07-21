package com.mission2.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoveStrategyTest {

    @DisplayName("4 이상의 정수를 입력 시 True를 반환한다")
    @Test
    void testThresholdFourStrategyGivenAboveFour() {
        //given
        MoveStrategy thresholdFourStrategy = new ThresholdFourStrategy();

        //when
        int randomNumber = 4;

        //then
        assertThat(thresholdFourStrategy.forward(4)).isTrue();
    }

    @DisplayName("4 미만의 정수를 입력 시 False를 반환한다")
    @Test
    void testThresholdFourStrategyGivenUnderFour() {
        //given
        MoveStrategy thresholdFourStrategy = new ThresholdFourStrategy();

        //when
        int randomNumber = 3;

        //then
        assertThat(thresholdFourStrategy.forward(3)).isFalse();
    }

}
