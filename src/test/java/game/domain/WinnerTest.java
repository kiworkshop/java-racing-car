package game.domain;

import game.AlwaysMoveStrategy;
import game.MoveStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private static final MoveStrategy ALWAYS_MOVE = new AlwaysMoveStrategy();
    private static final int WINNER_POSITION = 5;
    private static final int LOSER_POSITION = 1;
    private static final int WINNER_INDEX = 0;
    private static final int LOSER_INDEX = 1;
    private static final String WINNER_NAME = "win";
    private static final String LOSER_NAME = "lose";

    @Test
    public void Given_MultipleCarsWithOneWinner_When_newWinner_Then_ReturnWinner() throws Exception {
        // given
        Cars candidates = generateCandidateWithOneWinnerAndOneLoser();

        // when
        Winner winner = new Winner(candidates);

        // then
        assertThat(winner.getWinners().size()).isOne();
        assertThat(winner.getWinners().get(0).getName()).isEqualTo(WINNER_NAME);
        assertThat(winner.getWinners().get(0).getPosition()).isEqualTo(WINNER_POSITION);
    }

    private Cars generateCandidateWithOneWinnerAndOneLoser() throws Exception {
        List<Car> candidates = new ArrayList<>();
        candidates.add(new Car(WINNER_NAME, ALWAYS_MOVE));
        candidates.add(new Car(LOSER_NAME, ALWAYS_MOVE));
        moveCarToPosition(candidates.get(WINNER_INDEX), WINNER_POSITION);
        moveCarToPosition(candidates.get(LOSER_INDEX), LOSER_POSITION);
        return new Cars(candidates);
    }

    @Test
    public void Given_MultipleCarsWithMultipleWinners_When_newWinner_Then_ReturnWinner() throws Exception {
        // given
        Cars candidates = generateCandidateWithMultipleWinners();

        // when
        Winner winner = new Winner(candidates);

        // then
        assertThat(winner.getWinners().size()).isEqualTo(2);
        assertThat(winner.getWinners().get(0).getName()).isEqualTo(WINNER_NAME);
        assertThat(winner.getWinners().get(0).getPosition()).isEqualTo(WINNER_POSITION);
        assertThat(winner.getWinners().get(1).getName()).isEqualTo(WINNER_NAME);
        assertThat(winner.getWinners().get(1).getPosition()).isEqualTo(WINNER_POSITION);
    }

    private Cars generateCandidateWithMultipleWinners() throws Exception {
        List<Car> candidates = new ArrayList<>();
        candidates.add(new Car(WINNER_NAME, ALWAYS_MOVE));
        candidates.add(new Car(WINNER_NAME, ALWAYS_MOVE));
        for (Car candidate : candidates) {
            moveCarToPosition(candidate, WINNER_POSITION);
        }
        return new Cars(candidates);
    }

    @Test
    public void Given_OneCar_When_newWinner_Then_ReturnOneWinner() throws Exception {
        // given
        Cars candidates = generateCandidateWithOneWinner();

        // when
        Winner winner = new Winner(candidates);

        // then
        assertThat(winner.getWinners().size()).isOne();
        assertThat(winner.getWinners().get(WINNER_INDEX).getName()).isEqualTo(WINNER_NAME);
        assertThat(winner.getWinners().get(WINNER_INDEX).getPosition()).isEqualTo(WINNER_POSITION);
    }

    private Cars generateCandidateWithOneWinner() throws Exception {
        List<Car> candidates = new ArrayList<>();
        candidates.add(new Car(WINNER_NAME, ALWAYS_MOVE));
        moveCarToPosition(candidates.get(WINNER_INDEX), WINNER_POSITION);
        return new Cars(candidates);
    }

    private void moveCarToPosition(Car car, int position) {
        for (int i = 0; i < position; i++) {
            car.move();
        }
    }
}