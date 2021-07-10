package game.racingcar.domain.result;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {

    private final List<RacingGameRoundResult> roundResults = new ArrayList<>();

    public void addRoundResult(RacingGameRoundResult roundResult) {
        this.roundResults.add(roundResult);
    }

    public List<RacingGameRoundResult> getRoundResults() {
        return roundResults;
    }

}
