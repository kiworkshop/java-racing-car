package game.racingcar;

import game.racingcar.domain.Car;
import game.racingcar.domain.GameCount;
import game.racingcar.domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    @DisplayName("")
    void is_running() {
        //given
        Car[] temp = {new Car("BLUE"), new Car("RED")};
        GameCount gameCount = new GameCount(5);
        RacingGame racingGame = new RacingGame(gameCount, Arrays.asList(temp));

        //when
        IntStream.range(0, gameCount.value())
                .forEach(i -> racingGame.raceOnce());

        //then
        assertThat(gameCount.value()).isZero();
    }

    @Test
    @DisplayName("우승자를 반환한다")
    void winners() {
        //given
        Car[] temp = {new Car("RED", 3), new Car("GREEN", 3),
                new Car("BLUE", 4), new Car("WHITE", 4)};
        RacingGame racingGame = new RacingGame(new GameCount(5), Arrays.asList(temp));

        //when
        List<String> winners = racingGame.winners();

        //then
        assertThat(winners).isEqualTo(Arrays.asList("BLUE", "WHITE"));
    }
}
