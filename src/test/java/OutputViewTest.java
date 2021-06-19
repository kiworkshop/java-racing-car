import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;


    @Test
    void 레이스_실행_결과_출력() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1", 1));
        cars.add(new Car("car22", 0));
        cars.add(new Car("car", 4));
        // when

        OutputView outputView = new OutputView();
        outputView.printRaceResult(cars);
        // then
        assertEquals("car1  : -", outputStreamCaptor.toString().trim());
    }
}
