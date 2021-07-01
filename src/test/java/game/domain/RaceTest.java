package game.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {

    private static List<String> carNames;

    @BeforeAll
    private static void generateCarNameList() {
        carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
    }

    @Test
    void Given_RaceCountSmallerThanOne_When_newRace_ThrowRuntimeException() {
        // given
        int raceCount = 0;

        // when, then
        assertThatThrownBy(() -> Race.builder()
                .carNames(carNames)
                .raceCount(raceCount)
                .build())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void Given_CandidateAndRaceCount_When_runWithAlwaysMoveStrategy_Then_PositionOfEveryWinnerIsRaceCount() throws Exception {
        // given
        int raceCount = 5;
        Race race = Race.builder()
                .carNames(carNames)
                .raceCount(raceCount)
                .build();

        // when
        race.runWith(() -> true);

        // then
        for (Car car : race.findWinners().getWinners()) {
            assertThat(car.getPosition()).isEqualTo(raceCount);
        }
    }
}
