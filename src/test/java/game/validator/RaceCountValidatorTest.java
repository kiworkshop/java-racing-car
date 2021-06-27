package game.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCountValidatorTest {

    @Test
    void Given_RaceCountGreaterThanZero_When_validate_ReturnTrue() {
        // given
        int raceCount1 = 1;
        int raceCount2 = 2;

        // when
        boolean result1 = RaceCountValidator.isValid(raceCount1);
        boolean result2 = RaceCountValidator.isValid(raceCount2);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
    }

    @Test
    void Given_RaceCountSmallerThanOne_When_validate_ReturnFalse() {
        // given
        int raceCount = 0;

        // when
        boolean result = RaceCountValidator.isValid(raceCount);

        // then
        assertThat(result).isFalse();
    }
}