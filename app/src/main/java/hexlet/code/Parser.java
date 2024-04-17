package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws IOException {
        Path pathToFile = Path.of(filePath);
        String extension = getFileExtension(pathToFile);

        return switch (extension) {
            case "json" -> parseJson(pathToFile);
            case "yml", "yaml" -> parseYaml(pathToFile);
            default -> throw new IllegalArgumentException("Данный формат не поддерживается!");
        };
    }

    private static String getFileExtension(Path path) {
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    private static Map<String, Object> parseJson(Path filepath) throws IOException {
        String json = Files.readString(filepath);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<>() { });
    }

    private static Map<String, Object> parseYaml(Path filepath) throws IOException {
        String yaml = Files.readString(filepath);
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(yaml, new TypeReference<>() { });
    }
}
