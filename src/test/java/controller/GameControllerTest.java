package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import view.InputView;

import java.util.List;

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
}
