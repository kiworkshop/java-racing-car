package game.view;

import game.view.dto.OneRoundResultDto;
import game.view.dto.WinnerDto;

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

    public void printOneRoundResult(OneRoundResultDto oneRoundResultDto) {
        System.out.println();   // TODO
    }

    public void printWinners(WinnerDto winnerDto) {
        System.out.print(winnerDto);    // TODO
        System.out.println("(이)가 최종 우승했습니다.");
    }

}