package game.validator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameValidatorTest {

    @Test
    void Given_CarNamesWithValidLength_When_validate_Then_ReturnTrue() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");

        // when
        boolean result = CarNameValidator.isValid(carNames);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void Given_CarNamesWithLengthLongerThanLimit_When_validate_Then_ReturnFalse() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("nameLongerThanFive");

        // when
        boolean result = CarNameValidator.isValid(carNames);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void Given_CarNamesWithLengthZero_When_validate_Then_ReturnFalse() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("");

        // when
        boolean result = CarNameValidator.isValid(carNames);

        // then
        assertThat(result).isFalse();
    }
}