package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

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
        assertThatThrownBy(() -> gameController.validateDelimiter(names))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("\",\"가 포함되어야 합니다.");
    }
}
