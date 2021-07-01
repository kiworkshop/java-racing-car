package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    @DisplayName("이름 목록이 적힌 문자열을 받아 이름 목록 객체를 생성한다.")
    void create() {
        //given
        String nameList = "pobi, tobi, kobi";

        //when
        Names names = new Names(nameList);

        //then
        assertThat(names.list().size()).isEqualTo(3);
    }
}
