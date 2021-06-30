package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차들의 이름을 인자 받아 이름 수 만큼의 자동차를 생성한다.")
    void create() {
        //given //when
        Cars cars = new Cars("pobi", "nana", "ppo");

        //then
        assertThat(cars.size()).isEqualTo(3);
    }
}
