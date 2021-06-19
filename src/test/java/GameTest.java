import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @Test
    void 자동차_이름을_리스트에_넣기() {
        // given
        Game game = new Game();
        String inputLine = "car1,car2,car3";

        // when
        List<String> carNames = game.splitCarNames(inputLine);

        // then
        assertThat(carNames.get(0)).isEqualTo("car1");
        assertThat(carNames.get(1)).isEqualTo("car2");
        assertThat(carNames.get(2)).isEqualTo("car3");
    }

    @Test
    void 자동차_이름_길이_초과시_런타임예외() {
        // given
        Game game = new Game();
        String inputLine = "carrrrrrr1,carrrrrrr2";

        // when, then
        assertThatThrownBy(() -> game.splitCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 자동차_이름이_null_또는_빈문자() {
        // given
        Game game = new Game();
        String inputLine = "";
        String inputLine2 = null;

        // when, then
        assertThatThrownBy(() -> game.splitCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> game.splitCarNames(inputLine2))
                .isInstanceOf(RuntimeException.class);
    }

}
