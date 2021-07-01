package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TryNumberTest {

    @Test
    @DisplayName("시도 횟수 값이 음수일 경우, 예외가 발생한다.")
    void validate() {
        //given
        int tryNumber = -1;

        //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new TryNumber(tryNumber))
                .withMessage("시도 횟수 값은 0 이상이여야 합니다.");
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
}
