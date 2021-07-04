package domain;

import exception.trynumber.InvalidTryNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNumberTest {

    @Test
    @DisplayName("시도 횟수 값이 음수일 경우, 예외가 발생한다.")
    void validate() {
        //given
        int tryNumber = -1;

        //when //then
        assertThatThrownBy(() -> new TryNumber(tryNumber)).isInstanceOf(InvalidTryNumberException.class)
                .hasMessage("시도 횟수 값은 0 이상이여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "0, false"})
    @DisplayName("시도 횟수가 1 이상일 경우 참을 반환한다.")
    void isLeft(int input, boolean expected) {
        //given
        TryNumber tryNumber = new TryNumber(input);

        //when //then
        assertThat(tryNumber.isLeft()).isEqualTo(expected);
    }

    @Test
    @DisplayName("현재 시도 횟수를 차감한 후 남은 시도 횟수를 반환한다.")
    void reduce() {
        //given
        TryNumber tryNumber = new TryNumber(2);

        //when
        TryNumber reducedTryNumber = tryNumber.reduce();

        //then
        assertThat(reducedTryNumber).isEqualTo(new TryNumber(1));
    }
}
