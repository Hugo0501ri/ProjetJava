package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PHPExerciseRunner extends AbstractExerciseRunner {
    public PHPExerciseRunner() {
        super("php", "Exercices/ExoPhp");
    }
   

    @Override
    public Object executeWithInputs(String filePath, String[] inputs) throws IOException, InterruptedException {
        // Create command to execute PHP script with PHP
        String command = "php " + filePath;

        // Process creation
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

        // Retrieve execution result
        process.waitFor();

        // Closing flows
        reader.close();

        // Result feedback
        return result.toString();
    }
}

