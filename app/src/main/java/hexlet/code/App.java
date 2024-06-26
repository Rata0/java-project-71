package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@Command(name = "gendiff", version = "1.0", description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Parameters(description = "path to first file")
    private String filepath1;

    @Parameters(description = "path to second file")
    private String filepath2;

    @Option(names = { "-f", "format" }, description = "output format [default: stylish]")
    private String format = "stylish";
    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequired;

    @Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    private boolean versionRequested;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    /**
     * Indicates whether help is requested.
     *
     * @return {@code true} if help is requested, {@code false} otherwise.
     */
    public boolean isHelpRequired() {
        return helpRequired;
    }

    /**
     * Indicates whether version information is requested.
     *
     * @return {@code true} if version information is requested, {@code false} otherwise.
     */
    public boolean isVersionRequested() {
        return versionRequested;
    }

    /**
     * Runs the application. Subclasses may override this method to provide custom behavior.
     * If overridden, ensure to call super.run() to maintain base functionality.
     */
    @Override
    public void run() {
        try {
            String result = Differ.generate(filepath1, filepath2, format);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
