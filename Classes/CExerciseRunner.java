package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.ScriptException;

public class CExerciseRunner extends AbstractExerciseRunner {
    public CExerciseRunner() {
        super("c", "Exercices/ExoC");
    }
    @Override
    public String extractFunction(String userCode) {
        // Supposons que la fonction soit définie sur une seule ligne avec le format "int nom_fonction(int paramètres) {"
        String[] lines = userCode.split("\\r?\\n");
        for (String line : lines) {
            if (line.trim().startsWith("int") && line.trim().endsWith("{")) {
                return line.trim();
            }
        }
        return null; // Retourne null si aucune fonction n'est trouvée
    }

    @SuppressWarnings("deprecation")
    @Override
    public int callFunction(String functionCode, int... args) {
        String fileName = "temp.c";
        String command = "gcc -o temp temp.c && ./temp"; // Commande pour compiler et exécuter le fichier C

        // Écriture du code dans un fichier temporaire
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(functionCode);
        }

        // Compilation et exécution du fichier C
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();

        // Lecture de la sortie du processus
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        // Suppression du fichier temporaire
        File file = new File(fileName);
        file.delete();

        return Integer.parseInt(output.toString().trim());
    }
    @Override
    public int callFunction(String functionCode, String... inputs)
            throws ScriptException, IOException, InterruptedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'callFunction'");
    }
}