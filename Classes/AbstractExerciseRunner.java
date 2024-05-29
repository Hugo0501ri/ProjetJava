package Classes;

import java.io.IOException;
import java.util.List;

public abstract class AbstractExerciseRunner implements ExerciseRunnerInterface {
    protected String fileExtension;
    protected String filePath;

    public AbstractExerciseRunner(String fileExtension, String filePath) {
        this.fileExtension = fileExtension;
        this.filePath = filePath;
    }

    public void compile(String fileName, String code) {
        FileModifier.writeToFile(fileName, code);
    }

    public void execute(String[] fileNames) {
        CodeRunner.runCodeFromFiles(fileNames);
    }

    public String getFileName(int exerciseChoice) {
        return filePath + "/Exo" + exerciseChoice + fileExtension + "/Exo" + exerciseChoice + "_utilisateur." + fileExtension;
    }

       // This method should be implemented by subclasses
    public abstract Object executeWithInputs(String filePath, String[] inputs) throws IOException, InterruptedException;
}

