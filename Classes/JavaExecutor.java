package Classes;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaExecutor extends AbstractLanguageExecutor {
    @Override
    public void compile(String javaFilePath) throws IOException, InterruptedException {
        ProcessBuilder compileProcessBuilder = new ProcessBuilder("javac", javaFilePath);
        Process compileProcess = compileProcessBuilder.start();
        printProcessOutput(compileProcess);
    }


    public void execute(String javaFilePath) throws IOException, InterruptedException {
        String className = javaFilePath.substring(0, javaFilePath.lastIndexOf('.'));
        ProcessBuilder processBuilder = new ProcessBuilder("java", className);
        Process process = processBuilder.start();
        printProcessOutput(process);
    }

    
}
