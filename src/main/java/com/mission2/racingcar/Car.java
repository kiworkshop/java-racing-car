package com.mission2.racingcar;

public class Car {
    public static final int FORWARD_STANDARD = 4;

    private String name;
    private int score;

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    /**
     * Random 값을 비교한다.
     * - (0,1,2,3) 이면 정지, (4,5,6,7,7,8,9) 이면 전진
     */
    public int stopOrGoByRandomNumber(int randomNumber) {
        return (randomNumber < FORWARD_STANDARD) ? 0 : 1;
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
