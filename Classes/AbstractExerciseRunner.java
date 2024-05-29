package Classes;

import java.io.IOException;
import java.util.List;

/**
 * Abstract class that defines methods to compile and execute code for exercises.
 */

public abstract class AbstractExerciseRunner implements ExerciseRunnerInterface {
    protected String fileExtension;
    protected String filePath;

    /**
     * Constructs an AbstractExerciseRunner with the specified file extension and file path.
     *
     * @param fileExtension The file extension used for the code files.
     * @param filePath The file path where the code files are located.
     */

    public AbstractExerciseRunner(String fileExtension, String filePath) {
        this.fileExtension = fileExtension;
        this.filePath = filePath;
    }

    /**
     * Compiles the code by writing it to a file with the specified file name.
     *
     * @param fileName The name of the file to which the code will be written.
     * @param code The code to be written to the file.
     */

    public void compile(String fileName, String code) {
        FileModifier.writeToFile(fileName, code);
    }

    /**
     * Executes the code from the specified files.
     *
     * @param fileNames An array of file names containing the code to be executed.
     */

    public void execute(String[] fileNames) {
        CodeRunner.runCodeFromFiles(fileNames);
    }

    /**
     * Generates the file name for the given exercise choice.
     *
     * @param exerciseChoice The choice of exercise.
     * @return The file name for the specified exercise choice.
     */

    public String getFileName(int exerciseChoice) {
        return filePath + "/Exo" + exerciseChoice + fileExtension + "/Exo" + exerciseChoice + "_utilisateur." + fileExtension;
    }

      /**
     * Executes the code with the given inputs. This method should be implemented by subclasses.
     *
     * @param filePath The path to the file to be executed.
     * @param inputs An array of inputs to be used during code execution.
     * @return An object representing the result of the code execution.
     * @throws IOException If an I/O error occurs.
     * @throws InterruptedException If the execution is interrupted.
     */
       // This method should be implemented by subclasses
    public abstract Object executeWithInputs(String filePath, String[] inputs) throws IOException, InterruptedException;
}

