package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {

    @Test
    @DisplayName("자동차들의 이름을 인자 받아 이름 수 만큼의 자동차를 생성한다.")
    void create() {
        //given //when
        Cars cars = new Cars("pobi", "nana", "ppo");

        //then
        assertThat(cars.list().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 수가 2개 미만일 경우, 예외가 발생한다.")
    void validateSize() {
        //given //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars("pobi"))
                .withMessage("자동차의 대수는 최소 1대 이상이여야 합니다.");
    }

    @Test
    @DisplayName("자동차의 최대 위치 값을 반환한다.")
    void maxPosition() {
        //given
        int maxPosition = 4;
        Car firstCar = new Car("pobi", maxPosition);
        Car secondCar = new Car("dobi", 3);
        Car thirdCar = new Car("kobi", 2);
        Cars cars = new Cars(Arrays.asList(firstCar, secondCar, thirdCar));

        //when //then
        assertThat(cars.maxPosition()).isEqualTo(maxPosition);
    }

    @Test
    @DisplayName("최대 위치값을 인자로 받아 가지는 자동차들의 이름을 반환한다.")
    void winnerNames() {
        //given
        Position maxPosition = new Position(4);
        Car firstCar = new Car("pobi", maxPosition);
        Car secondCar = new Car("dobi", maxPosition);
        Car thirdCar = new Car("kobi", 3);
        Cars cars = new Cars(Arrays.asList(firstCar, secondCar, thirdCar));

        //when //then
        assertThat(cars.winnerNames(maxPosition)).contains("pobi", "dobi");
    }

    @Test
    @DisplayName("자동차의 리스트를 반환한다.")
    void list() {
        //given
        Car firstCar = new Car("pobi");
        Car secondCar = new Car("dobi");
        Car thirdCar = new Car("kobi");
        Cars cars = new Cars(Arrays.asList(firstCar, secondCar, thirdCar));

        //when //then
        assertThat(cars.list()).contains(firstCar, secondCar, thirdCar);
    }
}
