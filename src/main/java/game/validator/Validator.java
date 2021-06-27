package game.validator;

import view.dto.ViewDto;

public class Validator {

    public static void validate(ViewDto viewDto) {
        if (!CarNameValidator.isValid(viewDto.getCarNames())) {
            throw new RuntimeException("[ERROR] 이름은 1글자 이상 5글자 이하로 입력하세요");
        }

        if (!RaceCountValidator.isValid(viewDto.getRaceCount())) {
            throw new RuntimeException("[ERROR] 시도할 횟수는 1회 이상으로 입력하세요");
        }
    }
}
