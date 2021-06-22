package com.mission2.racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.mission2.racingcar.CarRacingService.*;
import static org.assertj.core.api.Assertions.*;

public class CarRacingTests {

    static CarRacingService service;

    @BeforeAll
    public static void beforeAll() {
        service = new CarRacingService();
    }

    @Test
    @DisplayName("자동차 이름을 입력을 받는다")
    void 자동차_이름_입력() {
        //given

        //when
        String input = "abc,def,ghi,add,ierul"; // 공백이 들어오는 경우 - 코딩 규약 보기
        String[] carNames = input.split(",");

        //then
        assertThat(carNames.length).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름은 문자열 5자 이하이다")
    void 자동차_이름_체크() {
        //given

        //when
        String input = "abc,defdddd,ghi,add,ierul";
        String[] carNames = input.split(",");

        //then
        assertThat(service.checkCarNames(carNames, MAX_NAME_COUNT)).isFalse();
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
    void Random_값_비교() {
        //given

        //when
        int stop = service.compareRandom(1);
        int forward = service.compareRandom(4);

        //then
        assertThat(stop).isEqualTo(0);
        assertThat(forward).isEqualTo(1);
    }

    @Test
    @DisplayName("사용자가 입력한 시도 횟수만큼 반복한다")
    void 시도_횟수만큼_반복() {
        //given
        String input = "abc,def,ghi,add,ierul";
        String[] carNames = input.split(",");

        //when
        int gameCount = 5;
        Race race = service.initRace(carNames, gameCount);
        service.proceedGame(race);

        //then
        assertThat(race.getGameCount()).isEqualTo(gameCount);
    }

    @Test
    @DisplayName("종료시 우승자를 출력한다")
    void 종료시_우승자_출력() {
        //given
        Car[] temp = { new Car("aaa", 3), new Car("bbb", 3),
            new Car("ccc", 4), new Car("ddd", 5),
            new Car("eee", 5), new Car("fff", 2) };
        Race race = new Race(5, Arrays.asList(temp));

        //when
        String[] winners = service.getWinners(race.getCars());

        //then
        service.printWinner(winners);
    }



}
