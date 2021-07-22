package domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private int maxPosition = 0;
    private final List<CarResults> roundResult;

    public RaceResult(List<CarResults> roundResult) {
        this.roundResult = roundResult;
    }

    public List<CarResults> getRoundResult() {
        return roundResult;
    }

    public List<CarResult> getWinners() {
        maxPosition = 0;
        List<CarResult> winners = new ArrayList<>();
        for (CarResult carResult : roundResult.get(roundResult.size() - 1).getCarResults()) {
            winners = updateWinner(carResult, winners);
        }
        return winners;
    }

    private List<CarResult> updateWinner(CarResult carResult, List<CarResult> winners) {
        if (carResult.getPosition() == maxPosition) {
            winners.add(carResult);
        }
        if (carResult.getPosition() > maxPosition) {
            winners.clear();
            winners.add(carResult);
            maxPosition = carResult.getPosition();
        }
        return winners;
    }
}
