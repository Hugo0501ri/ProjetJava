package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.ScriptException;

public class CExerciseRunner extends AbstractExerciseRunner {
    public CExerciseRunner() {
        super("c", "Exercices/ExoC");
    }
    @Override
    public String extractFunction(String userCode) {
        // Suppose the function is defined on a single line with the format “int function_name(int parameters) {”.
        String[] lines = userCode.split("\\r?\\n");
        for (String line : lines) {
            if (line.trim().startsWith("int") && line.trim().endsWith("{")) {
                return line.trim();
            }
        }
        return null; // Returns null if no function is found
    }

    @SuppressWarnings("deprecation")
    @Override
    public int callFunction(String functionCode, int... args) {
        String fileName = "temp.c";
        String command = "gcc -o temp temp.c && ./temp"; // Command to compile and execute the C file

        // Write code to a temporary file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(functionCode);
        }

        // Compile and run the C file
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();

        // Read process output
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        // Delete temporary file
        File file = new File(fileName);
        file.delete();

        return Integer.parseInt(output.toString().trim());
    }
    @Override
    public int callFunction(String functionCode, String... inputs)
            throws ScriptException, IOException, InterruptedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'callFunction'");
    }
}