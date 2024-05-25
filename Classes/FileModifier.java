package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileModifier {
    public static void writeToFile(String fileName, String code) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static String integrateUserCode(String originalCode, String userCode, String marker) {
        return originalCode.replace(marker, userCode);
    }


    public static boolean compareOutputs(String userOutputFile, String expectedOutputFile) throws IOException {
        try (BufferedReader userReader = new BufferedReader(new FileReader(userOutputFile));
             BufferedReader expectedReader = new BufferedReader(new FileReader(expectedOutputFile))) {

            String userLine;

            String expectedLine = null;

            while ((userLine = userReader.readLine()) != null && (expectedLine = expectedReader.readLine()) != null) {
                if (!userLine.equals(expectedLine)) {
                    return false;
                }
            }

            return userLine == null && expectedLine == null;
        }
    }

    public static void saveOutput(Process process, String outputFile) throws IOException, InterruptedException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
             BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {

            String line;
            // Lire et sauvegarder la sortie standard
            while ((line = outputReader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            // Lire et sauvegarder la sortie d'erreur
            while ((line = errorReader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            
            process.waitFor();
        }
    }
}
