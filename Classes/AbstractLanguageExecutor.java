package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractLanguageExecutor implements LanguageExecutor {
    protected void printProcessOutput(Process process) throws IOException, InterruptedException {
        try (BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;

            // Lire et afficher la sortie
            while ((line = outputReader.readLine()) != null) {
                System.out.println(line);
            }

            // Lire et afficher les erreurs
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            process.waitFor();
        }
    }
}
