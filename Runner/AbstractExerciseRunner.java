import CodeRunner;
import FileModifier;

package Runner;
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

    public String getFileName(int exerciseNumber) {
        return "exo" + exerciseNumber + "_utilisateur." + fileExtension;
    }

    public String[] getFilePaths(int exerciseNumber) {
        return new String[]{filePath + "/exo" + exerciseNumber + "_utilisateur." + fileExtension};
    }
}
