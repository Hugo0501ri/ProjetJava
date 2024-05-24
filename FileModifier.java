import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileModifier {
    /*public static void writeToFile(String fileName, String content, int exerciseChoice, int languageChoice) {
        String filePath;
        switch (languageChoice) {
            case 1:
                // Python
                filePath = "Exercices/ExoPython/";
                switch (exerciseChoice) {
                    case 1:
                        filePath += "Exo1PY/exo1_utilisateur." + getFileExtension(languageChoice);
                        break;
                    case 2:
                        filePath += "Exo2PY/exo2_utilisateur." + getFileExtension(languageChoice);
                        break;
                    default:
                        System.out.println("Exercice non pris en charge.");
                    return;
                }
                break;
            case 2:
                // Java
                filePath = "Exercices/ExoJava/";
                switch (exerciseChoice) {
                    case 1:
                        filePath += "Exo1Java/exo1_utilisateur." + getFileExtension(languageChoice);
                        break;
                    case 2:
                        filePath += "Exo2Java/exo2_utilisateur." + getFileExtension(languageChoice);
                        break;
                    default:
                        System.out.println("Exercice non pris en charge.");
                    return;
                }
                break;
            case 3:
                // Javascript
                filePath = "Exercices/ExoJs/";
                switch (exerciseChoice) {
                    case 1:
                        filePath += "Exo1JS/exo1_utilisateur." + getFileExtension(languageChoice);
                        break;
                    case 2:
                        filePath += "Exo2JS/exo2_utilisateur." + getFileExtension(languageChoice);
                        break;
                    default:
                        System.out.println("Exercice non pris en charge.");
                    return;
                }
                break;
            case 4:
                // PHP
                filePath = "Exercices/ExoPHP/";
                switch (exerciseChoice) {
                    case 1:
                        filePath += "Exo1PHP/exo1_utilisateur." + getFileExtension(languageChoice);
                        break;
                    case 2:
                        filePath += "Exo2PHP/exo2_utilisateur." + getFileExtension(languageChoice);
                        break;
                    default:
                        System.out.println("Exercice non pris en charge.");
                    return;
                }
                break;
            case 5:
                // C
                filePath = "Exercices/ExoC/";
                switch (exerciseChoice) {
                    case 1:
                        filePath += "Exo1C/exo1_utilisateur." + getFileExtension(languageChoice);
                        break;
                    case 2:
                        filePath += "Exo2C/exo2_utilisateur." + getFileExtension(languageChoice);
                        break;
                    default:
                        System.out.println("Exercice non pris en charge.");
                    return;
                }
                break;
            default:
                System.out.println("Langage non pris en charge.");
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
    }*/
    public static void writeToFile(String fileName, String code) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
