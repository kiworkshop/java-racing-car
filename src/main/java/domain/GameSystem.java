package domain;

public class GameSystem {
    private final Cars cars;
    private final TryNumber tryNumber;

    public GameSystem(final Names carNames, final int tryNumber) {
        this(new Cars(carNames), new TryNumber(tryNumber));
    }

    public GameSystem(Names carNames, TryNumber tryNumber) {
        this(new Cars(carNames), tryNumber);
    }

    public GameSystem(final Cars cars, final TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }
}
