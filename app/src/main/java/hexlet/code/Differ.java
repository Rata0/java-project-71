package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Differ {
    public static void main(String[] args) throws IOException {
        System.out.println(generate("src/test/resources/file1.json", "src/test/resources/file2.json", "stylish"));
    }
    public static String generate(String file1, String file2, String titleFormat) throws IOException {
        Map<String, Object> dataFile1 = Parser.parse(file1);
        Map<String, Object> dataFile2 = Parser.parse(file2);
        ArrayList<HashMap<String, Object>> diffObj = BuildAST.generateDiffObj(dataFile1, dataFile2);
        return Formatter.format(diffObj, titleFormat);
    }

    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
    }
}
