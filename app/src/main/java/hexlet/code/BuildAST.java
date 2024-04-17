package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.stream.Collectors;

public class BuildAST {
    private static ArrayList<String> getUnionKeys(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new HashSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        ArrayList<String> listKeys = new ArrayList<>(keys);
        Collections.sort(listKeys);

        return listKeys;
    }

    private static HashMap<String, Object> getDifferenceResult(Map<String, Object> data1, Map<String, Object> data2, String key) {
        String value1 = String.valueOf(data1.get(key));
        String value2 = String.valueOf(data2.get(key));

        if (!data2.containsKey(key)) {
            return createDiffEntry(key, value1, "deleted");
        } else if (!data1.containsKey(key)) {
            return createDiffEntry(key, value2, "added");
        } else if (!value1.equals(value2)) {
            return createDiffEntryWithOldAndNewValues(key, value1, value2);
        }

        return createDiffEntry(key, value1, "unchanged");
    }

    private static HashMap<String, Object> createDiffEntry(String key, String value, String status) {
        HashMap<String, Object> diffEntry = new HashMap<>();
        diffEntry.put("key", key);
        diffEntry.put("value", value);
        diffEntry.put("status", status);
        return diffEntry;
    }

    private static HashMap<String, Object> createDiffEntryWithOldAndNewValues(String key, String oldValue, String newValue) {
        HashMap<String, Object> diffEntry = new HashMap<>();
        diffEntry.put("key", key);
        diffEntry.put("oldValue", oldValue);
        diffEntry.put("newValue", newValue);
        diffEntry.put("status", "changed");
        return diffEntry;
    }

    public static ArrayList<HashMap<String, Object>> generateDiffObj(Map<String, Object> data1, Map<String, Object> data2) {
        ArrayList<String> listKeys = getUnionKeys(data1, data2);

        return listKeys.stream()
                .map((key) -> getDifferenceResult(data1, data2, key))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
