package domain;

import exception.position.InvalidPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    @DisplayName("위치 값이 음수일 경우, 예외가 발생한다.")
    void validate() {
        //given
        int negativePosition = -1;

        //when //then
        assertThatThrownBy(() -> new Position(negativePosition)).isInstanceOf(InvalidPositionException.class)
                .hasMessage("위치 값은 0 이상이여야 합니다.");
    }

    @Test
    @DisplayName("인자로 받은 숫자와 현재 위치를 더한 이동된 위치를 반환한다.")
    void plus() {
        //given
        Position position = new Position();

        //when
        Position movedPosition = position.plus(12);

        //then
        assertThat(movedPosition.value()).isEqualTo(12);
    }
}
