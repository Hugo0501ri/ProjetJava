package Classes;

import java.io.IOException;

import javax.script.ScriptException;

public interface ExerciseRunnerInterface {
    void compile(String fileName, String code);
    void execute(String[] fileNames);
    String getFileName(int exerciseNumber);
    String[] getFilePaths(int exerciseNumber);
    String extractFunction(String userCode);
    int callFunction(String functionCode, String... inputs) throws ScriptException, IOException, InterruptedException;
}

