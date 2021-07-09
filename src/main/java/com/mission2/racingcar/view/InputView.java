package com.mission2.racingcar.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String getUserInput(String message) {
        System.out.println(message);

        return scanner.nextLine();
    }

}
