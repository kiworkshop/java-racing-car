package com.mission2.racingcar;


import java.util.Scanner;

public class CarRacing {
    static final int MAX_NAME_COUNT = 5;
    static final int MAX_GAME_COUNT = 10;
    static final String DELIMITER = ",";

    private static final CarRacingService service = new CarRacingService();

    public static void main(String[] args) {
        String[] carNamesSplit = getCarNames();
        int gameCount = getGameCount();



    }

    private static String[] getCarNames() {
        String message = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
        String[] carNames = getUserInput(message).split(DELIMITER);

        while (!service.checkCarNames(carNames, MAX_NAME_COUNT)) {
            System.out.println("자동차 이름은 " + MAX_NAME_COUNT + "글자를 넘을 수 없습니다.");
            carNames = getUserInput(message).split(DELIMITER);
        }
        return carNames;
    }

    /**
     * TODO Integer Exception 추가 필요
     *
     * @return
     */
    private static int getGameCount() {
        String message = "시도할 회수는 몇회인가요?";
        int count = Integer.parseInt(getUserInput(message));

        while (count > MAX_GAME_COUNT) {
            System.out.println("게임 횟수는 " + MAX_GAME_COUNT + "회를 넘을 수 없습니다.");
            count = Integer.parseInt(getUserInput(message));
        }
        return count;
    }


    private static String getUserInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
