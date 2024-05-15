import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

public class CodeFetcher {
    public static void codeFetcher(String[] fileNames) {
        try {
            // Lecture du code Python à partir du fichier
            StringBuilder pythonCode = new StringBuilder();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileNames[0]));
            String line;
            while ((line = fileReader.readLine()) != null) {
                pythonCode.append(line).append("\n");
            }
            fileReader.close();

            // Affichage du code Python lu
            System.out.println("Code Python lu :");
            System.out.println(pythonCode.toString());

            // Exécution du code Python
            ProcessBuilder pb = new ProcessBuilder("py", "-c", pythonCode.toString());
            Process process = pb.start();

            // Lecture de la sortie de Python
            BufferedReader pythonOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader pythonError = new BufferedReader(new InputStreamReader(process.getErrorStream())); // Nouvelle ligne ajoutée

            // Affichage de la sortie d'erreur de Python (si disponible)
            String errorLine;
            boolean errorFound = false;
            System.out.println("Erreur de Python :");
            while ((errorLine = pythonError.readLine()) != null) {
                System.out.println(errorLine);
                errorFound = true;
            }

            if (!errorFound) {
                System.out.println("Aucune");
            }

            // Lecture de la sortie de Python
            String outputLine;
            System.out.println("Sortie de Python :");
            while ((outputLine = pythonOutput.readLine()) != null) {
                System.out.println(outputLine);
            }

            // Fermeture des flux
            pythonOutput.close();
            pythonError.close(); // Fermeture du flux d'erreur
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
