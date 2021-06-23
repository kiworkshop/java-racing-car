package game.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCountParserTest {

    private final MoveCountParser moveCountParser = new MoveCountParser();

    @Test
    void Given_InputLineWithPositiveInteger_When_parseCount_Then_ReturnPositiveInteger() {
        // given
        String inputLine = "1";

        // when
        int result = moveCountParser.parseCount(inputLine);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void Given_InputLineWithNoneInteger_When_parseCount_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "가";

        //when then
        assertThatThrownBy(() ->
                moveCountParser.parseCount(inputLine))
                .isInstanceOf(RuntimeException.class);
        ;
    }

    @Test
    void Given_InputLineWithNegativeInteger_When_parseCount_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "-1";

        //when then
        assertThatThrownBy(() ->
                moveCountParser.parseCount(inputLine))
                .isInstanceOf(RuntimeException.class);
        ;
    }
}
