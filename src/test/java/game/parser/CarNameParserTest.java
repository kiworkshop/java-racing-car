package game.parser;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameParserTest {

    private final CarNameParser carNameParser = new CarNameParser();

    @Test
    void Given_ValidInputLine_When_parseCarNames_Then_ReturnCarNameList() {
        // given
        String inputLine = "car1,car2,car3";

        // when
        List<String> carNames = carNameParser.splitCarNames(inputLine);

        // then
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.get(0)).isEqualTo("car1");
        assertThat(carNames.get(1)).isEqualTo("car2");
        assertThat(carNames.get(2)).isEqualTo("car3");
    }

    @Test
    void Given_CarNamesWithLengthLongerThanLimit_When_parseCarNames_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "nameLongerThanFive";

        // when, then
        assertThatThrownBy(() -> carNameParser.splitCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void Given_CarNamesWithLengthZero_When_parseCarNames_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "name,,name,";

        // when, then
        assertThatThrownBy(() -> carNameParser.splitCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void Given_NullInputLine_When_parseCarNames_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = null;

        // when, then
        assertThatThrownBy(() -> carNameParser.splitCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void Given_EmptyInputLine_When_parseCarNames_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "";

        // when, then
        assertThatThrownBy(() -> carNameParser.splitCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
    }
}
