package domain;

import java.util.List;
import java.util.Random;

public class GameSystem {
    private static final Random random = new Random();
    private static final int MAX_RANDOM_BOUND = 10;

    private final Cars cars;
    private TryNumber tryNumber;

    public GameSystem(final Names carNames, final int tryNumber) {
        this(new Cars(carNames), new TryNumber(tryNumber));
    }

    public GameSystem(final Names carNames, final TryNumber tryNumber) {
        this(new Cars(carNames), tryNumber);
    }

    public GameSystem(final Cars cars, final int tryNumber) {
        this(cars, new TryNumber(tryNumber));
    }

    public GameSystem(final Cars cars, final TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public boolean on() {
        return tryNumber.isLeft();
    }

    public void playEachRound() {
        cars.list()
                .forEach(car -> car.move(generateRandomNumber()));

        tryNumber = tryNumber.reduce();
    }

    public int generateRandomNumber() {
        return random.nextInt(MAX_RANDOM_BOUND);
    }

    public List<Car> cars() {
        return cars.list();
    }

    public List<String> winners() {
        return cars.winnerNames(cars.maxPosition());
    }
}
