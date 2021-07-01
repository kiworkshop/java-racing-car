package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {

    @Test
    @DisplayName("위치 값이 음수일 경우, 예외가 발생한다.")
    void validate() {
        //given
        int negativePosition = -1;

        //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(negativePosition))
                .withMessage("위치 값은 0 이상이여야 합니다.");
    }
}
