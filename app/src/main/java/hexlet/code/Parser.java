package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Path;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;

public class Parser {
    public static Map<String, Object> parseJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
    }

    public static Map<String, Object> parseYaml(String yaml) throws JsonProcessingException {
        YAMLMapper yamlMapper = new YAMLMapper();
        return yamlMapper.readValue(yaml, new TypeReference<Map<String, Object>>() {});
    }

    public static Map<String, Object> parser(String filePath) throws JsonProcessingException {
        Path pathToFile = Path.of(filePath);
        String extension = FilenameUtils.getExtension(pathToFile.toString());

        return switch (extension) {
            case "json" -> parseJson(String.valueOf(pathToFile));
            case "yaml" -> parseYaml(String.valueOf(pathToFile));
            default -> throw new Error("Данный формат не поддерживается!");
        };
    }
}
