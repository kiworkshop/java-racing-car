package game;

public class AlwaysNotMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMove() {
        return false;
    }
}
