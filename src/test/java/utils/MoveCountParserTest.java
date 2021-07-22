package utils;

import org.junit.jupiter.api.Test;
import utils.MoveCountParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCountParserTest {

    static MoveCountParser moveCountParser = new MoveCountParser();

    @Test
    void 레이스_할_횟수가_0이하이면_에러를_리턴한닫문자열로_받으면_숫자1을_반환한다() {
        // given
        int inputLine = 0;

        // when then
        assertThatThrownBy(() ->
                moveCountParser.checkTryNo(inputLine))
                .isInstanceOf(RuntimeException.class);
    }
}
