package domain;

public class GameSystem {
    private final Cars cars;
    private TryNumber tryNumber;

    public GameSystem(final Names carNames, final int tryNumber) {
        this(new Cars(carNames), new TryNumber(tryNumber));
    }

    public GameSystem(final Names carNames, final TryNumber tryNumber) {
        this(new Cars(carNames), tryNumber);
    }

    public GameSystem(final Cars cars, final TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public boolean on() {
        return tryNumber.isLeft();
    }

    public void playEachRound(int randomNumber) {
        cars.list()
                .forEach(car -> car.move(randomNumber));

        tryNumber = tryNumber.reduce();
    }
}
