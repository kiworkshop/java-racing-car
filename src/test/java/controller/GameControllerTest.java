package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import view.InputView;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameControllerTest {
    private GameController gameController;

    @BeforeEach
    void setUp() {
        gameController = new GameController(new InputView());
    }

    @Test
    @DisplayName("입력받은 이름에 `,`이 포함되지 않을 경우 예외가 발생한다.")
    void validateDelimiter() {
        //given
        String names = "bean";

        //when //then
        assertThatThrownBy(() -> gameController.split(names))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("\",\"가 포함되어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"bean, sean, jean : 3", "bean, cean : 2"}, delimiter = ':')
    @DisplayName("','를 기준으로 이름을 분리하여 이름 목록을 반환한다.")
    void split(String inputNames, int expected) {
        //when
        List<String> names = gameController.split(inputNames);

        //then
        assertThat(names.size()).isEqualTo(expected);
    }

    @Test
    @DisplayName("각 이름이 5자 초과일 경우, 예외가 발생한다.")
    void validateNameLength() {
        //given
        List<String> names = Arrays.asList("bennie");

        //when //then
        assertThatThrownBy(() -> gameController.validateNameLength(names))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 5자 이하여야 합니다.");
    }


    @Test
    @DisplayName("자동차에 이름과 위치정보를 부여한다.")
    void createCars() {
        //given
        List<String> carNames = Arrays.asList("bean", "tom", "john");

        //when
        Map<String, Integer> cars = gameController.createCars(carNames);

        //then
        cars.values()
                .forEach(position -> assertThat(position).isEqualTo(0));
        assertThat(cars.size()).isEqualTo(carNames.size());
    }

    @Test
    @DisplayName("0-9 중 하나의 숫자를 random하게 생성하여 반환한다.")
    void generateRandomNumber() {
        for (int i = 0; i < 100; i++) {
            //when
            int randomNumber = gameController.generateRandomNumber();

            //then
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
            assertThat(randomNumber).isLessThanOrEqualTo(9);
        }
    }

    @Test
    @DisplayName("앞서 생성된 난수가 4 이상이면 참을 반환한다.")
    void checkAdvanceCondition() {
        //given
        int advanceCondition = 4;
        int stopCondition = 3;

        //when //then
        assertThat(gameController.checkAdvanceCondition(advanceCondition)).isTrue();
        assertThat(gameController.checkAdvanceCondition(stopCondition)).isFalse();
    }

    @Test
    @DisplayName("자동차를 인자로 받아, 전진 조건을 만족할때 1을 더한다.")
    void advance() {
        //given
        Map.Entry<String, Integer> advancedCar = new AbstractMap.SimpleEntry<>("name", 0);
        Map.Entry<String, Integer> stoppedCar = new AbstractMap.SimpleEntry<>("name", 0);
        int advanceCondition = 4;
        int stopCondition = 3;

        //when
        gameController.advance(advancedCar, advanceCondition);
        gameController.advance(stoppedCar, stopCondition);

        //then
        assertThat(advancedCar.getValue()).isEqualTo(1);
        assertThat(stoppedCar.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차와 시도 횟수를 인자로 받아, 시도 횟수가 0이 될때까지 경주한다.")
    void race() {
        //given
        int rounds = 5;
        List<String> carNames = Arrays.asList("bean", "tom", "john");
        Map<String, Integer> cars = gameController.createCars(carNames);

        //when
        int leftRounds = gameController.race(rounds, cars);

        //then
        assertThat(leftRounds).isEqualTo(0);
    }

    @Test
    @DisplayName("모든 자동차들의 위치를 비교하여 가장 멀리 위치해있는 값을 반환한다.")
    void findWinningPosition() {
        //given
        Map<String, Integer> cars = new HashMap<>();
        cars.put("lose1", 1);
        cars.put("lose2", 2);
        cars.put("win1", 3);
        cars.put("win2", 3);

        //whe
        int winningPosition = gameController.findWinningPosition(cars.values());

        //then
        assertThat(winningPosition).isEqualTo(3);
    }


    @Test
    @DisplayName("가장 멀리 이동한 자동차들의 이름을 반환한다.")
    void announceWinners() {
        //given
        Map<String, Integer> cars = new HashMap<>();
        cars.put("lose1", 1);
        cars.put("lose2", 2);
        cars.put("win1", 3);
        cars.put("win2", 3);

        //when
        List<String> winners = gameController.announceWinners(cars);

        //then
        assertThat(winners).contains("win1", "win2");
    }
}
