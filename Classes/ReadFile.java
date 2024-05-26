package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    // Méthode pour générer le chemin du fichier en fonction du langage et de l'exercice
    public String getFilePath(int exerciseChoice, int languageChoice, String fileType) {
        String baseDir = "Exercices";
        String filePath = "";

        switch (languageChoice) {
            case 1:
                filePath = baseDir + "/ExoPy/Exo" + exerciseChoice + "Py/" + fileType + exerciseChoice + "py.txt";
                break;
            case 2:
                filePath = baseDir + "/ExoJava/Exo" + exerciseChoice + "Java/" + fileType + exerciseChoice + "java.txt";
                break;
            case 3:
                filePath = baseDir + "/ExoJs/Exo" + exerciseChoice + "JS/" + fileType + exerciseChoice + "js.txt";
                break;
            case 4:
                filePath = baseDir + "/ExoPHP/Exo" + exerciseChoice + "PHP/" + fileType + exerciseChoice + "php.txt";
                break;
            case 5:
                filePath = baseDir + "/ExoC/Exo" + exerciseChoice + "C/" + fileType + exerciseChoice + "c.txt";
                break;
        }
        return filePath;
    }

    // Méthode pour lire et afficher le contenu du fichier data
    public void readFileData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Contenu de " + filePath + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier: " + e.getMessage());
        }
    }
}
