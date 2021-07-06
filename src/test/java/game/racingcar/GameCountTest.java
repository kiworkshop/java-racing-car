package game.racingcar;

import game.racingcar.domain.GameCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameCountTest {
    @Test
    @DisplayName("게임 횟수를 입력받아 게임 횟수 객체를 생성한디")
    void create() {
        //given
        GameCount gameCount = new GameCount(5);

        //when //then
        assertThat(gameCount).isEqualTo(new GameCount(5));

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("게임 횟수 입력 값이 양수가 아니면 예외가 발생한다")
    void input_game_count_validation(int input) {
        //given //when //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameCount(input)).withMessage("게임 시도 횟수는 양수 값 입니다.");
    }
}
