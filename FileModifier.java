import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileModifier {
    public static void writeToFile(String fileName, String content, int exerciseChoice, int languageChoice) {
        String filePath;
        switch (languageChoice) {
            case 1:
                // Python
                filePath = "Exercices/ExoPython/";
                break;
            case 2:
                // Java
                filePath = "Exercices/ExoJava/";
                break;
            case 3:
                // Javascript
                filePath = "Exercices/Exo1/";
                break;
            case 4:
                // PHP
                filePath = "Exercices/ExoPHP/";
                break;
            case 5:
                // C
                filePath = "Exercices/ExoC/";
                break;
            default:
                System.out.println("Langage non pris en charge.");
                return;
        }
        switch (exerciseChoice) {
            case 1:
                filePath += "exo1_utilisateur." + getFileExtension(languageChoice);
                break;
            case 2:
                filePath += "exo2_utilisateur." + getFileExtension(languageChoice);
                break;
            default:
                System.out.println("Exercice non pris en charge.");
                return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Le code a été enregistré dans le fichier : " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'enregistrement du fichier.");
        }
    }

    private static String getFileExtension(int languageChoice) {
        switch (languageChoice) {
            case 1:
                return "py";
            case 2:
                return "java";
            case 3:
                return "js";
            case 4:
                return "php";
            case 5:
                return "c";
            default:
                return "";
        }
    }
}