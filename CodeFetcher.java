import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeFetcher {
    public static void codefetcher(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // Lecture du code Python saisi par l'utilisateur
            System.out.println("Veuillez saisir du code Python (entrez 'exit' pour quitter) :");
            String line;
            StringBuilder pythonCode = new StringBuilder();
            while (!(line = reader.readLine()).equals("exit")) {
                pythonCode.append(line).append("\n");
            }

            // Affichage du code Python saisi par l'utilisateur
            System.out.println("Code Python saisi :");
            System.out.println(pythonCode.toString());

            // Exécution du code Python
            Process process = Runtime.getRuntime().exec("python");
            process.getOutputStream().write(pythonCode.toString().getBytes());
            process.getOutputStream().close();

            // Lecture de la sortie de Python
            BufferedReader pythonOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String outputLine;
            System.out.println("Sortie de Python :");
            while ((outputLine = pythonOutput.readLine()) != null) {
                System.out.println(outputLine);
            }

            // Fermeture des flux
            pythonOutput.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
