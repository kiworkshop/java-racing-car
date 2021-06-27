package game;

public class AlwaysMoveStrategy implements RandomStrategy {
    @Override
    public boolean isMove() {
        return true;
    }
}
