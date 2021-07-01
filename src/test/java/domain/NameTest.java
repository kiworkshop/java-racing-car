package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백일 경우, 예외가 발생한다,")
    void validateNullOrEmpty(String nullOrEmpty) {
        //given //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(nullOrEmpty))
                .withMessage("한 자리 이상의 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우, 예외가 발생한다.")
    void validateLength() {
        //given
        String overLengthName = "abcdef";

        //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(overLengthName))
                .withMessage("이름은 5자 이하여야 합니다.");
    }
}
