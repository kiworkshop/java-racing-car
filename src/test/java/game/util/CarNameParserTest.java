package game.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameParserTest {

    @Test
    void Given_ValidInputLine_When_parseCarNames_Then_ReturnCarNameList() {
        // given
        String inputLine = "car1,car2,car3";

        // when
        List<String> carNames = CarNameParser.parseCarNames(inputLine);

        // then
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.get(0)).isEqualTo("car1");
        assertThat(carNames.get(1)).isEqualTo("car2");
        assertThat(carNames.get(2)).isEqualTo("car3");
    }

    @Test
    void Given_InputLineWithBlanks_When_parseCarNames_Then_ReturnCarNameList() {
        // given
        String inputLine = "  ";

        // when
        List<String> carNames = CarNameParser.parseCarNames(inputLine);

        // then
        assertThat(carNames.size()).isEqualTo(1);
        assertThat(carNames.get(0)).isEqualTo("");
    }

    @Test
    void Given_NullInputLine_When_parseCarNames_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = null;

        // when, then
        assertThatThrownBy(() -> CarNameParser.parseCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void Given_EmptyInputLine_When_parseCarNames_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "";

        // when, then
        assertThatThrownBy(() -> CarNameParser.parseCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void Given_ValidLengthNameWithSingleBlankAroundName_When_parseCarNames_Then_ReturnTrimmedCarNameList() {
        // given
        String inputLine = "name ";

        // when
        List<String> carNames = CarNameParser.parseCarNames(inputLine);

        // then
        assertThat(carNames.size()).isEqualTo(1);
        assertThat(carNames.get(0)).isEqualTo("name");
    }

    @Test
    void Given_ValidLengthNameWithMultipleBlanksAroundName_When_parseCarNames_Then_ReturnTrimmedCarNameList() {
        // given
        String inputLine = "    name   ";

        // when
        List<String> carNames = CarNameParser.parseCarNames(inputLine);

        // then
        assertThat(carNames.size()).isEqualTo(1);
        assertThat(carNames.get(0)).isEqualTo("name");
    }
}
