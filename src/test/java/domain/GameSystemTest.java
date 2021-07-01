package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class GameSystemTest {
    private final Names carNames = new Names("pobi, kobi, tobi");

    @Test
    @DisplayName("이름 목록, 시도 횟수를 인자로 받아 게임 시스템 객체를 생성한다.")
    void create() {
        //given
        int tryNumber = 5;

        //when
        GameSystem gameSystem = new GameSystem(carNames, tryNumber);

        //then
        assertThat(gameSystem).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "0, false"})
    @DisplayName("시도 횟수가 남아있을 경우 참을 반환한다.")
    void on(int tryNumber, boolean expected) {
        //given
        GameSystem gameSystem = new GameSystem(carNames, tryNumber);

        //when //then
        assertThat(gameSystem.on()).isEqualTo(expected);
    }

    @Test
    @DisplayName("남은 시도 횟수를 차감하여 경주를 한다.")
    void playEachRound() {
        //given
        int randomNumber = new Random().nextInt(10);
        int tryNumber = 1;
        GameSystem gameSystem = new GameSystem(carNames, tryNumber);

        //when
        gameSystem.playEachRound(randomNumber);

        //then
        assertThat(gameSystem.on()).isFalse();
    }

    @Test
    @DisplayName("모든 자동차 리스트를 반환한다.")
    void cars() {
        //given
        int tryNumber = 1;
        GameSystem gameSystem = new GameSystem(carNames, tryNumber);

        //when
        List<Car> cars = gameSystem.cars();

        //then
        assertThat(cars.size()).isEqualTo(3);
    }
}
