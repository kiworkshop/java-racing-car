package game.racingcar;

import game.racingcar.domain.Car;
import game.racingcar.domain.Race;
import game.racingcar.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    @Test
    @DisplayName("게임 횟수 입력값에 문자열이 들어올 수 없다")
    void input_game_count_validation() {
        //given
        String gameCount = "error";

        //when
        boolean isValid = Race.isValidGameCount(gameCount);

        //then
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Random 숫자의 값이 0~3 이면 멈춘다")
    void compare_random_value_stop() {
        //given
        int randomNumber = 3;

        //when
        boolean stop = Race.isForward(randomNumber);

        //then
        assertThat(stop).isFalse();
    }

    @Test
    @DisplayName("Random 숫자의 값이 4~9 이면 전진한다")
    void compare_random_value_forward() {
        //given
        int randomNumber = 4;

        //when
        boolean forward = Race.isForward(randomNumber);

        //then
        assertThat(forward).isTrue();
    }

    @Test
    @DisplayName("종료시 우승자를 출력한다")
    void print_winners() {
        //given
        Car[] temp = { new Car("AAA", 3), new Car("BBB", 3),
                new Car("CCC", 4), new Car("DDD", 4), };
        Race race = new Race(5, Arrays.asList(temp));

        //when
        List<String> winners = race.getWinners();

        //then
        assertThat(winners).isEqualTo(Arrays.asList("CCC", "DDD"));
        OutputView.printWinners(winners);
    }

}
