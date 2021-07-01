package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameSystemTest {

    @Test
    @DisplayName("이름 목록, 시도 횟수를 인자로 받아 게임 시스템 객체를 생성한다.")
    void create() {
        //given
        Names carNames = new Names("pobi, kobi, tobi");
        int tryNumber = 5;

        //when
        GameSystem gameSystem = new GameSystem(carNames, tryNumber);

        //then
        assertThat(gameSystem).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "0, false"})
    @DisplayName("시도 횟수가 남아있을 경우 참을 반환한다.")
    void on(int tryNumber, boolean expected) {
        //given
        Names carNames = new Names("pobi, kobi, tobi");
        GameSystem gameSystem = new GameSystem(carNames, tryNumber);

        //when //then
        assertThat(gameSystem.on()).isEqualTo(expected);
    }
}
