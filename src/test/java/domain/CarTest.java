package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
