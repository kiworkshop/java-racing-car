package game.racingcar.domain;

import java.util.Objects;

public class GameCount {
    private int gameCount;

    public GameCount(int gameCount) {
        if (gameCount < 1) {
            throw new IllegalArgumentException("게임 시도 횟수는 양수 값 입니다.");
        }
        this.gameCount = gameCount;
    }

    public GameCount(String gameCount) {
        this(Integer.parseInt(gameCount));
    }

    public int value() {
        return gameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCount gameCount1 = (GameCount) o;
        return gameCount == gameCount1.gameCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameCount);
    }
}
