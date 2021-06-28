package view;

import game.domain.Candidate;
import game.domain.Winner;

public class OutputView {

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public void askRaceCount() {
        System.out.println("\n시도할 횟수는 몇 회인가요?");
    }

    public void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    public void printOneRoundResult(Candidate candidate) {
        System.out.println(candidate);
        System.out.println();
    }

    public void printWinners(Winner winner) {
        System.out.print(winner);
        System.out.println("(이)가 최종 우승했습니다.");
    }

}