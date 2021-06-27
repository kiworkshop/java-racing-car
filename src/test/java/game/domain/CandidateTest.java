package game.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CandidateTest {

    private static final String CAR_NAME_ONE = "car1";
    private static final String CAR_NAME_TWO = "car2";

    private static List<String> carNames;

    @BeforeAll
    static void generateCarNameList() {
        carNames = new ArrayList<>();
        carNames.add(CAR_NAME_ONE);
        carNames.add(CAR_NAME_TWO);
    }

    @Test
    void Given_CarNameList_When_newCandidate_Then_GenerateUnmodifiableCarList() throws Exception {
        // given, when
        Candidate candidate = Candidate.builder()
                .carNames(carNames)
                .build();

        // then
        List<Car> cars = candidate.getCars();
        assertThat(cars).isExactlyInstanceOf(Collections.unmodifiableList(new ArrayList<>()).getClass());
        assertThat(cars.size()).isEqualTo(carNames.size());
        assertThat(cars.get(0).getName()).isEqualTo(CAR_NAME_ONE);
        assertThat(cars.get(1).getName()).isEqualTo(CAR_NAME_TWO);
    }

    @Test
    void Given_AlwaysMoveStrategy_When_runOneRound_Then_PositionOfEveryCarIsOne() throws Exception {
        // given
        Candidate candidate = Candidate.builder()
                .carNames(carNames)
                .build();

        // when
        candidate.runOneRoundWith(() -> true);

        // then
        List<Car> cars = candidate.getCars();
        assertThat(cars.get(0).getPosition()).isOne();
        assertThat(cars.get(1).getPosition()).isOne();
    }

    @Test
    void Given_AlwaysNotMoveStrategy_When_runOneRound_Then_PositionOfEveryCarIsZero() throws Exception {
        // given
        Candidate candidate = Candidate.builder()
                .carNames(carNames)
                .build();

        // when
        candidate.runOneRoundWith(() -> false);

        // then
        List<Car> cars = candidate.getCars();
        assertThat(cars.get(0).getPosition()).isZero();
        assertThat(cars.get(1).getPosition()).isZero();
    }
}
