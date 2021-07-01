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
    @DisplayName("자동차 이름을 입력받아 자동차 이름 목록을 만든다")
    void input_car_names_to_list() {
        //given

        //when
        String input = "자동차1, 자동차2, 자동차3, 자동차4, 자동차5";
        List<String> carNames = Arrays.asList(input.split(","));
        List<Car> carList = Car.initCarNames(carNames);

        //then
        assertThat(carList.size()).isEqualTo(5);
        assertThat(carList.get(2).getName()).isEqualTo("자동차3");
    }

    @Test
    @DisplayName("입력받은 자동차 이름은 문자열 5자 이하이다")
    void input_car_name_length_validation() {
        //given
        String input = "잘못된_자동차_이름";

        //when
        boolean isValid = Car.isValidCarName(input);

        //then
        assertThat(isValid).isFalse();

    }

    @Test
    @DisplayName("입력받은 자동차 이름은 공백이 아니다")
    void input_car_name_empty_validation() {
        //given
        String input = "";

        //when
        boolean isValid = Car.isValidCarName(input);

        //then
        assertThat(isValid).isFalse();
    }

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
    @DisplayName("게임 횟수는 MAX_GAME_COUNT 를 넘을 수 없다")
    void input_max_game_count_validation() {
        //given
        String gameCount = "11";

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
    @DisplayName("사용자가 입력한 시도 횟수만큼 반복한다")
    void game_count_iterate() {
        //given
        String input = "AAA, BBB, CCC, DDD, EEE";
        List<Car> carList = Car.initCarNames(Arrays.asList(input.split(",")));

        int gameCount = 5;

        Race race = new Race(gameCount, carList);

        //when
        race.racing();

        //then
        assertThat(race.getGameCount()).isEqualTo(gameCount);
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
