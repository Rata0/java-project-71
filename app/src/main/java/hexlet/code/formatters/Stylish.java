package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.HashMap;

public class Stylish {
    private static final String ADD = "+ ";
    private static final String DELETE = "- ";
    private static final String UNCHANGED = "  ";

    private static void appendDifference(StringBuilder builder, String label, String key, String value) {
        String space = " ".repeat(2);
        builder
                .append(space)
                .append(label)
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
                    appendDifference(builder, DELETE, key, value);
                    break;
                case "added":
                    appendDifference(builder, ADD, key, value);
                    break;
                case "changed":
                    String oldValue = diff.get("oldValue").toString();
                    String newValue = diff.get("newValue").toString();
                    appendDifference(builder, DELETE, key, oldValue);
                    appendDifference(builder, ADD, key, newValue);
                    break;
                default:
                    appendDifference(builder, UNCHANGED, key, value);
            }
        });

        builder.append("}");

        return builder.toString();
    }
}