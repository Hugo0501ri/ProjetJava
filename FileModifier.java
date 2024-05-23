import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileModifier {
    public static void writeToFile(String fileName, String content) {
        String filePath = "Exercices/Exo1/" + fileName; // Chemin du fichier
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Le code a été enregistré dans le fichier : " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'enregistrement du fichier.");
        }
    }
}
