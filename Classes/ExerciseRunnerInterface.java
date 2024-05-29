package Classes;

import java.io.IOException;
import java.util.List;

import javax.script.ScriptException;

public interface ExerciseRunnerInterface {
    void compile(String fileName, String code);
    void execute(String[] fileNames);
    String getFileName(int exerciseNumber);
    Object executeWithInputs(String filePath, String[] inputsArray) throws IOException, InterruptedException;
    
}

