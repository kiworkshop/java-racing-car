package game.util;

public class StringUtil {

    private static final String BLANK = " ";

    public static String alignLeft(String name, int alignStandard) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        for (int i = name.length(); i < alignStandard; i++) {
            sb.append(BLANK);
        }
        return sb.toString();
    }

    public static String repeat(String chunk, int repeatCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            sb.append(chunk);
        }
        return sb.toString();
    }
}
