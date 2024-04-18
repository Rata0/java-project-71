package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.HashMap;

public class Plain {
    private static String formattedValue(Object value) {
        if (value instanceof String) {
            String strValue = (String) value;
            if (strValue.matches("-?\\d+(\\.\\d+)?")) {
                return strValue;
            }
            if (strValue.startsWith("{") || strValue.startsWith("[")) {
                return "[complex value]";
            }
            if ("false".equals(strValue) || "true".equals(strValue) || "null".equals(strValue)) {
                return strValue;
            }
            return "'" + value + "'";
        }
        return String.valueOf(value);
    }

    public static String formatDiff(ArrayList<HashMap<String, Object>> diffObj) {
        StringBuilder stringBuilder = new StringBuilder();

        for (HashMap<String, Object> obj : diffObj) {
            String key = String.valueOf(obj.get("key"));
            String status = obj.get("status").toString();
            Object value = obj.get("value");
            Object oldValue = obj.get("oldValue");
            Object newValue = obj.get("newValue");

            switch (status) {
                case "deleted":
                    stringBuilder.append(String.format(
                            "Property '%s' was %s\n", key, "removed"
                    ));
                    break;
                case "added":
                    stringBuilder.append(String.format(
                            "Property '%s' was %s with value: %s\n", key, "added", formattedValue(value)
                    ));
                    break;
                case "changed":
                    stringBuilder.append(String.format(
                            "Property '%s' was %s. From %s to %s\n",
                            key, "updated", formattedValue(oldValue), formattedValue(newValue)
                    ));
                    break;
                default:
                    break;
            }
        }

        return stringBuilder.toString().trim();
    }
}
