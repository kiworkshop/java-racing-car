package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @Test
    @DisplayName("이름을 인자로 받아, 위치가 0인 자동차 객체를 생성한다.")
    void create() {
        //given
        String name = "name";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.position()).isEqualTo(0);
        assertThat(car.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백일 경우, 예외가 발생한다,")
    void validateNullOrEmpty(String nullOrEmpty) {
        //given //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(nullOrEmpty))
                .withMessage("한 자리 이상의 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우, 예외가 발생한다.")
    void validateNameLength() {
        //given
        String overLengthName = "abcdef";

        //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(overLengthName))
                .withMessage("이름은 5자 이하여야 합니다.");
    }
}
