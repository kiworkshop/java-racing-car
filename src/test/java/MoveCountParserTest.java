import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCountParserTest {

    static MoveCountParser moveCountParser = new MoveCountParser();

    @Test
    void 이동횟수_숫자_입력받기() {
        // given
        String inputLine = "1";

        // when
        int result = moveCountParser.parseCount(inputLine);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 이동횟수_문자_입력받기_런타임에러() {
        // given
        String inputLine = "가";

        //when then
        assertThatThrownBy(() ->
                moveCountParser.parseCount(inputLine))
                .isInstanceOf(RuntimeException.class);;
    }

    @Test
    void 이동횟수_음수일때_런타임에러() {
        // given
        String inputLine = "-1";

        //when then
        assertThatThrownBy(() ->
                moveCountParser.parseCount(inputLine))
                .isInstanceOf(RuntimeException.class);;
    }
}
