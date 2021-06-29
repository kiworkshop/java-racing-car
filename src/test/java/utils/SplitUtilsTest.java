package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
