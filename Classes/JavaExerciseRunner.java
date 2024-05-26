package Classes;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaExerciseRunner extends AbstractExerciseRunner {
    public JavaExerciseRunner() {
        super("java", "Exercices/ExoJava");
    }
    @Override
    public String extractFunction(String userCode) {
        // Supposons que la fonction soit définie sur une seule ligne avec le format "public int nom_fonction(int paramètres)"
        String[] lines = userCode.split("\\r?\\n");
        for (String line : lines) {
            if (line.trim().startsWith("public") && line.trim().endsWith("{")) {
                return line.trim();
            }
        }
        return null; // Retourne null si aucune fonction n'est trouvée
    }

    @Override
    public int callFunction(String functionCode, int... args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("java");
        String script = functionCode + "\n"; // Ajoutez le code de la fonction à exécuter
        for (int arg : args) {
            script += arg + "\n"; // Ajoutez chaque argument sur une nouvelle ligne
        }
        return (int) engine.eval(script);
    }
}