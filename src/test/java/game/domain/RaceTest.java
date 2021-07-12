package game.domain;

import game.AlwaysMoveStrategy;
import game.AlwaysNotMoveStrategy;
import game.MoveStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static game.domain.Cars.CAR_NAME_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {

    private static final String CAR_NAME_ONE = "car1";
    private static final String CAR_NAME_TWO = "car2";
    private static final String CAR_NAMES_INPUT = CAR_NAME_ONE + CAR_NAME_DELIMITER + CAR_NAME_TWO;
    private static final int DEFAULT_ROUND_COUNT = 1;

    private static List<String> carNames;

    @BeforeAll
    static void generateCarNameList() {
        carNames = new ArrayList<>();
        carNames.add(CAR_NAME_ONE);
        carNames.add(CAR_NAME_TWO);
    }

    @Test
    void Given_RoundCountSmallerThanOne_When_newRace_ThrowIllegalArgumentException() {
        // given
        int roundCount = 0;

        // when, then
        assertThatThrownBy(() -> Race.builder()
                .carNamesInput(CAR_NAMES_INPUT)
                .raceCountInput(String.valueOf(roundCount))
                .build())
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @Test
//    void Given_CarNameListAndRoundCount_When_newRace_Then_GenerateUnmodifiableCarList() throws Exception {
//        // given, when
//        Race race = Race.builder()
//                .carNames(carNames)
//                .targetRoundCount(DEFAULT_ROUND_COUNT)
//                .build();
//
//        // then
//        List<Car> cars = race.getCars().getCars();
//        assertThat(cars).isExactlyInstanceOf(Collections.unmodifiableList(new ArrayList<>()).getClass());
//        assertThat(cars.size()).isEqualTo(carNames.size());
//        assertThat(cars.get(0).getName()).isEqualTo(CAR_NAME_ONE);
//        assertThat(cars.get(1).getName()).isEqualTo(CAR_NAME_TWO);
//    }

    @Test
    void Given_AlwaysMoveStrategy_When_run_Then_PositionOfEveryCarIsRoundCount() throws Exception {
        // given
        Race race = Race.builder()
                .carNamesInput(CAR_NAMES_INPUT)
                .raceCountInput(String.valueOf(DEFAULT_ROUND_COUNT))
                .build();
        MoveStrategy strategy = new AlwaysMoveStrategy();

        // when
        race.runWith(strategy);

        // then
        List<Car> cars = race.getCars().getCars();
        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(DEFAULT_ROUND_COUNT);
        }
    }

    @Test
    void Given_AlwaysNotMoveStrategy_When_run_Then_PositionOfEveryCarIsZero() throws Exception {
        // given
        Race race = Race.builder()
                .carNamesInput(CAR_NAMES_INPUT)
                .raceCountInput(String.valueOf(DEFAULT_ROUND_COUNT))
                .build();
        MoveStrategy strategy = new AlwaysNotMoveStrategy();

        // when
        race.runWith(strategy);

        // then
        List<Car> cars = race.getCars().getCars();
        for (Car car : cars) {
            assertThat(car.getPosition()).isZero();
        }
    }
}
