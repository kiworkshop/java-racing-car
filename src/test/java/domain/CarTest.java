package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @Test
    @DisplayName("입력받은 자동차 이름을 인자로, 위치가 0인 자동차 객체를 생성한다.")
    void create() {
        //given
        String name = "name";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.position()).isZero();
        assertThat(car.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백이 입력되면 예외가 발생한다.")
    void validateNullOrEmpty(String nullOrEmpty) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(nullOrEmpty))
                .withMessage("이름을 1자 이상 입력해주세요.");
    }

    @Test
    @DisplayName("5자 초과 이름이 입력되면 예외가 발생한다.")
    void validateNameLength() {
        //given
        String overLengthName = "JohnDoe";

        //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(overLengthName))
                .withMessage("이름은 5자 이하까지 입력할 수 있습니다.");
    }


    @Test
    @DisplayName("전진하는 전략이 채택되면 자동차의 위치가 1씩 증가한다.")
    void advance() {
        //given
        Car car = new Car("name", () -> true);

        //when
        car.advance();
        car.advance();

        //then
        assertThat(car.position()).isEqualTo(2);
    }
}

