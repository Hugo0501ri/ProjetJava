package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Responsible for reading files.
 */

public class ReadFile {

      /**
     * Gets the file path based on exercise choice, language choice, and file type.
     *
     * @param exerciseChoice The choice of exercise.
     * @param languageChoice The choice of programming language.
     * @param fileType The type of file to retrieve.
     * @return The file path.
     */

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

    /**
     * Reads data from the specified file path.
     *
     * @param filePath The path of the file to read.
     * @return The data read from the file.
     * @throws IOException If an I/O error occurs.
     */

    public void readFileData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier: " + e.getMessage());
        }
    }
}
