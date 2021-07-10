package game.racingcar.domain.result;

import java.util.ArrayList;
import java.util.List;

public class RacingGameRoundResult {

    private final List<RacingCarRoundResult> carRoundResults = new ArrayList<>();

    public void addCarRoundResult(RacingCarRoundResult carRoundResult) {
        this.carRoundResults.add(carRoundResult);
    }

    public List<RacingCarRoundResult> getCarRoundResults() {
        return carRoundResults;
    }

}
