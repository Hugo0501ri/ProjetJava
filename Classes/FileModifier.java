package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Responsible for modifying files related to user submissions.
 */

public class FileModifier {
  
/**
     * Writes code to the specified file.
     *
     * @param fileName The name of the file to write to.
     * @param code The code to write.
     * @throws IOException If an I/O error occurs.
     */
    
    public static void writeToFile(String fileName, String code) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCodeToFile(String fileName, String userCode, String additionalCode) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(userCode);
            writer.write(additionalCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
     * Reads the contents of the file as a string.
     *
     * @param fileName The name of the file to read.
     * @return The contents of the file as a string.
     * @throws IOException If an I/O error occurs.
     */

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

 /**
     * Integrates user code into the original code using the specified marker.
     *
     * @param originalCode The original code.
     * @param userCode The user code to integrate.
     * @param marker The marker indicating where to integrate the user code.
     * @return The integrated code.
     */

    public static String integrateUserCode(String originalCode, String userCode, String marker) {
        return originalCode.replace(marker, userCode);
    }

    

   /**
     * Saves the output of a process to the specified file.
     *
     * @param process The process whose output to save.
     * @param outputFile The file to save the output to.
     * @throws IOException If an I/O error occurs.
     */

    public static void saveOutput(Process process, String outputFile) throws IOException, InterruptedException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
             BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {

            String line;
            // Read and save standard output
            while ((line = outputReader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            // Read and save error output
            while ((line = errorReader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            process.waitFor();
        }
    }
}

