package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JavaScriptExerciseRunner extends AbstractExerciseRunner {
    public JavaScriptExerciseRunner() {
        super("js", "Exercices/ExoJs");
    }
    
    @Override
    public Object executeWithInputs(String filePath, String[] inputs) throws IOException, InterruptedException {
        // Compiling the Java file
        String compileCommand = "javac " + filePath;
        Process compileProcess = Runtime.getRuntime().exec(compileCommand);
        compileProcess.waitFor();

        // Check if compilation failed
        if (compileProcess.exitValue() != 0) {
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
            String line;
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }
            errorReader.close();
            return null; // Indicate compilation failure
        }

        // Create command to run Java file with Java Runtime
        String command = "java " + filePath.substring(0, filePath.lastIndexOf('.'));

        // Process creation
        Process process = Runtime.getRuntime().exec(command);

        // Write inputs in the process input stream
        for (String input : inputs) {
            process.getOutputStream().write((input + System.lineSeparator()).getBytes());
        }
        process.getOutputStream().flush();
        process.getOutputStream().close();

        // Output stream recovery
        BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        // Retrieve execution result
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = outputReader.readLine()) != null) {
            result.append(line).append(System.lineSeparator());
        }

        // Read errors if any
        while ((line = errorReader.readLine()) != null) {
            System.err.println(line);
        }

        // Wait for process execution to finish
        process.waitFor();

        // Closing flows
        outputReader.close();
        errorReader.close();

        // Result feedback
        return result.toString();
    }
}

