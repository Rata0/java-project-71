package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@Command(name = "gendiff", version = "1.0",description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Parameters(description = "path to first file")
    private String filepath1;

    @Parameters(description = "path to second file")
    private String filepath2;

    @Option(names = { "-f", "format" }, description = "output format [default: stylish]")
    private String format = "stylish";
    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    boolean helpRequired;

    @Option(names = { "-V", "--version" }, versionHelp = true,description = "Print version information and exit.")
    boolean versionRequested;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        try {
            String result = Differ.generate(filepath1, filepath2);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
