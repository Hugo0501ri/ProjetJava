package Classes;



import java.io.IOException;


public class JavaScriptExecutor extends AbstractLanguageExecutor {
    @Override
    public void compile(String jsFilePath) {
        // No compilation required for JavaScript
    }

    @Override
    public void execute(String jsFilePath) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("node", jsFilePath);
        Process process = processBuilder.start();
        printProcessOutput(process);
    }
}
