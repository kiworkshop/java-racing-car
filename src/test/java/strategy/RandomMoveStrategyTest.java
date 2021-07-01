package strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"4, true", "3, false"})
    @DisplayName("4 이상일 경우 참을 반환한다. ")
    void movable(int randomNumber, boolean expected) {
        //given
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy() {
            @Override
            protected int generateRandomNumber() {
                return randomNumber;
            }
        };

        //when //then
        assertThat(randomMoveStrategy.movable()).isEqualTo(expected);
    }
}
