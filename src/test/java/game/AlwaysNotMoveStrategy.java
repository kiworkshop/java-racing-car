package game;

public class AlwaysNotMoveStrategy implements RandomStrategy{
    @Override
    public boolean isMove() {
        return false;
    }
}
