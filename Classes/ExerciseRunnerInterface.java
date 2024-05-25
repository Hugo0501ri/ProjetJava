package Classes;

public interface ExerciseRunnerInterface {
    void compile(String fileName, String code);
    void execute(String[] fileNames);
    String getFileName(int exerciseNumber);
    String[] getFilePaths(int exerciseNumber);
    String getOriginalFilePath(int exerciseNumber);
}
