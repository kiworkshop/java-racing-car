package game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundCountTest {

    @Test
    void Given_InputLineWithSingleDigitPositiveInteger_When_newRoundCount_Then_SetTargetRoundCount() {
        // given
        String inputLine = "1";

        // when
        RoundCount result = new RoundCount(inputLine);

        // then
        assertThat(result.getTargetRoundCount()).isEqualTo(1);
    }

    @Test
    void Given_InputLineWithNoneSingleDigitPositiveInteger_When_newRoundCount_Then_SetTargetRoundCount() {
        // given
        String inputLine = "111";

        // when
        RoundCount result = new RoundCount(inputLine);

        // then
        assertThat(result.getTargetRoundCount()).isEqualTo(111);
    }

    @Test
    void Given_InputLineWithZero_When_newRoundCount_Then_ThrowIllegalArgumentException() {
        // given
        String inputLine = "0";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new RoundCount(inputLine);
        });
    }

    @Test
    void Given_InputLineWithNoneInteger_When_newRoundCount_Then_ThrowIllegalArgumentException() {
        // given
        String inputLine = "가";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new RoundCount(inputLine);
        });
    }

    @Test
    void Given_InputLineWithNegativeInteger_When_newRoundCount_Then_ThrowIllegalArgumentException() {
        // given
        String inputLine = "-1";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new RoundCount(inputLine);
        });
    }
}
