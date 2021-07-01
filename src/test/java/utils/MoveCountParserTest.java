package utils;

import org.junit.jupiter.api.Test;
import utils.MoveCountParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCountParserTest {

    static MoveCountParser moveCountParser = new MoveCountParser();

    @Test
    void 레이스_할_횟수를_1문자열로_받으면_숫자1을_반환한다() {
        // given
        String inputLine = "1";

        // when
        int result = moveCountParser.parseCount(inputLine);

        // then
        assertThat(result).isEqualTo(1);
    }
    
    @Test
    void 레이스_할_횟수를_12문자열로_입력받으면_숫자12를_반환한다() {
        // given
        String inputLine = "12";

        // when
        int result = moveCountParser.parseCount(inputLine);

        // then
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 레이스_할_횟수가_0이면_숫자0을_반환한다() {
        // given
        String inputLine = "0";

        // when
        int result = moveCountParser.parseCount(inputLine);

        // then
        assertThat(result).isEqualTo(0);
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
