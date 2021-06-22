
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameParserTest {
    static CarNameParser carNameParser = new CarNameParser();

    @Test
    void 자동차_이름을_리스트에_넣기() {
        // given
        String inputLine = "car1,car2,car3";

        // when
        List<String> carNames = carNameParser.splitCarNames(inputLine);

        // then
        assertThat(carNames.get(0)).isEqualTo("car1");
        assertThat(carNames.get(1)).isEqualTo("car2");
        assertThat(carNames.get(2)).isEqualTo("car3");
    }

    @Test
    void 자동차_이름_길이_초과시_런타임예외() {
        // given
        String inputLine = "carrrrrrr1,carrrrrrr2";

        // when, then
        assertThatThrownBy(() -> carNameParser.splitCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 입력값이_null_또는_빈문자() {
        // given
        String inputLine = "";
        String inputLine2 = null;

        // when, then
        assertThatThrownBy(() -> carNameParser.splitCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> carNameParser.splitCarNames(inputLine2))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 자동차이름이_연속으로_쉼표가_있을_경우_런타임에러() {
        // given
        String inputLine = "name1,,name2,,";

        // when, then
        assertThatThrownBy(() -> carNameParser.splitCarNames(inputLine))
                .isInstanceOf(RuntimeException.class);
    }
}
