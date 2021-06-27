package game.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @Test
    void Given_StringWithLengthLessThanAlignStandard_When_alignLeft_Then_ReturnStringAlignLeft() throws Exception {
        // given
        String string = "123";
        int alignStandard = 5;

        // when
        String result = StringUtil.alignLeft(string, alignStandard);

        // then
        assertThat(result.length()).isEqualTo(alignStandard);
        assertThat(result).isEqualTo("123  ");
    }

    @Test
    void Given_StringWithLengthEqualToAlignStandard_When_alignLeft_Then_ReturnString() throws Exception {
        // given
        String string = "12345";
        int alignStandard = 5;

        // when
        String result = StringUtil.alignLeft(string, alignStandard);

        // then
        assertThat(result.length()).isEqualTo(alignStandard);
        assertThat(result).isEqualTo(string);
    }

    @Test
    void Given_StringAndRepeatCount_When_repeat_Then_ReturnRepeatedString() throws Exception {
        // given
        String string = "a";
        int repeatCount = 5;

        // when
        String result = StringUtil.repeat(string, repeatCount);

        // then
        assertThat(result.length()).isEqualTo(string.length() * repeatCount);
        assertThat(result).isEqualTo("aaaaa");
    }
}