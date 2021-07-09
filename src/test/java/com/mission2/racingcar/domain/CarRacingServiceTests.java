package com.mission2.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingServiceTests {

    @Test
    @DisplayName("입력받은 자동차 이름의 개수를 확인한다")
    void 자동차_이름_입력() {
        //given
        CarRacingService service = new CarRacingService();

        //when
        String input = "AAA,BBB,CCC,DDD,EEE"; // Scanner 입력
        List<String> carNames = service.splitCarNamesByComma(input);

        //then
        assertThat(carNames.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름 5자 초과는 허용되지 않는다")
    void 자동차_이름_길이_체크() {
        //given
        CarRacingService service = new CarRacingService();
        String input = "AAA,BBBBBB,CCC,DDD,EEE"; // Scanner 입력

        //when
        boolean carNamesNotOverMaxCarCount = service.checkCarNamesNotOverMaxCarCount(Arrays.asList(input.split(",")));

        //then
        assertThat(carNamesNotOverMaxCarCount).isFalse();
    }

    @Test
    @DisplayName("시도 횟수 입력값이 정수가 아닌 경우 예외를 던진다")
    void 시도_횟수_타입_체크() {
        //given
        CarRacingService service = new CarRacingService();

        //when
        String gameCount = "error"; // Scanner 입력

        //then
        assertThrows(RuntimeException.class, () -> {
            service.getGameCount(gameCount);
        });
    }

    @Test
    @DisplayName("사용자가 입력한 시도 횟수만큼 반복한다")
    void 시도_횟수만큼_반복() {
        //given
        CarRacingService service = new CarRacingService();
        String input = "AAA,BBB,CCC,DDD,EEE"; // Scanner 입력
        List<String> carNames = Arrays.asList(input.split(","));
        int gameCount = 5;
        Race race = service.initRace(gameCount, carNames);
        service.proceedGame(race);

        //when

        //then
        assertThat(race.getGameCount()).isEqualTo(gameCount);
    }

}
