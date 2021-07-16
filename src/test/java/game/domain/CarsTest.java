package game.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static game.domain.Cars.CAR_NAME_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {

    @Test
    void Given_CarNameList_When_newCars_Then_GenerateUnmodifiableCarList() {
        // given
        String carOneName = "car1";
        String carTwoName = "car2";
        String inputLine = carOneName + CAR_NAME_DELIMITER + carTwoName;
        Cars cars = new Cars(inputLine);

        // when
        List<Car> unmodifiableCars = cars.getCars();

        // then
        assertThat(unmodifiableCars)
                .isExactlyInstanceOf(Collections.unmodifiableList(new ArrayList<>()).getClass());
        assertThat(unmodifiableCars.size()).isEqualTo(2);
        assertThat(unmodifiableCars.get(0).getName()).isEqualTo(carOneName);
        assertThat(unmodifiableCars.get(1).getName()).isEqualTo(carTwoName);
        assertThrows(UnsupportedOperationException.class, () -> {
            unmodifiableCars.remove(0);
        });
    }

    @Test
    void Given_InputLineWithBlanks_When_newCars_Then_ThrowIllegalArgumentException() {
        // given
        String inputLine = "  ";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(inputLine);
        });
    }

    @Test
    void Given_NullInputLine_When_newCars_Then_ThrowIllegalArgumentException() {
        // given
        String inputLine = null;

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(inputLine);
        });
    }

    @Test
    void Given_EmptyInputLine_When_newCars_Then_ThrowIllegalArgumentException() {
        // given
        String inputLine = "";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(inputLine);
        });
    }

    @Test
    void Given_ValidLengthNameWithSingleBlankAroundName_When_newCars_Then_ReturnTrimmedCarNameList() {
        // given
        String inputLine = "name ";

        // when
        Cars cars = new Cars(inputLine);
        List<Car> unmodifiableCars = cars.getCars();

        // then
        assertThat(unmodifiableCars.size()).isEqualTo(1);
        assertThat(unmodifiableCars.get(0).getName()).isEqualTo("name");
    }

    @Test
    void Given_ValidLengthNameWithMultipleBlanksAroundName_When_parseCarNames_Then_ReturnTrimmedCarNameList() {
        // given
        String inputLine = "    name   ";

        // when
        Cars cars = new Cars(inputLine);
        List<Car> unmodifiableCars = cars.getCars();

        // then
        assertThat(unmodifiableCars.size()).isEqualTo(1);
        assertThat(unmodifiableCars.get(0).getName()).isEqualTo("name");
    }
}
