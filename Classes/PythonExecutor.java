package Classes;

import java.io.IOException;

public class PythonExecutor extends AbstractLanguageExecutor {
    @Override
    public void compile(String pythonFilePath) {
        // Pas de compilation nécessaire pour Python
    }

    @Override
    public void execute(String pythonFilePath) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("py", pythonFilePath);
        Process process = processBuilder.start();
        printProcessOutput(process);
    }
}
