package com.mission2.racingcar;

public class CarRacing {

    public static void main(String[] args) {
        CarRacingService service = new CarRacingService();

        String carNameMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
        String carNamesInput = service.getUserInput(carNameMessage);
        String[] carNames = service.getCarNames(carNamesInput);

        String gameCountMessage = "시도할 회수는 몇회인가요?";
        String gameCountInput = service.getUserInput(gameCountMessage);
        int gameCount = service.getGameCount(gameCountInput);

        Race race = service.initRace(carNames, gameCount);
        service.proceedGame(race);
        String[] winners = service.getWinners(race.getCars());
        service.printWinner(winners);
    }

}
