package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PythonExerciseRunner extends AbstractExerciseRunner {
    public PythonExerciseRunner() {
        super("py", "Exercices/ExoPy");
    }
    @Override
    public Object executeWithInputs(String filePath, String[] inputs) throws IOException, InterruptedException {
        // Create command to execute Python file with Python
        String command = "py " + filePath;

        // Output stream recovery
        Process process = Runtime.getRuntime().exec(command);

        // Output stream recovery
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // Write inputs in the process input stream
        for (Object input : inputs) {
            process.getOutputStream().write(input.toString().getBytes());
            process.getOutputStream().write(System.lineSeparator().getBytes());
        }
        process.getOutputStream().flush();
        process.getOutputStream().close();

        // Retrieve execution result
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line).append(System.lineSeparator());
        }

        // Wait for process execution to finish
        process.waitFor();

        // Closing flows
        reader.close();

        // Result feedback
        return result.toString();
    }
}
