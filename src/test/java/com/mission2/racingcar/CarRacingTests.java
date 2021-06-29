package com.mission2.racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarRacingTests {

    static CarRacingService service;
    static Car car = new Car("TestCar", 0);

    @BeforeAll
    public static void beforeAll() {
        service = new CarRacingService();
    }

    @Test
    @DisplayName("입력받은 자동차 이름의 개수를 확인한다")
    void 자동차_이름_입력() {
        //given

        //when
        String input = "AAA,BBB,CCC,DDD,EEE"; // Scanner 입력
        List<String> carNames = service.splitCarNamesByCommaToArrayList(input);

        //then
        assertThat(carNames.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름은 문자열 5자 이하이다")
    void 자동차_이름_체크() {
        //given
        String input = "AAA,BBBBBB,CCC,DDD,EEE"; // Scanner 입력

        //when
        boolean checkCarNames = service.checkCarNamesNotOverMaxCarCount(Arrays.asList(input.split(",")));

        //then
        assertThat(checkCarNames).isFalse();
    }

    @Test
    @DisplayName("시도 횟수 입력값이 정수가 아닌 경우 예외를 던진다")
    void 시도_횟수_타입_체크() {
        //given

        //when
        String gameCount = "error"; // Scanner 입력

        //then
        assertThrows(RuntimeException.class, () -> {
            service.getGameCount(gameCount);
        });
    }

    @Test
    @DisplayName("Random 숫자의 값이 0~3 이면 멈춘다")
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

    @Test
    @DisplayName("사용자가 입력한 시도 횟수만큼 반복한다")
    void 시도_횟수만큼_반복() {
        //given
        String input = "AAA,BBB,CCC,DDD,EEE"; // Scanner 입력
        List<String> carNames = Arrays.asList(input.split(","));
        int gameCount = 5;
        Race race = service.initRace(gameCount, carNames);
        service.proceedGame(race);

        //when

        //then
        assertThat(race.getGameCount()).isEqualTo(gameCount);
    }

    @Test
    @DisplayName("종료시 우승자를 출력한다")
    void 종료시_우승자_출력() {
        //given
        Car[] carList = { new Car("AAA", 3), new Car("BBB", 3),
                new Car("CCC", 4), new Car("DDD", 5) };
        Race race = new Race(5, Arrays.asList(carList));
        String[] result = race.getWinners();

        //when

        //then
        assertThat(result).hasSize(1);
        assertThat(result[0]).isEqualTo("DDD");
    }

}
