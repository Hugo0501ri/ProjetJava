package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JavaExerciseRunner extends AbstractExerciseRunner {
    public JavaExerciseRunner() {
        super("java", "Exercices/ExoJava");
    }

    @Override
    public Object executeWithInputs(String filePath, String[] inputs) throws IOException, InterruptedException {
        // Compilation du fichier Java
        String compileCommand = "javac " + filePath;
        Process compileProcess = Runtime.getRuntime().exec(compileCommand);
        compileProcess.waitFor();

        // Vérifiez si la compilation a échoué
        if (compileProcess.exitValue() != 0) {
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
            String line;
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }
            errorReader.close();
            return null; // Indiquer l'échec de la compilation
        }

        // Exécution du fichier Java
        String className = filePath.substring(filePath.lastIndexOf('/') + 1, filePath.lastIndexOf('.'));
        String command = "java -cp Exercices/ExoJava " + className;

        Process process = Runtime.getRuntime().exec(command);

        // Écriture des inputs dans le flux d'entrée du processus
        for (String input : inputs) {
            process.getOutputStream().write((input + System.lineSeparator()).getBytes());
        }
        process.getOutputStream().flush();
        process.getOutputStream().close();

        // Récupération du flux de sortie
        BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        // Récupération du résultat de l'exécution
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = outputReader.readLine()) != null) {
            result.append(line).append(System.lineSeparator());
        }

        // Lire les erreurs s'il y en a
        while ((line = errorReader.readLine()) != null) {
            System.err.println(line);
        }

        // Attente de la fin de l'exécution du processus
        process.waitFor();

        // Fermeture des flux
        outputReader.close();
        errorReader.close();

        // Retour du résultat
        return result.toString();
    }
    
}