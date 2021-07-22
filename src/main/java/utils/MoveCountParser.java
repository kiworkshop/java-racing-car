package utils;

public class MoveCountParser {

    public static void checkTryNo(int tryNo) {
        if (tryNo <= 0) {
            throw new RuntimeException("이동횟수는 문자열이나 음수를 입력할 수 없습니다.");
        }
    }

}
