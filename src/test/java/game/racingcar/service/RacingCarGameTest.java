package game.racingcar.service;

import game.racingcar.domain.RacingCar;
import game.racingcar.domain.result.RacingGameResult;
import game.racingcar.domain.result.RacingGameRoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class RacingCarGameTest {

    @DisplayName("자동차 게임 실행 후 결과를 반환한다.")
    @Test
    void race() {
        // given
        RacingCar racingCar1 = new RacingCar("car1", () -> true);
        RacingCar racingCar2 = new RacingCar("car2", () -> true);
        RacingCar racingCar3 = new RacingCar("car3", () -> false);

        RacingCarGame racingCarGame = new RacingCarGame(Arrays.asList(racingCar1, racingCar2, racingCar3), 1);

        // when
        RacingGameResult racingGameResult = racingCarGame.race();

        // then
        assertThat(racingGameResult).isNotNull();
        List<RacingGameRoundResult> roundResults = racingGameResult.getRoundResults();

        assertThat(roundResults).hasSize(1);

        RacingGameRoundResult racingGameRoundResult = roundResults.get(0);
        assertThat(racingGameRoundResult.getCarRoundResults())
                .hasSize(3)
                .extracting("name", "position")
                .containsExactly(
                        tuple("car1", 1),
                        tuple("car2", 1),
                        tuple("car3", 0)
                );
    }

    @DisplayName("자동차 목록이 있을 때 우승자 이름을 추출한다.")
    @Test
    void findWinnerNames() {
        // given
        String expectedWinnerName1 = "car1";
        String expectedWinnerName2 = "car2";

        RacingCar racingCar1 = new RacingCar(expectedWinnerName1, () -> true);
        RacingCar racingCar2 = new RacingCar(expectedWinnerName2, () -> true);
        RacingCar racingCar3 = new RacingCar("car3", () -> false);

        RacingCarGame racingCarGame = new RacingCarGame(Arrays.asList(racingCar1, racingCar2, racingCar3), 10);
        racingCarGame.race();

        // when
        List<String> winnerNames = racingCarGame.findWinnerNames();

        // then
        assertThat(winnerNames).hasSize(2)
                .contains(expectedWinnerName1, expectedWinnerName2);
    }

}
