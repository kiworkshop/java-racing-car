import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCountParserTest {

    static MoveCountParser moveCountParser = new MoveCountParser();

    @Test
    void 레이스_할_횟수를_입력받는다() {
        // given
        String inputLine = "1";

        // when
        int result = moveCountParser.parseCount(inputLine);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 레이스할_횟수의_입력값이_문자이면_런타임에러() {
        // given
        String inputLine = "가";

        //when then
        assertThatThrownBy(() ->
                moveCountParser.parseCount(inputLine))
                .isInstanceOf(RuntimeException.class);;
    }

    @Test
    void 레이스할_횟수의_입력값이_음수이면_런타임에러() {
        // given
        String inputLine = "-1";

        //when then
        assertThatThrownBy(() ->
                moveCountParser.parseCount(inputLine))
                .isInstanceOf(RuntimeException.class);;
    }
}
