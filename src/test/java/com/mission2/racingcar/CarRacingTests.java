package com.mission2.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;


import static com.mission2.racingcar.CarRacingService.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CarRacingTests {

    CarRacingService carRacingService;

    @BeforeEach
    void before() {
        carRacingService = new CarRacingService();
    }

    @Test
    @DisplayName("자동차 이름을 Scanner를 통해 입력을 받는다")
    void 자동자_이름을_입력() {
        //given

        //when
        String carNames = "abc,def,ghi,add,ierul"; // 공백이 들어오는 경우 - 코딩 규약 보기
        String[] cars = carNames.split(",");

        //then
        assertThat(cars.length).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름은 문자열 5자 이하이다")
    void 자동차_이름_체크() {
        //given

        //when
        String carNames = "abc,defdddd,ghi,add,ierul";
        String[] cars = carNames.split(",");

        //then
        assertThat(checkCarNames(cars, MAX_NAME_COUNT)).isFalse();
    }

    @Test
    @DisplayName("시도 횟수 입력값이 MAX값을 초과할 경우 다시 입력 받는다")
    void 시도_횟수_체크() {
        //given

        //when
        int gameCount = 15;

        //then
        assertThat(gameCount <= MAX_GAME_COUNT).isFalse();
    }

    @Test
    @DisplayName("Random 숫자의 값을 기준 값과 비교한다")
    void Random값_비교() {
        //given

        //when
        carRacingService.compareRandom();

        //then

    }

}
