package Classes;

import java.io.IOException;

public class PHPExecutor extends AbstractLanguageExecutor {
    @Override
    public void compile(String phpFilePath) {
        // No compilation required for PHP
    }

    @Override
    public void execute(String phpFilePath) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("php", phpFilePath);
        Process process = processBuilder.start();
        printProcessOutput(process);
    }
}
