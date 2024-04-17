package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.HashMap;

public class Plain {
    private static String getFormattedValue(String value) {
        if (value.startsWith("{") || value.startsWith("[")) {
            return "[complex value]";
        }
        if (value.equals("false") || value.equals("true")) {
            return value;
        }
        if (value.equals("null")) {
            return value;
        }
        return "'" + value + "'";
    }

    public static String formatDiff(ArrayList<HashMap<String, Object>> diffObj) {
        StringBuilder stringBuilder = new StringBuilder();

        for (HashMap<String, Object> obj : diffObj) {
            String key = String.valueOf(obj.get("key"));
            String status = obj.get("status").toString();
            String formattedValue = getFormattedValue(String.valueOf(obj.get("value")));
            String oldValue = getFormattedValue(String.valueOf(obj.get("oldValue")));
            String newValue = getFormattedValue(String.valueOf(obj.get("newValue")));

            switch (status) {
                case "deleted":
                    stringBuilder.append(String.format(
                            "Property '%s' was %s\n", key, "removed"
                    ));
                    break;
                case "added":
                    stringBuilder.append(String.format(
                            "Property '%s' was %s with value: %s\n", key, "added", formattedValue
                    ));
                    break;
                case "changed":
                    stringBuilder.append(String.format(
                            "Property '%s' was %s. From %s to %s\n", key, "updated", oldValue, newValue
                    ));
                    break;
                default:
                    break;
            }
        }

        return stringBuilder.toString().trim();
    }
}
