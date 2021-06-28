public class RandomMovingStrategy implements MovingStrategy{
    public static final int STANDARD_NUMBER = 4;
    public static final int MAX_RANDOM_NUMBER = 10;

    @Override
    public boolean strategy() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER) >= STANDARD_NUMBER;
    }
}
