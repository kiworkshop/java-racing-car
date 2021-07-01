package util;

import org.junit.jupiter.api.Test;
import util.RaceCountParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceCountParserTest {

    @Test
    void Given_InputLineWithSingleDigitPositiveInteger_When_parseCount_Then_ReturnPositiveInteger() {
        // given
        String inputLine = "1";

        // when
        int result = RaceCountParser.parseRaceCount(inputLine);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void Given_InputLineWithNoneSingleDigitPositiveInteger_When_parseCount_Then_ReturnPositiveInteger() {
        // given
        String inputLine = "111";

        // when
        int result = RaceCountParser.parseRaceCount(inputLine);

        // then
        assertThat(result).isEqualTo(111);
    }

    @Test
    void Given_InputLineWithZero_When_parseCount_Then_ReturnZero() {
        // given
        String inputLine = "0";

        // when
        int result = RaceCountParser.parseRaceCount(inputLine);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void Given_InputLineWithNoneInteger_When_parseCount_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "가";

        //when then
        assertThatThrownBy(() ->
                RaceCountParser.parseRaceCount(inputLine))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void Given_InputLineWithNegativeInteger_When_parseCount_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "-1";

        //when then
        assertThatThrownBy(() ->
                RaceCountParser.parseRaceCount(inputLine))
                .isInstanceOf(RuntimeException.class);
    }
}
