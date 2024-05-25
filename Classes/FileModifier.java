package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileModifier {
    public static void writeToFile(String fileName, String code) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
