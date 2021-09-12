package racingGameTest.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingGame.domain.AdvanceStrategy;
import racingGame.domain.RandomAdvanceStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RandomAdvanceStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"4, true", "3, false"})
    @DisplayName("4 이상의 난수가 생성되었을 때 참을 반환한다.")
    void canAdvance(int randomNumber, boolean expected) {
        //given
        AdvanceStrategy randomAdvanceStrategy = new RandomAdvanceStrategy() {
            @Override
            protected int createRandomNumber() {
                return randomNumber;
            }
        };

        //when //then
        assertThat(randomAdvanceStrategy.canAdvance()).isEqualTo(expected);
    }
}
