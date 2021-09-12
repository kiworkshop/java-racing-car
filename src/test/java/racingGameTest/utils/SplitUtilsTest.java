package racingGameTest.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.utils.SplitUtils;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SplitUtilsTest {

    @Test
    @DisplayName("입력 받은 이름을 구분자','를 기준으로 분리한다.")
    void split() {
        //given
        String inputNames = "John, Doe, Jane, Roe, Smith";
        String delimiter = ",";
        List<String> SplitNames = Arrays.asList("John", "Doe", "Jane", "Roe", "Smith");

        //when
        List<String> names = SplitUtils.split(inputNames, delimiter);

        //then
        for (int i = 0; i < names.size(); i++) {
            assertThat(names.get(i)).isEqualTo(SplitNames.get(i));      // 파싱, trim 결과까지 테스트 가능
        }
    }

    @Test
    @DisplayName("구분자가 문자열에 존재하지 않을 경우, 예외가 발생한다.")
    void validateDelimiter() {
        //given
        String delimiter = ",";
        String inputNames = "John. Doe. Jane. Roe. Smith";

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> SplitUtils.split(inputNames, delimiter))
                .withMessage(format("\"%s\" 구분자가 존재하는 지 확인해주세요.", delimiter));
    }
}
