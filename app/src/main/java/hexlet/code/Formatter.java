package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.ArrayList;
import java.util.HashMap;

public class Formatter {
    public static String format(ArrayList<HashMap<String, Object>> diffObj, String titleFormat) {
        return switch (titleFormat) {
            case "stylish" -> Stylish.formatDiff(diffObj);
            case "plain" -> Plain.formatDiff(diffObj);
            default -> throw new Error("Данный формат не поддерживается!");
        };
    }
}
