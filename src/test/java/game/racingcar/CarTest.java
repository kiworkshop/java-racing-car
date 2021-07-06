package game.racingcar;

import game.racingcar.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static game.racingcar.view.InputView.inputCarNamesToList;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 이름을 입력받아 자동차 객체를 생성한다")
    void create() {
        //given //when
        Car greenCar = new Car("GREEN");

        //then
        assertThat(greenCar).isEqualTo(new Car("GREEN"));
    }

    @Test
    @DisplayName("자동차 이름을 입력받아 자동차 이름 목록을 만든다")
    void input_car_names_to_list() {
        //given
        String input = "RED, BLUE, GREEN, BLACK, WHITE";
        List<String> carNames = inputCarNamesToList(input);

        //when
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        //then
        assertThat(cars.size()).isEqualTo(5);
        assertThat(cars.get(2).name()).isEqualTo("GREEN");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "YELLOW"})
    @DisplayName("자동차 이름이 공백이거나 5글자 초과이면 예외가 발생한다")
    void input_car_name_validation(String invalidCarName) {
        //given //when //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(invalidCarName)).withMessage("자동차 이름은 1 ~ 5자 사이입니다.");
    }

}
