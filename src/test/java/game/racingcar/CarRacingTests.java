package game.racingcar;

import game.racingcar.domain.Car;
import game.racingcar.domain.CarRacingService;
import game.racingcar.domain.Race;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarRacingTests {

    static CarRacingService service;

    @BeforeAll
    public static void beforeAll() {
        service = new CarRacingService();
    }

    @Test
    @DisplayName("자동차 이름을 입력을 받는다")
    void input_car_names() {
        //given

        //when
        String input = "AAA,BBB,CCC,DDD,EEE"; // Scanner 입력
        List<String> carNames = service.getCarNames(input);

        //then
        assertThat(carNames.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름은 문자열 5자 이하이다")
    void input_car_name_length_validation() {
        //given
        String input = "MAX_CAR_NAME";

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new Car(input, Car.INIT_SCORE));
    }

    @Test
    @DisplayName("자동차 이름은 공백이 아니다")
    void input_car_name_empty_validation() {
        //given
        String input = "";

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new Car(input, Car.INIT_SCORE));
    }

    @Test
    @DisplayName("게임 횟수 입력값에 문자열이 들어올 수 없다")
    void input_game_count_validation() {
        //given
        String gameCount = "error"; // Scanner 입력

        //when
        boolean isValid = service.isValidGameCount(gameCount);

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
        String input = "AAA,BBB,CCC,DDD,EEE"; // Scanner 입력
        List<String> carNames = Arrays.asList(input.split(","));

        int gameCount = 5;
        Race race = service.initRace(carNames, gameCount);

        //when
        service.racing(race);

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
        List<String> winners = service.getWinners(race.getCars());

        //then
        assertThat(winners).isEqualTo(Arrays.asList("CCC", "DDD"));
    }

}
