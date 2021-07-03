package game.racingcar.controller;

import game.racingcar.domain.RacingCar;
import game.racingcar.service.RacingCarGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarGameController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_NAME_DELIMITER = ",";

    public void play() {
        List<String> racingCarNames = inputCarNames();
        List<RacingCar> racingCars = createRacingCars(racingCarNames);

        int trialNumbers = inputTrialNumbers();

        RacingCarGame racingCarGame = new RacingCarGame(racingCars, trialNumbers);
        racingCarGame.race();

        racingCarGame.printWinner();
    }

    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String inputText = SCANNER.nextLine();

        return Arrays.stream(inputText.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<RacingCar> createRacingCars(List<String> racingCarNames) {
        return racingCarNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private int inputTrialNumbers() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputText = SCANNER.nextLine();

        try {
            return Integer.parseInt(inputText);
        } catch (NumberFormatException e) {
            System.out.println("시도 횟수는 숫자로 입력해 주세요.");
            System.exit(0);
            throw new IllegalArgumentException();
        }
    }

}
