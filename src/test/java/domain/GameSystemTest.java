package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
