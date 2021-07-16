package game.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExceptionMessage {

    EMPTY_INPUT("내용을 입력하세요"),
    CAR_NAME_LENGTH_OUT_OF_BOUND("이름은 1글자 이상 5글자 이하로 입력하세요"),
    NONE_INTEGER_INPUT_FOR_ROUND_COUNT("시도할 횟수는 숫자로 입력하세요"),
    ROUND_COUNT_OUT_OF_BOUND("시도할 횟수는 1회 이상으로 입력하세요");

    @Getter
    private final String message;
}
