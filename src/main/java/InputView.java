import java.util.Scanner;

public class InputView {

    final Scanner scanner = new Scanner(System.in);

    public String getInput() {
        return scanner.nextLine();
    }
}
