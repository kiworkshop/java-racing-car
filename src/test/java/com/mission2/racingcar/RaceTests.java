package com.mission2.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTests {

    @Test
    @DisplayName("종료시 우승자를 출력한다")
    void 종료시_우승자_출력() {
        //given
        Car[] carList = {new Car("AAA", 3), new Car("BBB", 3),
                new Car("CCC", 4), new Car("DDD", 5)};
        Race race = new Race(5, Arrays.asList(carList));
        String[] winners = race.getWinners();

        //when

        //then
        assertThat(winners).hasSize(1);
        assertThat(winners[0]).isEqualTo("DDD");
    }
}
