package com.mission2.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static com.mission2.racingcar.Car.checkCarNames;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CarRacingTests {

    @Test
    @DisplayName("자동차 이름을 Scanner를 통해 입력을 받는다")
    public void 자동자_이름을_입력() {
        //given

        //when
        String carNames = "abc,def,ghi,add,ierul"; // 공백이 들어오는 경우 - 코딩 규약 보기
        String[] cars = carNames.split(",");

        //then
        assertThat(cars.length).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름은 문자열 5자 이하이다")
    public void 자동차_이름() {
        //given
        
        //when
        String carNames = "abc,defdddd,ghi,add,ierul";
        String[] cars = carNames.split(",");

        //then
        assertThat(checkCarNames(cars, 5)).isFalse();
    }

}
