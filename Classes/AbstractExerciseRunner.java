package Classes;






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
        return "Exo" + exerciseChoice + "_utilisateur." + fileExtension;
    }

    public String[] getFilePaths(int exerciseChoice) {
        return new String[]{filePath + "/Exo" + exerciseChoice + "_utilisateur." + fileExtension};
    }
}
