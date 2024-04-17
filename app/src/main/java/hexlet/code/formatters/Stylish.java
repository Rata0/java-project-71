package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.HashMap;

public class Stylish {
    private static void appendDifference(StringBuilder builder, String sign, String key, String value) {
        String space = " ".repeat(2);
        builder
                .append(space)
                .append(sign)
                .append(key)
                .append(": ")
                .append(value)
                .append("\n");
    }

    public static String formatDiff(ArrayList<HashMap<String, Object>> diffList) {
        StringBuilder builder = new StringBuilder();
        builder.append("{").append("\n");

        diffList.forEach((diff) -> {
            String key = String.valueOf(diff.get("key"));
            String value = String.valueOf(diff.get("value"));
            String status = diff.get("status").toString();

            switch (status) {
                case "deleted":
                    appendDifference(builder, "- ", key, value);
                    break;
                case "added":
                    appendDifference(builder, "+ ", key, value);
                    break;
                case "changed":
                    String oldValue = diff.get("oldValue").toString();
                    String newValue = diff.get("newValue").toString();
                    appendDifference(builder, "- ", key, oldValue);
                    appendDifference(builder,  "+ ", key, newValue);
                    break;
                default:
                    appendDifference(builder, "  ", key, value);
            }
        });

        builder.append("}");

        return builder.toString();
    }
}
