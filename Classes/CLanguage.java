package Classes;

import java.io.*;

public class CLanguage extends ProgrammingLanguage {
    @Override
    public String extractFunction(String userCode) {
        // Assume that the function is defined on a single line with the format "int function_name(int parameters) {"
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
    public int callFunction(String functionCode, int... args) throws IOException, InterruptedException {
        String fileName = "temp.c";
        String command = "gcc -o temp temp.c && ./temp"; // Command to compile and execute the C file

        // Write the code to a temporary file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(functionCode);
        }

        // Compile and execute the C file
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();

        // Read the output of the process
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        // Delete the temporary file
        File file = new File(fileName);
        file.delete();

        return Integer.parseInt(output.toString().trim());
    }
}


