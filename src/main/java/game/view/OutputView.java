package game.view;

import game.domain.Car;
import game.view.dto.OneRoundResultDto;
import game.view.dto.WinnerDto;
import util.StringUtil;

public class OutputView {

    private static final int NAME_ALIGN_STANDARD = 5;
    private static final String POSITION_MARK = "-";
    private static final String COLON = ": ";
    private static final String COMMA = ", ";
    private static final String INLINE = "\n";

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
        StringBuilder sb = new StringBuilder();
        for (Car car : oneRoundResultDto.getCars()) {
            sb.append(StringUtil.alignLeft(car.getName(), NAME_ALIGN_STANDARD))
                    .append(COLON)
                    .append(StringUtil.repeat(POSITION_MARK, car.getPosition()))
                    .append(INLINE);
        }
        System.out.println(sb);
    }

    public void printWinners(WinnerDto winnerDto) {
        StringBuilder winnerNames = new StringBuilder();
        for (Car winner : winnerDto.getWinners()) {
            winnerNames.append(winner.getName()).append(COMMA);
        }
        System.out.print(removeCommaAtTheEnd(winnerNames));
        System.out.println("(이)가 최종 우승했습니다.");
    }

    private String removeCommaAtTheEnd(StringBuilder winnerNames) {
        return winnerNames.substring(0, winnerNames.length() - COMMA.length());
    }
}