package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static void main(String[] args) throws IOException {
        String diff = generate("file1.json", "file2.json");
        System.out.println(diff);
    }

    public static String generate(String file1, String file2) throws IOException {
        Map<String, Object> dataFile1 = readFile(file1);
        Map<String, Object> dataFile2 = readFile(file2);
        List<String> differ = differenceMAP(dataFile1, dataFile2);
        StringBuilder result = new StringBuilder("{").append("\n");
        for (String line : differ) {
            result.append(line).append("\n");
        }
        result.append("}");

        return result.toString();
    }

    private static Map<String, Object> parseJSON(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {});
    }

    private static Map<String, Object> readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        String content = Files.readString(path);
        return parseJSON(content);
    }

    private static List<String> differenceMAP(Map<String, Object> map1, Map<String, Object> map2) {
        List<String> result = new ArrayList<>();
        TreeMap<String, Object> sortedMap1 = new TreeMap<>(map1);
        TreeMap<String, Object> sortedMap2 = new TreeMap<>(map2);
        for (Map.Entry<String, Object> entry : sortedMap1.entrySet()) {
            String key = entry.getKey();
            Object value1 = entry.getValue();
            Object value2 = sortedMap2.get(key);
            if (value2 == null) {
                result.add("  - " + key + ": " + value1);
            } else if (value1.equals(value2)) {
                result.add("    " + key + ": " + value1);
            } else {
                result.add("  - " + key + ": " + value1);
                result.add("  + " + key + ": " + value2);
            }
        }
        for (Map.Entry<String, Object> entry : sortedMap2.entrySet()) {
            String key = entry.getKey();
            if (sortedMap1.get(key) == null) {
                result.add("  + " + key + ": " + entry.getValue());
            }
        }
        return result;
    }
}
