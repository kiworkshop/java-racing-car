import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    private static Game game = new Game();

    @Test
    void 이동횟수만큼_자동차_움직이기() {
        // given
        List<Car> cars = new ArrayList<>();
        int repeatCount = 2;

        // when
//        cars = game.moveCars(cars, repeatCount);

//        List<Car> winners = game.findWinners(cars);

        // then

    }

    @Test
    void 한번_자동차_움직이기() {
        // given
        String car1Name = "car1";
        String car2Name = "car2";
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(car1Name));
        cars.add(new Car(car2Name));

        // when
//        cars = game.race(cars);

        // then
//        asser
    }

    @Test
    void 승자_자동차_찾기() {
    }
}
