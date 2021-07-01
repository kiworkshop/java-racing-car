package game;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMove() {
        return true;
    }
}
