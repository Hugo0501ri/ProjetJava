import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public String getFileNameData(int exerciseNumber) {
        return "data" + exerciseNumber + fileExtension;
    }
    public static void main(String[] args) {

        String fileName = getFileNameData(int exerciseNumber); // Nom du fichier à lire
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Affiche chaque ligne du fichier
            }
        } catch (IOException e) {
            e.printStackTrace(); // Gère les exceptions en cas d'erreur de lecture
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Ferme le fichier après la lecture
                }
            } catch (IOException e) {
                e.printStackTrace(); // Gère les exceptions en cas d'erreur de fermeture
            }
        }
    }
}
