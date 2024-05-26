package Classes;

import java.io.*;

public class CLanguage extends ProgrammingLanguage{
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
    public int callFunction(String functionCode, int... args) throws IOException, InterruptedException {
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
}

