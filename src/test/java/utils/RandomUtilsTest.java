package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {

    @Test
    @DisplayName("인자로 받은 숫자 미만의 난수를 반환한다.")
    void generateRandomNumber() {
        //given
        int maxBound = 12;

        //when //then
        for (int i = 0; i < 100; i++) {
            int randomNumber = RandomUtils.generateRandomNumber(maxBound);
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
            assertThat(randomNumber).isLessThanOrEqualTo(maxBound - 1);
        }
    }
}
