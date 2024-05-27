package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CExerciseRunner extends AbstractExerciseRunner {
    public CExerciseRunner() {
        super("c", "Exercices/ExoC");
    }

    @Override
    public Object executeWithInputs(String filePath, String[] inputs) throws IOException, InterruptedException {
        // Compilation du fichier C en un exécutable
        String executablePath = filePath.substring(0, filePath.lastIndexOf('.')) + ".exe";
        Process compileProcess = Runtime.getRuntime().exec("gcc " + filePath + " -o " + executablePath);
        compileProcess.waitFor();

        // Création du processus pour exécuter l'exécutable
        Process process = Runtime.getRuntime().exec(executablePath);

        // Récupération du flux de sortie
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // Ecriture des inputs dans le flux d'entrée du processus
        for (Object input : inputs) {
            process.getOutputStream().write(input.toString().getBytes());
            process.getOutputStream().write(System.lineSeparator().getBytes());
        }
        process.getOutputStream().flush();
        process.getOutputStream().close();

        // Récupération du résultat de l'exécution
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line).append(System.lineSeparator());
        }

        // Attente de la fin de l'exécution du processus
        process.waitFor();

        // Fermeture des flux
        reader.close();

        // Retour du résultat
        return result.toString();
    }
}


    
