package game.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private static final int WINNER_POSITION = 5;
    private static final int LOSER_POSITION = 1;
    private static final int WINNER_INDEX = 0;
    private static final int LOSER_INDEX = 1;
    private static final String WINNER_NAME = "win";
    private static final String LOSER_NAME = "lose";

    @Test
    public void Given_MultipleCarsWithOneWinner_When_newWinner_Then_ReturnWinner() throws Exception {
        // given
        Candidate candidate = generateCandidateWithOneWinnerAndOneLoser();

        // when
        Winner winner = Winner.builder()
                .candidate(candidate)
                .build();

        // then
        assertThat(winner.getWinners().size()).isOne();
        assertThat(winner.getWinners().get(0).getName()).isEqualTo(WINNER_NAME);
        assertThat(winner.getWinners().get(0).getPosition()).isEqualTo(WINNER_POSITION);
    }

    @Test
    public void Given_MultipleCarsWithMultipleWinners_When_newWinner_Then_ReturnWinner() throws Exception {
        // given
        Candidate candidate = generateCandidateWithMultipleWinners();

        // when
        Winner winner = Winner.builder()
                .candidate(candidate)
                .build();

        // then
        assertThat(winner.getWinners().size()).isEqualTo(2);
        assertThat(winner.getWinners().get(0).getName()).isEqualTo(WINNER_NAME);
        assertThat(winner.getWinners().get(0).getPosition()).isEqualTo(WINNER_POSITION);
        assertThat(winner.getWinners().get(1).getName()).isEqualTo(WINNER_NAME);
        assertThat(winner.getWinners().get(1).getPosition()).isEqualTo(WINNER_POSITION);
    }

    @Test
    public void Given_OneCar_When_newWinner_Then_ReturnOneWinner() throws Exception {
        // given
        Candidate candidate = generateCandidateWithOneWinner();

        // when
        Winner winner = Winner.builder()
                .candidate(candidate)
                .build();

        // then
        assertThat(winner.getWinners().size()).isOne();
        assertThat(winner.getWinners().get(0).getName()).isEqualTo(WINNER_NAME);
        assertThat(winner.getWinners().get(0).getPosition()).isEqualTo(WINNER_POSITION);
    }

    private Candidate generateCandidateWithOneWinnerAndOneLoser() {
        List<String> carNames = new ArrayList<>();
        carNames.add(WINNER_NAME);
        carNames.add(LOSER_NAME);
        Candidate candidate = Candidate.builder()
                .carNames(carNames).build();
        moveCarToPosition(candidate.getCars().get(LOSER_INDEX), LOSER_POSITION);
        moveCarToPosition(candidate.getCars().get(WINNER_INDEX), WINNER_POSITION);
        return candidate;
    }

    private Candidate generateCandidateWithMultipleWinners() {
        List<String> carNames = new ArrayList<>();
        carNames.add(WINNER_NAME);
        carNames.add(WINNER_NAME);
        Candidate candidate = Candidate.builder()
                .carNames(carNames).build();
        for (int i = 0; i < candidate.getCars().size(); i++) {
            moveCarToPosition(candidate.getCars().get(i), WINNER_POSITION);
        }
        return candidate;
    }

    private Candidate generateCandidateWithOneWinner() {
        List<String> carNames = new ArrayList<>();
        carNames.add(WINNER_NAME);
        Candidate candidate = Candidate.builder()
                .carNames(carNames).build();
        moveCarToPosition(candidate.getCars().get(WINNER_INDEX), WINNER_POSITION);
        return candidate;
    }

    private void moveCarToPosition(Car car, int position) {
        for (int i = 0; i < position; i++) {
            car.moveForward();
        }
    }
}