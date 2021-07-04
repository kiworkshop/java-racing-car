package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SplitUtilsTest {

    @Test
    @DisplayName("문자열, 구분자를 인자로 받아 구분자를 기준으로 문자열을 분리한다.")
    void split() {
        //given
        String delimiter = ",";
        String input = "name, sean, bean";
        List<String> expectedResult = Arrays.asList("name", "sean", "bean");

        //when
        List<String> tokens = SplitUtils.split(input, delimiter);

        //then
        for (int i = 0; i < tokens.size(); i++) {
            assertThat(tokens.get(i)).isEqualTo(expectedResult.get(i));
        }
    }

    @Test
    @DisplayName("인자로 넣어준 구분자가 문자열에 존재하지 않을 경우, 예외가 발생한다.")
    void validateDelimiter() {
        //given
        String delimiter = ",";
        String input = "name. sean. bean";

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> SplitUtils.split(input, delimiter))
                .withMessage(format("\"%s\" 구분자가 존재하는 지 확인해주세요.", delimiter));
    }
}
