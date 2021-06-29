package com.mission2.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRacing {

    public static void main(String[] args) {
        CarRacingService service = new CarRacingService();

        String inputCarNames = getUserInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        List<String> carNames = service.splitCarNamesByComma(inputCarNames);
        while (!service.checkCarNames(carNames)) {
            String message = "자동차 이름은 " + CarRacingService.MAX_CAR_COUNT + "글자를 넘을 수 없습니다.";
            carNames = service.splitCarNamesByComma(getUserInput(message));
        }

        String inputGameCount = getUserInput("시도할 회수는 몇회인가요?");
        int gameCount = service.getGameCount(inputGameCount);
        while (!service.checkGameCount(gameCount)) {
            String message = "게임 횟수는 " + CarRacingService.MAX_GAME_COUNT + "회를 넘을 수 없습니다.";
            gameCount = service.getGameCount(getUserInput(message));
        }

        service.game(carNames, gameCount);
    }

    /**
     * Scanner 통해 사용자에게 입력 받는다.
     */
    public static String getUserInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine().trim();
    }

}
