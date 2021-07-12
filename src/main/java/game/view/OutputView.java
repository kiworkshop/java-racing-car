package game.view;

import game.domain.Car;
import game.view.dto.RaceResultDto;
import game.view.dto.RoundResultDto;
import game.view.dto.WinnerDto;
import util.StringUtil;

import java.util.List;

public class OutputView {

    private static final int NAME_ALIGN_STANDARD = 5;
    private static final String POSITION_MARK = "-";
    private static final String COLON = ": ";
    private static final String COMMA = ", ";
    private static final String INLINE = "\n";
    private static final String ERROR_HEADER = "[ERROR] ";

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public void askRaceCount() {
        System.out.println("\n시도할 횟수는 몇 회인가요?");
    }

    public void printRaceResult(RaceResultDto raceResultDto) {
        printRaceResultHeader();
        printRoundResults(raceResultDto.getRoundResultDtos());
        printWinners(raceResultDto.getWinnerDto());
    }

    private void printRaceResultHeader() {
        System.out.println("\n실행 결과");
    }

    private void printRoundResults(List<RoundResultDto> roundResultDtos) {
        for (RoundResultDto roundResultDto : roundResultDtos) {
            printOneRoundResult(roundResultDto);
        }
    }

    private void printOneRoundResult(RoundResultDto roundResultDto) {
        StringBuilder sb = new StringBuilder();
        for (Car car : roundResultDto.getCars()) {
            sb.append(StringUtil.alignLeft(car.getName(), NAME_ALIGN_STANDARD))
                    .append(COLON)
                    .append(StringUtil.repeat(POSITION_MARK, car.getPosition()))
                    .append(INLINE);
        }
        System.out.println(sb);
    }

    private void printWinners(WinnerDto winnerDto) {
        StringBuilder winnerNames = new StringBuilder();
        for (Car winner : winnerDto.getCars()) {
            winnerNames.append(winner.getName()).append(COMMA);
        }
        System.out.print(removeCommaAtTheEnd(winnerNames));
        System.out.println("(이)가 최종 우승했습니다.");
    }

    private String removeCommaAtTheEnd(StringBuilder winnerNames) {
        return winnerNames.substring(0, winnerNames.length() - COMMA.length());
    }

    public void printError(String message) {
        System.out.println(ERROR_HEADER + message);
    }
}