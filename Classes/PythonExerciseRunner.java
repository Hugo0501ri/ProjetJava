package Classes;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PythonExerciseRunner extends AbstractExerciseRunner {
    public PythonExerciseRunner() {
        super("py", "Exercices/ExoPy");
    }
    @Override
    public String extractFunction(String userCode) {
        // Suppose the function is defined on a single line with the format “def function_name(parameters):”.
        String[] lines = userCode.split("\\r?\\n");
        for (String line : lines) {
            if (line.trim().startsWith("def")) {
                return line.trim();
            }
        }
        return null; // Returns null if no function is found
    }

    @Override
    public int callFunction(String functionCode, int... args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("python");
        String script = functionCode + "\n"; // Add the code of the function to be executed
        for (int arg : args) {
            script += arg + "\n"; // Add each argument on a new line
        }
        return (int) engine.eval(script);
    }
}
