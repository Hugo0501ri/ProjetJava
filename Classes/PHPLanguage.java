package Classes;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PHPLanguage extends ProgrammingLanguage {
    @Override
    public String extractFunction(String userCode) {
        // Supposons que la fonction soit définie sur une seule ligne avec le format "function nom_fonction(paramètres) {"
        String[] lines = userCode.split("\\r?\\n");
        for (String line : lines) {
            if (line.trim().startsWith("function") && line.trim().endsWith("{")) {
                return line.trim();
            }
        }
        return null; // Retourne null si aucune fonction n'est trouvée
    }

    @Override
    public int callFunction(String functionCode, int... args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("php");
        String script = functionCode + "\n"; // Ajoutez le code de la fonction à exécuter
        for (int arg : args) {
            script += arg + "\n"; // Ajoutez chaque argument sur une nouvelle ligne
        }
        return (int) engine.eval(script);
    }
}
