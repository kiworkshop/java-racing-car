package com.mission2.racingcar.domain;

public class Car {

    private final String name;
    private int score;
    private final MoveStrategy moveStrategy;

    public Car(String name, int score, MoveStrategy moveStrategy) {
        this.name = name;
        this.score = score;
        this.moveStrategy = moveStrategy;
    }

    private void addScore(int score) {
        this.score += score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public int stopOrGoByRandomNumber(int randomNumber) {
        return (moveStrategy.forward(randomNumber)) ? 1 : 0;
    }

    public void raceByRandomNumber(int randomNumber) {
        addScore(stopOrGoByRandomNumber(randomNumber));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.score; i++) {
            sb.append("-");
        }
        return this.name + " : " + sb.toString();
    }
}
